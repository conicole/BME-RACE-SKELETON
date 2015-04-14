public class Glue implements AbstractObstacle{


   public void ObstacleHitted(ICar c) {
    	    System.out.println("ObstacleHitted : Glue");
    	    c.hitGlue();
    	    effectLeft--;
    }
   
   public void collisionWithRepairCar(RepairCar rc){
   	
   }
    
    
}
