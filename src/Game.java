

import java.io.Serializable;
//import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import sun.security.util.Length;


public class Game  implements Serializable {

	//Initialization of fields
	private static final long serialVersionUID = 1L;
	private Track track;
	private ArrayList<Car> tabCar;
	int nbCar;
	private List<RepairCar> tabRepairCar;
	int nbRepairCar;
	
	//Game object constructor
	public Game(){
		tabCar=new ArrayList<Car>();
		tabRepairCar =new ArrayList<RepairCar>();
		nbCar=0;
		nbRepairCar=0;
		

		


	}
	
	


	//Setter for track 
	public void setTrack(int x,int y)
	{
		track = new Track(x,y);

	}

	//setter for track
	public void setTrack(Track trc){
		track = trc;
	}


	//getter for track
	public Track getTrack(){
		return track;
	}

	//manually adds car to track
	public void add_car(int x,int y){
		tabCar.add( new Car(this,x,y,nbCar));
		nbCar++;
	}

	//adds car to the track
	public void add_car(Car c){
		tabCar.add(c);
		nbCar++;
	}


	//adds repair car
	public void add_repairCar(int x,int y){
		Segment s=track.getSegment(x, y);
		tabRepairCar.add(new RepairCar(s,track,nbRepairCar));
		nbRepairCar++;
	}

	//Generates random number
	public static int rand(int aStart, int aEnd){
		Random r = new Random();
		int Low = aStart;
		int High = aEnd;


		return r.nextInt((High+1)-Low) + Low;
	}

	//generates a repair car at a given location
	public void generateRepairCar(){
		int x=rand(0,track.getHeight()-1);
		int y=rand(0,track.getLength()-1);
		//just to reduce the probability of generation
		int z=rand(0,60);
		//adds it to segment
		Segment sg=track.getSegment(x,y);
		//generates if the segment is on the track and empty
		if (!sg.isOutOfTrack && !sg.isFinishLine && !containsRaceCarOrRepairCar(sg) && !sg.hasObstacle()&& z==4){

			RepairCar rc1 =new RepairCar(sg,track,nbRepairCar);

			tabRepairCar.add(rc1);
			//intialize repaircarview
			RepairCarView rcv = new RepairCarView(rc1);

			rc1.setView(rcv); 

			nbRepairCar++;

		}	

	}

	//getter for car object
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

	//gets the the next segment for a car
	public Segment nextSegment(ICar c){

		int h=track.getHeight();
		int l=track.getLength();
		//gets speed vector
		int x = c.getSpeedVector().getSpeedX()+c.getPosition().getX();
		int y = c.getSpeedVector().getSpeedY()+c.getPosition().getY();
		//ensures its not more that the max or less than 0
		if(x<0) x=0;
		if(x>=h) x=h-1;
		if(y<0) y=0;
		if(y>=l) y=l-1;
		//assigns new position
		Segment newSegment = track.getSegment(x, y);
		//if car is not already at the given new position then update
		if ( !(newSegment.equals(c.getPosition()))) {
			track.updateCarPosition(c, newSegment);
		}

		else{
			//     System.out.println(  " y :" + c.getPosition().getY() + " sv : " + c.getSpeedVector().getSpeedY() );

		}

		return newSegment;
	}

	//sets the positon of glue manually
	public void init_add_glue(int x,int y){
		track.getSegment(x,y).addObstacle(new Glue());
	}
	//sets the positon of oil manually
	public void init_add_oil(int x,int y){
		track.getSegment(x,y).addObstacle(new Oil());
	}
	//sets the positon of oil manually
	public void init_add_obs(int x,int y){
		Obstacle o =new Obstacle();
		track.getSegment(x,y).addObstacle(o);
		ObstacleView oV = new ObstacleView(o);
		o.setOilView(oV);
		
	}
	//sets segments that are considered out o track
	public void sow_grass(int x,int y){
		track.getSegment(x,y).setOutOfTrack();
	}
	//gets number of cars on the track
	public int getNumberofCars(){
		return nbCar;
	}


	// create the finish line
	public void set_finish_line(int x,int y){

		track.setFinish(x,y);

	}
	//deletes cars
	public void deleteCar(ICar car){
		this.tabCar.remove(car);
		nbCar--;
	}

	//gets a given repair car
	public RepairCar getRepairCar(int i) {
		return tabRepairCar.get(i);
	}
	//computes the next move of a repair car
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
				tabRepairCar.get(i).Move(getshortestPath( track,tabRepairCar.get(i).getPosition()));
				//System.out.println("Repair car path "+tabRepairCar.get(i).getPosition().getX() + " " +tabRepairCar.get(i).getPosition().getY());
			}

		}
	}

	//builds a graph out of the track
	private Vertex[][] buildGraph(Track t, Segment s){
		Vertex[][] v = new Vertex[t.height][t.length];

		//Builds vertices out of every segment
		for (int i = 0; i < t.height; i++) {
			for (int j = 0; j < t.length; j++) {
				v[i][j] = new Vertex(t.getSegment(i, j));

			}
		}



		//building adjacency list
		for (int i = 0; i < t.height; i++) {
			for (int j = 0; j < t.length; j++) {


				//[][][]
				//[][x][]
				//[][=][]
				if(i+1 < t.height){    
					if (v[i + 1][j]!=null && !v[i + 1][j].getSegment().isOutOfTrack && !containsRaceCarOrRepairCar(v[i+1][j].getSegment()))
						v[i][j].adjacencies.add(new Edge(v[i + 1][j]));
				}

				//[][][]
				//[][x][=]
				//[][][]
				if( j+1 < t.length){ 
					if (!v[i][j + 1].equals(null)  &&  !v[i][j + 1].getSegment().isOutOfTrack && !containsRaceCarOrRepairCar(v[i][j+1].getSegment()))
						v[i][j].adjacencies.add(new Edge(v[i][j + 1]));
				}


				//[][=][]
				//[][x][]
				//[][][]
				if(i-1 >= 0){ 
					if (v[i - 1][j] != null && !v[i - 1][j].getSegment().isOutOfTrack && !containsRaceCarOrRepairCar(v[i-1][j].getSegment()))
						v[i][j].adjacencies.add(new Edge(v[i - 1][j]));
				}

				//[][][]
				//[=][x][]
				//[][][]
				if(j-1 >=0){ 
					if (v[i][j - 1] != null &&!v[i][j - 1].getSegment().isOutOfTrack && !containsRaceCarOrRepairCar(v[i][j - 1].getSegment()))
						v[i][j].adjacencies.add(new Edge(v[i][j - 1]));
				}



			}

		}
		return v;

	}

	//gets all segments with oil or glue or obstacle
	private ArrayList<Vertex> getAllTracksWithPatch(Track t, Vertex[][] v){
		ArrayList<Vertex> cellswithGlueOilObstacle = new ArrayList<Vertex>();

		//gets all segments with glue or oil patch that need cleaning
		for (int i1=0;i1<t.height;i1++){
			for (int j=0;j<t.length;j++){
				
				if(!t.getSegment(i1, j).isOutOfTrack && !t.getSegment(i1, j).isFinishLine){
					//Stores an abitrary cell with glue or oil or obstacle
					for (AbstractObstacle l :  t.getSegment(i1, j).SObs){
						if(l.name().equalsIgnoreCase("oil")||l.name().equalsIgnoreCase("glue")||l.name().equalsIgnoreCase("obstacle")){
							cellswithGlueOilObstacle.add(v[i1][j]);
							
							break;
						}

					}

				}

			}
		}

		return cellswithGlueOilObstacle;

	}
	//gets cells containing car or repair car
	public boolean containsRaceCarOrRepairCar(Segment s){

		for (AbstractObstacle l : s.SObs){
			if(l.name().equalsIgnoreCase("car")||l.name().equalsIgnoreCase("repaircar")){
				return true;
			}
		}
		return false;

	}

	//gets shortest path to every segment
	public Segment getshortestPath(Track t, Segment s) {

		ArrayList<Vertex> cellswithGlueOilObstacle;
		List<Vertex> path = null;

		//builds graph of entire track
		Vertex[][] v = buildGraph(t, s);

		//Performs Dijkstras algorithm on graph, we pass source
		Dijkstra.computePaths(v[s.getX()][s.getY()]);

		//get all segments with glue or oil patch
		cellswithGlueOilObstacle= getAllTracksWithPatch( t,  v);

		if(cellswithGlueOilObstacle.size()!=0){
			//gets cell with min distance from the race car

			Vertex min = cellswithGlueOilObstacle.get(0) ;
			for (Vertex l :  cellswithGlueOilObstacle){
				if(l.minDistance<min.minDistance){
					min=l;
				}
			}
			//gets path to min distance cell
			path = Dijkstra.getShortestPathTo(min);
			if (path.size()>1)
				return path.get(1).getSegment();
		}

		return t.getSegment(s.getX(), s.getY());
	}

	// run a step in the game : move all the object according to their speed
	// return while nobody wins
	// 10 -> no more car in the circuit
	// 11 -> game is going on
	// other number : nb of winner.
	public int UpdateGame(){
		if( alldead()){
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

	//determines if all cars are dead
	public boolean alldead(){
		boolean res = true;
		for(int i = 0; i < tabCar.size(); i++){
			res = res && tabCar.get(i).dead;
		}
		return res;
	}
    //gets track view
	public TrackView getTrackView(){
		return track.getView();
	}
}
