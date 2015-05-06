


public class Oil implements AbstractObstacle{
    public static int nbpatch =1;
    public int id;
    public int effectLeft=EFFECTLONG;
    private OilView oilView;
    public Oil(){
        id=nbpatch;
        nbpatch++;
    }

    public int getId(){
        return id;
    }

    public void ObstacleHitted(ICar c) {
        System.out.println("ObstacleHitted : Oil");
        c.hitOil();
        effectLeft--;
    }

    public void collisionWithRepairCar(RepairCar rc){
    	System.out.println("rc "+ rc.id +" clearing oil");
    	rc.position.remove(this);
    }
    
    public boolean HasNoMoreEffect(){
        return effectLeft==0;
    }

    public String type(){
        return "Oil";
    }



    public int effectLeft() {
        // TODO Auto-generated method stub
        return effectLeft;
    }

    public void print(int x, int y) {
        Writer.write("Oil "+getId()+" Position "+ x +" "+ y+" Effect_Left "+effectLeft);
    }

    public AbstractObstacleView getView(){
        return oilView;
    }

	public OilView getOilView() {
		return oilView;
	}

	public void setOilView(OilView oilView) {
		this.oilView = oilView;
	}

}

