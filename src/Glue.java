public class Glue implements AbstractObstacle{

		
   public void ObstacleHitted(ICar c) {
	   
	        //output
    	    System.out.println("ObstacleHitted : Glue");
    	    //type of obstacle hit
    	    c.hitGlue();
    }
    
    
}
