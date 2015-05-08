public class Glue implements AbstractObstacle{
    public static int nbpatch =1;
    public int id;
    public int effectLeft=EFFECTLONG;
    private GlueView glueView;

    public Glue(){
        id=nbpatch;
        nbpatch++;
    }

//determins the behavior for when an obstacle has been hit
    public void ObstacleHitted(ICar c) {
        System.out.println("ObstacleHitted : Glue");
        c.hitGlue();
        effectLeft--;
//        Writer.writeCollisionGlue(c,this);
    }

  //determins the behavior for collision with car
    public void collisionWithRepairCar(RepairCar rc){
    	System.out.println("clearing glue");
    	rc.position.remove(this);
    	
    }
    
    //checks if there are more effects
    public boolean HasNoMoreEffect(){
        return effectLeft==0;
    }

    //gets the name 
    public String name(){
        return "Glue";
    }


    //gets id
    public int getId() {
        // TODO Auto-generated method stub
        return id;
    }

    //gets effects left
    public int effectLeft() {
        // TODO Auto-generated method stub
        return effectLeft();
    }

    //prints to output
    public void print(int x, int y) {
        Writer.write("Glue "+getId()+" Position "+ x +" "+ y+" Effect_Left "+effectLeft);
    }

    
    //gets view
    public AbstractObstacleView getView(){
        return glueView;
    }

//gets view
	public GlueView getGlueView() {
		return glueView;
	}

//sets view
	public void setGlueView(GlueView glueView) {
		this.glueView = glueView;
	}



}
