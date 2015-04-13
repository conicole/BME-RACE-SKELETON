
public class Game {
  
  private Track track;
  private ICar[] tabCar;



    public Game(){
        this.track = new Track(10,10);
    }
    public void createGame()
    {
    	System.out.println("Game : Creation of the game");
        track = new Track();
//        car1 = new Car(this);
//        car2 = new Car(this);
//        car1.setPosition(track.gets1());
//        car2.setPosition(track.gets2());
//        track.gets3().addObstacle(new Obstacle());
    }

    public void setTrack(int x,int y)
    {

    }

    public Track getTrack(){
        return track;
    }

    public void add_car(int x,int y){

    }

    public void add_repairCar(int x,int y){

    }



    public ICar getCar(int n) throws IndexOutOfBoundsException
    {
        try{
            return tabCar[n];
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Segment nextSegment(ICar c){
    	System.out.println("Game : Compute the next segment of the Car");
        Segment newSegment = new Segment();
    	track.updateCarPosition(c,newSegment);
    	return newSegment;
    }

    public void init_add_glue(int x,int y){
        // todo
    }

    public void init_add_oil(int x,int y){
        // todo
    }

    public void init_add_obs(int x,int y){
        // todo
    }

    public void sow_grass(int x,int y){
        // todo
    }

    public void set_finish_line(int x1,int y1, int x2, int y2){
        //todo
    }
}
