

//oil class
public class Oil implements AbstractObstacle{
	//fields
	public static int nbpatch =1;
	public int id;
	public int effectLeft=EFFECTLONG;
	private OilView oilView;
	public Oil(){
		id=nbpatch;
		nbpatch++;
	}
	//gets id
	public int getId(){
		return id;
	}
	//behaivor when hit by car
	public void ObstacleHitted(ICar c) {
		System.out.println("ObstacleHitted : Oil");
		c.hitOil();
		effectLeft--;
	}
	//behavior when hit by repaircar
	public void collisionWithRepairCar(RepairCar rc){
		System.out.println("rc "+ rc.id +" clearing oil");
		rc.position.remove(this);
	}
//checks for more effects
	public boolean HasNoMoreEffect(){
		return effectLeft==0;
	}
//gets name
	public String name(){
		return "Oil";
	}


//checks for more effects
	public int effectLeft() {
		// TODO Auto-generated method stub
		return effectLeft;
	}
//print
	public void print(int x, int y) {
		Writer.write("Oil "+getId()+" Position "+ x +" "+ y+" Effect_Left "+effectLeft);
	}
//gets view
	public AbstractObstacleView getView(){
		return oilView;
	}
//gets view
	public OilView getOilView() {
		return oilView;
	}
//set view
	public void setOilView(OilView oilView) {
		this.oilView = oilView;
	}

}

