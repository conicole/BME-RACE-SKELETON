public class Obstacle implements AbstractObstacle{
	private int effectLeft = EFFECTLONG;
	private ObstacleView obstacleView;
	
	//constructor
	public Obstacle(){
		System.out.println("Obstacle : Creation of an Obstacle");
	}
	
	//constructor
	public Obstacle(int i){}

	//behavior when hit by an object
	public void ObstacleHitted(ICar c) {
		System.out.println("ObstacleHitted : Obstacle");
		c.hitObstacle();
		effectLeft--;
	}

	//behavior when hit by repair car
	public void collisionWithRepairCar(RepairCar rc){
		rc.position.remove(this);
	}
	
	//checks for more effects
	public boolean HasNoMoreEffect(){
		return effectLeft==0;
	}

	//gets name
	public String name() {
		// TODO Auto-generated method stub
		return "Obstacle";
	}

	//id
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	//checks effect left
	public int effectLeft() {
		// TODO Auto-generated method stub
		return effectLeft;
	}

	//prints
	public void print(int x, int y) {
		Writer.write("Obstacle "+getId()+" Position "+ x +" "+ y+" Effect_Left "+effectLeft);
	}


	
	//gets view
	public AbstractObstacleView getView(){
		return obstacleView;
	}

	//gets view
	public ObstacleView getObstacleView() {
		return obstacleView;
	}
	//sets view
	public void setOilView(ObstacleView obstacleView) {
		this.obstacleView = obstacleView;
	}

}
