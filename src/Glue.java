public class Glue implements AbstractObstacle{
    public static int nbpatch =1;
    public int id;
    public int effectLeft=EFFECTLONG;
    private GlueView glueView;

    public Glue(){
        id=nbpatch;
        nbpatch++;
    }


    public void ObstacleHitted(ICar c) {
        System.out.println("ObstacleHitted : Glue");
        c.hitGlue();
        effectLeft--;
//        Writer.writeCollisionGlue(c,this);
    }

    public void collisionWithRepairCar(RepairCar rc){
    	System.out.println("clearing glue");
    	rc.position.remove(this);
    	
    }
    
    public boolean HasNoMoreEffect(){
        return effectLeft==0;
    }

    public String name(){
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

    public void print(int x, int y) {
        Writer.write("Glue "+getId()+" Position "+ x +" "+ y+" Effect_Left "+effectLeft);
    }


    public AbstractObstacleView getView(){
        return glueView;
    }


	public GlueView getGlueView() {
		return glueView;
	}


	public void setGlueView(GlueView glueView) {
		this.glueView = glueView;
	}



}
