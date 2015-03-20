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
    
    void ObstacleHitted(ICar c) {
         System.out.println("ObstacleHitted : Car\n");
         c.hitCar();
         this.accelerate();
    }
    
    void hitCar(){
         System.out.println("I hit a car\n");
         this.stop();
    }
    
    void accelerate(){
        System.out.println("I accelerate"\n");
        sv.increase(2);
    }
    
    void brake(){
      System.out.println("I brake"\n");
        sv.decrease(1);
    }
    
    void goLeft(){
      System.out.println("I go left"\n");
        sv.turnLeft();
    }

    void goRight(){
      System.out.println("I go right"\n");
        sv.turnRight();
    }
    
    void stop(){
        System.out.println("I stop\n"); 
    }
    
    void hitGlue(){
         System.out.println("I hit glue\n");
         sv.decrease(2);
    }
    
    void hitOil(){
         System.out.println("I hit oil\n");
         sv.increase(2);
    }
    
    void hitObstacle(){
         System.out.println("I hit an obstacle\n");
    }
    
    void updateCarPosition(){
          System.out.println("I update car position\n");
          g.track.remove(this, position);//Attribute ???
          postion = g.nextSegment();//Attribute ???
          System.out.println("I have a new segment position\n");
    }
    
    void releaseOil(){
         System.out.println("I release Oil\n");
         position.addObstacle(new Oil);//Attribute ???
         
    }
    void releaseGlue(){
         System.out.println("I release Glue\n");
         position.addObstacle(new Glue());//Attribute ???
         
    }
    
    
}
