import java.util.Stack;

public class Car implements  ICar{

    private SpeedVector sv;///
    private Game g;///
    private Segment position;///
    private int id;
    public Stack<Glue> Sg;
    public Stack<Oil> So;
    public final int AMMUNITION = 4;

    Car(){
    	sv = new SpeedVector();
    }
    
    Car(Game game){
         g=game;  
         sv = new SpeedVector();
    }
    
    Car(Game game,int i,int j, int n){
        Sg = new Stack<Glue>();
        So = new Stack<Oil>();
        g=game;  
        sv = new SpeedVector();
        position=game.getTrack().getSegment(i,j);
        position.addObstacle(this);
        id=n;
        for(int k=0;k<AMMUNITION;k++) {
        	So.push(new Oil());
        	Sg.push(new Glue());
        }
   }
    
    public int getId(){
    	return id;
    }
    
    public String getID(){
    	return Integer.toString(id);
    }
    
    public void ObstacleHitted(ICar c){
        c.hitCar();
        this.accelerate();
        Writer.writeCollisionCar(this,c);
    }

    public void hitCar(){
         this.stop();
    }

    public void accelerate(){
        sv.increase(1);
        Writer.writeAccelerrate(this);
    }
    
    public void brake(){
        sv.decrease(1);
        Writer.writeBrake(this);
    }
    
    public void goLeft(){
        sv.turnLeft();
        Writer.writeGoLeft(this);
    }

    public void goRight(){
        sv.turnRight();
        Writer.writeGoRight(this);
    }
    
    public void stop(){
        sv.stop();
    }
    
    public void hitGlue(){
         sv.decrease(2);
    }
    
    public void hitOil(){
         sv.increase(2);
    }
    
    public void hitObstacle(){
    	sv.stop();
    }
    
    public void updateCarPosition(){
          g.getTrack().remove(this, position);
          position = g.nextSegment(this);
    }
    
    public void releaseOil(){
         if(!So.empty()) {
        	 Oil o=So.pop();
        	 position.addObstacle(o);
        	 Writer.writeReleaseOil(this, o);
         }
         
    }
    public void releaseGlue(){
    	if(!Sg.empty()) {
    		Glue g =Sg.pop();
    		position.addObstacle(g);
    		Writer.writeReleaseGlue(this, g);
    	}
    }
    
    public void setPosition(Segment s){
    	position=s;
    }
    
    public Segment getPosition(){
    	return position;
    }
    
    public void outOfTrack(){
    	sv.decrease(2);
    }
    
    public void collisionWithRepairCar(RepairCar rc){
    	rc.hitCar();
    	position.addObstacle(this);
    	Writer.writeCollisionRepairCar(this,rc);
    }
    
    public SpeedVector getSpeedVector(){
    	return sv;
    }
    
    public boolean HasNoMoreEffect(){
    	return false;
    }
    
    public String type(){
    	return null;
    }

	public int effectLeft() {
		return 1;
	}
	
	public void print(int x, int y){
		SpeedVector sv = getSpeedVector();
		Writer.write("Car "+getId()+" Position "+ x +" "+ y+" Speed "+sv.getSpeedX()+" "+sv.getSpeedY());
	}

    
}
