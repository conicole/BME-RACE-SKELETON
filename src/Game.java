
public class Game {
  
  private Track track;
  private ICar[] tabCar;
  int nbCar;
  private RepairCar[] tabRepairCar;
  int nbRepairCar;


    public Game(){
         
        tabCar=new ICar[5];
        tabRepairCar=new RepairCar[5];
        nbCar=0;
        nbRepairCar=0;
    }

    public void setTrack(int x,int y)
    {
    	track = new Track(x,y);
    }

    public Track getTrack(){
        return track;
    }

    public void add_car(int x,int y){
    	tabCar[nbCar]=new Car(this,x,y,nbCar);
    	nbCar++;
    }

    public void add_repairCar(int x,int y){
    	Segment s=track.getSegment(x, y);
    	tabRepairCar[nbRepairCar]=new RepairCar(s, nbRepairCar);
    	nbRepairCar++;
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
    	//System.out.println(x);
    	//System.out.println(y);
    	if(x<0) x=0;
    	if(x>=h) x=h;
    	if(y<0) y=0;
    	if(y>=l) x=l;
    	//System.out.println(x);
    	//System.out.println(y);

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


    // create the finish line, horizontal only now.
    public void set_finish_line(int x1,int y1, int x2, int y2){
        int lg = x2 - x1;
        for(int i = 0; i <= lg; i++){
            track.setFinish(x1,y1);
            x1++;
        }
    }
	public RepairCar getRepairCar(int i) {
		return (RepairCar)tabCar[i];
	}

    // run a step in the game : move all the object according to their speed
    public void runStep(){
        for(int i = 0; i < nbCar; i++){
            tabCar[i].updateCarPosition();
        }
       /* for(int i = 0; i < nbRepairCar; i++){
            tabRepairCar[i].updateCarPosition();
        }*/
    }
}
