


public class Oil implements AbstractObstacle{
    public static int nbpatch =1;
    public int id;
    public int effectLeft=EFFECTLONG;
    private OilView oilView;
    public Oil(){
        id=nbpatch;
        nbpatch++;
        oilView = new OilView(this);
    }

    public int getId(){
        return id;
    }

    public void ObstacleHitted(ICar c) {
        System.out.println("ObstacleHitted : Oil");
        c.hitOil();
        effectLeft--;
        Writer.writeCollisionOil(c,this);
    }

    public void collisionWithRepairCar(RepairCar rc){

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
        // todooo
        return new CarView(new Car());
    }

	public OilView getOilView() {
		return oilView;
	}

	public void setOilView(OilView oilView) {
		this.oilView = oilView;
	}

}

