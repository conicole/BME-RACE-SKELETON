


public class Oil implements AbstractObstacle{


    public void ObstacleHitted(ICar c) {
    	    System.out.println("ObstacleHitted : Oil");
    	    c.hitOil();
    	    effectLeft--;
    }
    
    public void collisionWithRepairCar(RepairCar rc){
    	
    }
    public boolean HasNoMoreEffect(){
 	   return effectLeft==0;
    }
    
}

