


public class Oil implements AbstractObstacle{


    public void ObstacleHitted(ICar c) {
    	//output
    	    System.out.println("ObstacleHitted : Oil");
    	  //type of obstacle hit
    	    c.hitOil();
    }
    
    
}

