public class Car extends AbstractObstacle implements ICar{

    private SpeedVector sv;///
    private Game g;///
    private Segment position;///

    Car(){
    	sv = new SpeedVector();
    }
    
    Car(Game game){
         g=game;
         sv=new SpeedVector();
         System.out.println("Car : Creation of a car");
         
    }
    
    public void ObstacleHitted(ICar c){
        System.out.println("Car : ObstacleHitted : Car");
        c.hitCar();
        this.accelerate();
    }

    public void hitCar(){
         System.out.println("Car : hit a car");
         this.stop();
    }

    public void accelerate(){
        System.out.println("Car : accelerate");
        sv.increase(2);
    }
    
    public void brake(){
      System.out.println("Car : brake");
        sv.decrease(1);
    }
    
    public void goLeft(){
      System.out.println("Car : go left");
        sv.turnLeft();
    }

    public void goRight(){
      System.out.println("Car : go right");
        sv.turnRight();
    }
    
    public void stop(){
        System.out.println("Car : stop"); 
    }
    
    public void hitGlue(){
         System.out.println("Car : hit glue");
         sv.decrease(2);
    }
    
    public void hitOil(){
         System.out.println("Car : hit oil");
         sv.increase(2);
    }
    
    public void hitObstacle(){
         System.out.println("Car : hit an obstacle");
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
    
}
