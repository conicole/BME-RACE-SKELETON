


public class Oil implements AbstractObstacle{


    public void ObstacleHitted(ICar c) {
    	    System.out.println("ObstacleHitted : Oil");
    	    c.hitOil();
    }
    
    
}

