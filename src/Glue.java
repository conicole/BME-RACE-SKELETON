public class Glue implements AbstractObstacle{
	public static int nbpatch =1;
	public int id;

	public Glue(){
		id=nbpatch;
		nbpatch++;
	}
	

   public void ObstacleHitted(ICar c) {
    	    System.out.println("ObstacleHitted : Glue");
    	    c.hitGlue();
    	    effectLeft--;
    }
   
   public void collisionWithRepairCar(RepairCar rc){
   		
   }
   public boolean HasNoMoreEffect(){
	   return effectLeft==0;
   }
   
   public String type(){
   	return "Glue";
   }
    
    
}
