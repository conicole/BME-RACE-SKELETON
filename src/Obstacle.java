public class Obstacle extends AbstractObstacle{


    void ObstacleHitted(ICar c) {
    	    System.out.println("ObstacleHitted : Obstacle\n");
    	    c.hitObstacle();
    }
    
    
}
