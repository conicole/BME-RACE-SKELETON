public class Car extends AbstractObstacle implements ICar{

    private SpeedVector sv;///
    private Game g;///
    private Segment position;///

    Car(Game game){
         g=game;
         sv=new SpeedVector();
         position = new Segment();
         System.out.println("You've just created a car\n");
         
    }
    
    public void ObstacleHitted(ICar c){
        System.out.println("ObstacleHitted : Car\n");
        c.hitCar();
        this.accelerate();
    }

    public void hitCar(){
         System.out.println("I hit a car\n");
         this.stop();
    }

    public void accelerate(){
        System.out.println("I accelerate\n");
        sv.increase(2);
    }
    
    public void brake(){
      System.out.println("I brake\n");
        sv.decrease(1);
    }
    
    public void goLeft(){
      System.out.println("I go left\n");
        sv.turnLeft();
    }

    public void goRight(){
      System.out.println("I go right\n");
        sv.turnRight();
    }
    
    public void stop(){
        System.out.println("I stop\n"); 
    }
    
    public void hitGlue(){
         System.out.println("I hit glue\n");
         sv.decrease(2);
    }
    
    public void hitOil(){
         System.out.println("I hit oil\n");
         sv.increase(2);
    }
    
    public void hitObstacle(){
         System.out.println("I hit an obstacle\n");
    }
    
    public void updateCarPosition(){
          System.out.println("I update car position\n");
          g.getTrack().remove(this, position);
          position = g.nextSegment(position,sv);
          System.out.println("I have a new segment position\n");
    }
    
    public void releaseOil(){
         System.out.println("I release Oil\n");
         position.addObstacle(new Oil());
    }
    public void releaseGlue(){
         System.out.println("I release Glue\n");
         position.addObstacle(new Glue());
    }
    
    
}
