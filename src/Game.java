import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import sun.security.util.Length;


public class Game  implements Serializable {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Track track;
  private ArrayList<Car> tabCar;
  int nbCar;
  private List<RepairCar> tabRepairCar;
  int nbRepairCar;


    public Game(){
        tabCar=new ArrayList<Car>();
        tabRepairCar =new ArrayList<RepairCar>();
        nbCar=0;
        nbRepairCar=0;

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
    	tabRepairCar.add(new RepairCar(s, nbRepairCar));
    	nbRepairCar++;
    }
   
    //Generates random number
    private static int rand(int aStart, int aEnd){
    	Random aRandom = new Random();
    	if (aStart > aEnd) {
          throw new IllegalArgumentException("Start cannot exceed End.");
        }
        //get the range, casting to long to avoid overflow problems
        long range = (long)aEnd - (long)aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long)(range * aRandom.nextDouble());
        int randomNumber =  (int)(fraction + aStart);    
       return (int)randomNumber;
      }
      
      
    
    
    public void generateRepairCar(){
    	int x=rand(0,track.getHeight());
    	int y=rand(0,track.getLength());
    	//just to reduce the probability of generation
    	int z=rand(0,4);
    	Segment sg=track.getSegment(x,y);
    	//generates if the segment is on the track and empty
    	if (!sg.isOutOfTrack && !sg.hasObstacle()&& z==4){
    		Segment s=track.getSegment(x, y);
    		tabRepairCar.add(new RepairCar(s, nbRepairCar));
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

        if ( ! (newSegment.equals(c.getPosition()))) {
            track.updateCarPosition(c, newSegment);
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
			tabRepairCar.remove(i);
			nbRepairCar--;
		}
		else{
			tabRepairCar.get(i).setPosition(SP( track,tabRepairCar.get(i).getPosition()));
		}
		
	    }
	}
	

	
	public static Segment SP(Track t, Segment s) {
        List<Vertex> path = null;

        Vertex[][] v = null;
        for (int i = 0; i < t.height; i++) {
            for (int j = 0; j < t.length; i++) {
                v[i][j] = new Vertex(new Segment(i, j));

                //[][=][]
                //[][x][]
                //[][][]
                if (!v[i + 1][j].getSegment().isOutOfTrack)
                    v[i][j].adjacencies.add(new Edge(v[i + 1][j]));

                //[][][=]
                //[][x][]
                //[][][]
                if (!v[i + 1][j + 1].getSegment().isOutOfTrack)
                    v[i][j].adjacencies.add(new Edge(v[i + 1][j + 1]));

                //[][][]
                //[][x][]
                //[=][][]
                if (!v[i - 1][j - 1].getSegment().isOutOfTrack)
                    v[i][j].adjacencies.add(new Edge(v[i - 1][j - 1]));


                //[][][]
                //[][x][]
                //[][=][]
                if (!v[i - 1][j].getSegment().isOutOfTrack)
                    v[i][j].adjacencies.add(new Edge(v[i - 1][j]));


                //[][-][]
                //[=][x][]
                //[][][]

                if (!v[i][j - 1].getSegment().isOutOfTrack)
                    v[i][j].adjacencies.add(new Edge(v[i][j - 1]));


                //[][][]
                //[][x][]
                //[][][=]
                if (!v[i - 1][j + 1].getSegment().isOutOfTrack)
                    v[i][j].adjacencies.add(new Edge(v[i - 1][j + 1]));


                //[=][-][]
                //[][x][]
                //[][][]
                if (!v[i + 1][j - 1].getSegment().isOutOfTrack)
                    v[i][j].adjacencies.add(new Edge(v[i - 1][j + 1]));
            }

        }

        Dijkstra.computePaths(new Vertex(s));


        for (int i = 0; i < t.height; i++) {
            for (int j = 0; j < t.length; i++) {
                System.out.println("Distance to target: " + v[i][j].minDistance);
                path = Dijkstra.getShortestPathTo(v[i][j]);
                System.out.println("Path: " + path);
            }
        }

        return path.get(1).getSegment();
    }
		
      /*  for (int i = x; i < t.getHeight(); i++) {
            for (int j = y; j < t.getLength(); j++) {
                if(source != t.getSegment(i, j))
            	{
                	tabSeg[i][j] = new Segment(i,j);
                	}
            }
         
        }
		
	} 
	

	
	      // Dijkstra's algorithm to find shortest path from s to all other nodes
	      public static int [] dijkstra (WeightedGraph G, int s) {
	         final int [] dist = new int [G.size()];  // shortest known distance from "s"
	         final int [] pred = new int [G.size()];  // preceeding node in path
	         final boolean [] visited = new boolean [G.size()]; // all false initially
	   
	         for (int i=0; i<dist.length; i++) {
	           dist[i] = Integer.MAX_VALUE;
	        }
	        dist[s] = 0;
	  
	        for (int i=0; i<dist.length; i++) {
	           final int next = minVertex (dist, visited);
	           visited[next] = true;
	  
	           // The shortest path to next is dist[next] and via pred[next].
	  
	           final int [] n = G.neighbors (next);
	           for (int j=0; j<n.length; j++) {
	              final int v = n[j];
	              final int d = dist[next] + G.getWeight(next,v);
	              if (dist[v] > d) {
	                 dist[v] = d;
	                 pred[v] = next;
	              }
	           }
	        }
	        return pred;  // (ignore pred[s]==0!)*/

	
	


    // run a step in the game : move all the object according to their speed
    // return while nobody wins
    public boolean UpdateGame(){
        if( (nbCar + nbRepairCar) == 0 ){
            Writer.write_empty();
            return false;
        }
        for(int i = 0; i < nbCar; i++){
            if(tabCar.get(i).isWinner()){
                Writer.write_win(i);
                return false;
            }
            tabCar.get(i).updateCarPosition();
        }
        computeRepairCarMove();
        return true;
    }

    public TrackView getTrackView(){
        return track.getView();
    }
}
