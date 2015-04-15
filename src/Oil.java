


public class Oil implements AbstractObstacle{
	public static int nbpatch =1;
	public int id;

	public Oil(){
		id=nbpatch;
		nbpatch++;
	}
	
	public int getID(){
		return id;
	}
	
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

