import java.util.Stack;

public class Car implements  ICar{

    private SpeedVector sv;///
    boolean winner =false;
    private Game g;///
    private Segment position;///
    private int id;
    public Stack<Glue> Sg;
    public Stack<Oil> So;
    public final int AMMUNITION = 4;
 //constructor
    Car(){
        sv = new SpeedVector();
    }
    //constructor
    Car(Game game){
        g=game;
        sv = new SpeedVector();
    }
    //constructor
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
    //getter
    public int getId(){
        return id;
    }
   //getter
    public String getID(){
        return Integer.toString(id);
    }
  //checks if obstacle hit
    public void ObstacleHitted(ICar c){
        c.hitCar();
        Writer.writeCollisionCar(this,c);
        this.accelerate();
    }
    //checks if car hit
    public void hitCar(){
        this.stop();
    }
//accelerate
    public void accelerate(){
        sv.increase(1);
        Writer.writeAccelerrate(this);
    }
//brake
    public void brake(){
        sv.decrease(1);
        Writer.writeBrake(this);
    }
//goleft
    public void goLeft(){
        sv.turnLeft();
        Writer.writeGoLeft(this);
    }
//goright
    public void goRight(){
        sv.turnRight();
        Writer.writeGoRight(this);
    }
//stop
    public void stop(){
        sv.stop();
    }
//hit glue
    public void hitGlue(){
        sv.decrease(2);
    }
//hitoil
    public void hitOil(){
        sv.increase(2);
    }
 // hit obstacle
    public void hitObstacle(){
        sv.stop();
    }
    //sets that this car is the winner
    public void setWinner(boolean b){
    	winner=b;
    }
    
// updates the car position
    public void updateCarPosition(){

       // g.getTrack().remove(this, position);
        //position = g.nextSegment(this);

        Segment newpos = g.nextSegment(this);
        if( newpos.equals(this.position)) {
        }
        else{
            g.getTrack().remove(this,position);
            this.position = newpos;
        }
    }
//releases oil
    public void releaseOil(){
        if(!So.empty()) {
            Oil o=So.pop();
            position.addObstacle(o);
            Writer.writeReleaseOil(this, o);
        }

    }
    //releases glue
    public void releaseGlue(){
        if(!Sg.empty()) {
            Glue g =Sg.pop();
            position.addObstacle(g);
            Writer.writeReleaseGlue(this, g);
        }
    }
//setter
    public void setPosition(Segment s){
        position=s;
    }
//getter
    public Segment getPosition(){
        return position;
    }

    //remove car from race
    public void outOfTrack(){
    	g.getTrack().remove(this, position);
    }
    //collision with repair car
    public void collisionWithRepairCar(RepairCar rc){
        rc.hitCar();
        //Ensure speed vector doesnt change after collision
        int x= (int)sv.SpeedX;
        int y= (int)sv.SpeedY;
        
        position.addObstacle(this);
        sv.SpeedX=x;
        sv.SpeedY=y;
        Writer.writeCollisionRepairCar(this,rc);
    }
    //speedvector constructor
    public SpeedVector getSpeedVector(){
        return sv;
    }
//check if effect left
    public boolean HasNoMoreEffect(){
        return false;
    }
//get type
    public String type(){
        return null;
    }
//check if effect left
    public int effectLeft() {
        return 1;
    }
//print output
    public void print(int x, int y){
        SpeedVector sv = getSpeedVector();
        Writer.write("Car "+getId()+" Position "+ x +" "+ y+" Speed "+sv.getSpeedX()+" "+sv.getSpeedY());
    }
    
	
	public boolean isWinner() {
		return winner;
	}


}
