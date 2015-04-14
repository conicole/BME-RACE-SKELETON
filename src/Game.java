
public class Game {
  
  private Track track;
  private ICar[] tabCar;
  private int nbCar;
  private RepairCar[] tabRepairCar;
  private int nbRepairCar;


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
    	track=new Track(x,y);
    	tabCar=new ICar[5];
    	tabRepairCar=new RepairCar[5];
    	nbCar=0;
    	nbRepairCar=0;
    }

    public Track getTrack(){
        return track;
    }

    public void add_car(int x,int y){
    	tabCar[nbCar++]=new Car(this,x,y);
    }

    public void add_repairCar(int x,int y){
    	Segment s=track.getSegment(x, y);
    	tabRepairCar[nbRepairCar++]=new RepairCar(s);
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
    	
    	int h=track.getHeight();
    	int l=track.getLength();
    	int x = c.getSpeedVector().getSpeedX()+c.getPosition().getX();
    	int y = c.getSpeedVector().getSpeedY()+c.getPosition().getY();
    	if(x<0) x=0;
    	if(x>=h) x=h;
    	if(y<0) y=0;
    	if(y>=l) x=l;
    	Segment newSegment = track.getSegment(x, y);
    	track.updateCarPosition(c,newSegment);
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

    public void set_finish_line(int x1,int y1, int x2, int y2){
        //todo
    }
}
