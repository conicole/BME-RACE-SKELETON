public class Car implements  ICar{

    private SpeedVector sv;///
    private Game g;///
    private Segment position;///

    Car(){
    	sv = new SpeedVector();
    }
    
    Car(Game game){
         g=game;  
         sv = new SpeedVector();
    }
    
    Car(Game game,int i,int j){
        g=game;  
        sv = new SpeedVector();
        position=game.getTrack().getSegment(i,j);
        position.addObstacle(this);
   }
    
    public void ObstacleHitted(ICar c){
        c.hitCar();
        this.accelerate();
    }

    public void hitCar(){
         this.stop();
    }

    public void accelerate(){
        sv.increase(1);
    }
    
    public void brake(){
        sv.decrease(1);
    }
    
    public void goLeft(){
        sv.turnLeft();
    }

    public void goRight(){
        sv.turnRight();
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
          System.out.println("Car : update car position");
          g.getTrack().remove(this, position);
          position = g.nextSegment(this);
          System.out.println("Car : has a new segment position");
    }
    
    public void releaseOil(){
         System.out.println("Car : release Oil");
         position.addObstacle(new Oil());
    }
    public void releaseGlue(){
         System.out.println("Car : release Glue");
         position.addObstacle(new Glue());
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
    }
    
    public SpeedVector getSpeedVector(){
    	return sv;
    }
    
    public boolean HasNoMoreEffect(){
    	return false;
    }
    
}
