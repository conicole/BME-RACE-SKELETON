public class Glue extends AbstractObstacle{


    void ObstacleHitted(ICar c) {
    	    System.out.println("ObstacleHitted : Glue\n");
    	    c.hitGlue();
    }
    
    
}
