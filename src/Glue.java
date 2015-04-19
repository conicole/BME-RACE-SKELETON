public class Glue implements AbstractObstacle{
	public static int nbpatch =1;
	public int id;
	public int effectLeft=EFFECTLONG;

	public Glue(){
		id=nbpatch;
		nbpatch++;
	}
	

   public void ObstacleHitted(ICar c) {
    	    System.out.println("ObstacleHitted : Glue");
    	    c.hitGlue();
    	    effectLeft--;
            Writer.writeCollisionGlue(c,this);
    }
   
   public void collisionWithRepairCar(RepairCar rc){
   		
   }
   public boolean HasNoMoreEffect(){
	   return effectLeft==0;
   }
   
   public String type(){
   	return "Glue";
   }



public int getId() {
	// TODO Auto-generated method stub
	return id;
}


public int effectLeft() {
	// TODO Auto-generated method stub
	return effectLeft();
}
    
    
}
