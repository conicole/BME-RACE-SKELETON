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
    }
   
   public void collisionWithRepairCar(RepairCar rc){
   		
   }
   public boolean HasNoMoreEffect(){
	   return effectLeft==0;
   }
   
   public String type(){
   	return "Glue";
   }


@Override
public int getId() {
	// TODO Auto-generated method stub
	return id;
}


@Override
public int effectLeft() {
	// TODO Auto-generated method stub
	return effectLeft();
}

public void print(int x, int y) {
	Writer.write("Glue "+getId()+" Position "+ x +" "+ y+" Effect_Left "+effectLeft);
}
    
    
}
