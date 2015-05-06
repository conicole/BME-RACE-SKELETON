
import java.io.Serializable;
//import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import sun.security.util.Length;


public class Game  implements Serializable {


	private static final long serialVersionUID = 1L;
	private Track track;
	private ArrayList<Car> tabCar;
	int nbCar;
	private List<RepairCar> tabRepairCar;
	int nbRepairCar;
	private ArrayList<Vertex> cellswithGlueOil;


	public Game(){
		tabCar=new ArrayList<Car>();
		tabRepairCar =new ArrayList<RepairCar>();
		nbCar=0;
		nbRepairCar=0;
		cellswithGlueOil =new ArrayList<Vertex>();

	}

	public void setTrack(int x,int y)
	{
		track = new Track(x,y);
	
	}


	public void setTrack(Track trc){
		track = trc;
	}


	public Track getTrack(){
		return track;
	}

	public void add_car(int x,int y){
		tabCar.add( new Car(this,x,y,nbCar));
		nbCar++;
	}

	public void add_car(Car c){
		tabCar.add(c);
		nbCar++;
	}


	public void add_repairCar(int x,int y){
		Segment s=track.getSegment(x, y);
		tabRepairCar.add(new RepairCar(s,nbRepairCar));
		nbRepairCar++;
	}

	//Generates random number
	private static int rand(int aStart, int aEnd){
		Random r = new Random();
		int Low = aStart;
		int High = aEnd;


		return r.nextInt((High+1)-Low) + Low;
	}

	public void generateRepairCar(){
		int x=rand(0,track.getHeight()-1);
		int y=rand(0,track.getLength()-1);
		//just to reduce the probability of generation
		int z=rand(0,200);

		Segment sg=track.getSegment(x,y);
		//generates if the segment is on the track and empty
		if (!sg.isOutOfTrack && !sg.hasObstacle()&& z==4){

			RepairCar rc1 =new RepairCar(sg,nbRepairCar);

			tabRepairCar.add(rc1);

			RepairCarView rcv = new RepairCarView(rc1);

			rc1.setView(rcv); 

			nbRepairCar++;

		}	

	}

	public ICar getCar(int n) throws IndexOutOfBoundsException
	{
		try{
			return tabCar.get(n);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Segment nextSegment(ICar c){

		int h=track.getHeight();
		int l=track.getLength();

		int x = c.getSpeedVector().getSpeedX()+c.getPosition().getX();
		int y = c.getSpeedVector().getSpeedY()+c.getPosition().getY();

		if(x<0) x=0;
		if(x>=h) x=h-1;
		if(y<0) y=0;
		if(y>=l) y=l-1;

		Segment newSegment = track.getSegment(x, y);

		if ( !(newSegment.equals(c.getPosition()))) {
			track.updateCarPosition(c, newSegment);
		}

		else{
			//     System.out.println(  " y :" + c.getPosition().getY() + " sv : " + c.getSpeedVector().getSpeedY() );

		}

		return newSegment;
	}

	public void init_add_glue(int x,int y){
		track.getSegment(x,y).addObstacle(new Glue());
	}

	public void init_add_oil(int x,int y){
		track.getSegment(x,y).addObstacle(new Oil());
	}

	public void init_add_obs(int x,int y){
		track.getSegment(x,y).addObstacle(new Obstacle());
	}

	public void sow_grass(int x,int y){
		track.getSegment(x,y).setOutOfTrack();
	}




	// create the finish line
	public void set_finish_line(int x,int y){

		track.setFinish(x,y);

	}

	public void deleteCar(ICar car){
		this.tabCar.remove(car.getId());
		nbCar--;
	}


	public RepairCar getRepairCar(int i) {
		return tabRepairCar.get(i);
	}

	public void computeRepairCarMove(){
		for(int i=0;i<nbRepairCar;i++)
		{
			//Removes repair car if life time is 0
			if(tabRepairCar.get(i).getLifetime()==0){
				tabRepairCar.get(i).disappear();
				tabRepairCar.remove(i);
				nbRepairCar--;
			}
			else{
				//gets next position
				tabRepairCar.get(i).Move(SP( track,tabRepairCar.get(i).getPosition()));
				//System.out.println("Repair car path "+tabRepairCar.get(i).getPosition().getX() + " " +tabRepairCar.get(i).getPosition().getY());
			}

		}
	}



	public Segment SP(Track t, Segment s) {

		List<Vertex> path = null;
		boolean job=false;
		Vertex[][] v = new Vertex[t.height][t.length];
		for (int i = 0; i < t.height; i++) {
			for (int j = 0; j < t.length; j++) {
				v[i][j] = new Vertex(t.getSegment(i, j));

			}
		}



		//building adjacency list
		for (int i = 0; i < t.height; i++) {
			for (int j = 0; j < t.length; j++) {


				//[][=][]
						//[][x][]
				//[][][]
				if(i+1 < t.height){    
					if (v[i + 1][j]!=null && !v[i + 1][j].getSegment().isOutOfTrack)
						v[i][j].adjacencies.add(new Edge(v[i + 1][j]));
				}

				//[][][]
				//[][x][=]
				//[][][]
				if( j+1 < t.length){ 
					if (!v[i][j + 1].equals(null)  &&  !v[i][j + 1].getSegment().isOutOfTrack)
						v[i][j].adjacencies.add(new Edge(v[i][j + 1]));
				}


				//[][][]
				//[][x][]
				//[][=][]
				if(i-1 >= 0){ 
					if (v[i - 1][j] != null && !v[i - 1][j].getSegment().isOutOfTrack)
						v[i][j].adjacencies.add(new Edge(v[i - 1][j]));
				}

				//[][-][]
				//[=][x][]
				//[][][]
				if(j-1 >=0){ 
					if (v[i][j - 1] != null &&!v[i][j - 1].getSegment().isOutOfTrack)
						v[i][j].adjacencies.add(new Edge(v[i][j - 1]));
				}


			}

		}




			

			Dijkstra.computePaths(v[s.getX()][s.getY()]);
		
			
			//gets all segments with glue or oil patch that need cleaning
			for (int i1=0;i1<t.height;i1++){
				for (int j=0;j<t.length;j++){
					System.out.println("Distance to " +" " +i1+" " +j + ": " + v[i1][j].minDistance);
					if(!t.getSegment(i1, j).isOutOfTrack && !t.getSegment(i1, j).isFinishLine){
						//Stores an abitrary cell with glue or oil
						for (AbstractObstacle l :  t.getSegment(i1, j).SObs){
							if(l.type().equalsIgnoreCase("oil")||l.type().equalsIgnoreCase("glue")){
								cellswithGlueOil.add(v[i1][j]);
								break;
							}

						}

					}

				}
			}

			
			if(cellswithGlueOil.size()!=0){
				//gets cell with min distance from the race car

				Vertex min = cellswithGlueOil.get(0) ;
				for (Vertex l :  cellswithGlueOil){
					if(l.minDistance<min.minDistance){
						min=l;
					}
				}
				path = Dijkstra.getShortestPathTo(min);
				if (path.size()>1)
					return path.get(1).getSegment();
			}

			

	    


	

		 return path.get(path.size()).getSegment();
	}

	// run a step in the game : move all the object according to their speed
	// return while nobody wins
	// 10 -> no more car in the circuit
	// 11 -> game is going on
	// other number : nb of winner.
	public int UpdateGame(){
		if( (nbCar) == 0 ){
			return 10;
		}
		for(int i = 0; i < nbCar; i++){
			if(tabCar.get(i).isWinner()){
				return tabCar.get(i).getId();
			}
			tabCar.get(i).updateCarPosition();
		}
		generateRepairCar();
		computeRepairCarMove();
		
		return 11;
	}

	public TrackView getTrackView(){
		return track.getView();
	}
}
