public class Obstacle implements AbstractObstacle{
	private int effectLeft = EFFECTLONG;
	private ObstacleView obstacleView;
	public Obstacle(){
		System.out.println("Obstacle : Creation of an Obstacle");
	}
	public Obstacle(int i){}

	public void ObstacleHitted(ICar c) {
		System.out.println("ObstacleHitted : Obstacle");
		c.hitObstacle();
		effectLeft--;
	}

	public void collisionWithRepairCar(RepairCar rc){
		rc.position.remove(this);
	}
	public boolean HasNoMoreEffect(){
		return effectLeft==0;
	}

	public String name() {
		// TODO Auto-generated method stub
		return "Obstacle";
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int effectLeft() {
		// TODO Auto-generated method stub
		return effectLeft;
	}

	public void print(int x, int y) {
		Writer.write("Obstacle "+getId()+" Position "+ x +" "+ y+" Effect_Left "+effectLeft);
	}


	
	
	public AbstractObstacleView getView(){
		return obstacleView;
	}

	public ObstacleView getObstacleView() {
		return obstacleView;
	}

	public void setOilView(ObstacleView obstacleView) {
		this.obstacleView = obstacleView;
	}

}
