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
    private CarView view;
    boolean dead = false;

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
        Oil o;
        OilView oV;
        Glue Gl;
        GlueView Glv;

        for(int k=0;k<AMMUNITION;k++) {
            o = new Oil();
            oV = new OilView(o);
            o.setOilView(oV);
            Gl = new Glue();
            Glv = new GlueView(Gl);
            Gl.setGlueView(Glv);
            So.push(o);
            Sg.push(Gl);
        }
    }
    //getter
    public int getId(){
        return id;
    }
   //getter
    public String getID(){
        return Integer.toString(id+1);
    }
  //checks if obstacle hit
    public void ObstacleHitted(ICar c){
        c.hitCar();
        this.accelerate();
    }
    //checks if car hit
    public void hitCar(){
        this.stop();
    }
//accelerate
    public void accelerate(){
        sv.increase(1);
    }

//brake
    public void brake(){
        sv.decrease(1);
    }
//goleft
    public void goLeft(){
        sv.turnLeft();
        position.updateView();
    }
//goright
    public void goRight(){
        sv.turnRight();
        position.updateView();

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
        if(!dead) {
            Segment newpos = g.nextSegment(this);
            if (newpos.equals(this.position)) {
            } else {
                g.getTrack().remove(this, position);
                this.position = newpos;
            }
        }
    }
//releases oil
    public void releaseOil(){
        if(!So.empty() & !dead) {
            System.out.println("drop oil");
            Oil o=So.pop();
            position.addObstacle(o);
            position.updateView();
        }

    }
    //releases glue
    public void releaseGlue(){
        if(!Sg.empty() & !dead ) {
            System.out.println("drop glue");
            Glue g =Sg.pop();
            position.addObstacle(g);
            position.updateView();
            //  Writer.writeReleaseGlue(this, g);
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
    	this.dead = true;
    }
    //collision with repair car
    public void collisionWithRepairCar(RepairCar rc){
        rc.hitCar();
        //Ensure speed vector doesnt change after collision
        double x= (double)sv.SpeedX;
        double y= (double)sv.SpeedY;
     
        //position.addObstacle(new Oil());
        sv.SpeedX=x;
        sv.SpeedY=y;
        System.out.println("Car collide with repair car" + rc.id);
        
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
    public String name(){
        return "car";
    }
//check if effect left
    public int effectLeft() {
        return 1;
    }
//print output
    public void print(int x, int y){
        SpeedVector sv = getSpeedVector();
       // Writer.write("Car "+getId()+" Position "+ x +" "+ y+" Speed "+sv.getSpeedX()+" "+sv.getSpeedY());
              
    }
    
	
	public boolean isWinner() {
		return winner;
	}

    public void setView(CarView carview) { view = carview; }


    public AbstractObstacleView getView(){
        return view;
    }



}
