public class Obstacle implements AbstractObstacle{

	public Obstacle(){
		System.out.println("Obstacle : Creation of an Obstacle");
	}
    public Obstacle(int i){}

    public void ObstacleHitted(ICar c) {
    	    System.out.println("ObstacleHitted : Obstacle");
    	    c.hitObstacle();
    	    effectLeft--;
    }
    
    public void collisionWithRepairCar(RepairCar rc){
    	
    }
    public boolean HasNoMoreEffect(){
 	   return effectLeft==0;
    }
}
