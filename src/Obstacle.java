public class Obstacle implements AbstractObstacle{
	private int effectLeft = EFFECTLONG;

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

	}
	public boolean HasNoMoreEffect(){
		return effectLeft==0;
	}

	public String type() {
		// TODO Auto-generated method stub
		return "Obstacle ";
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
		// todooo
		return new CarView(new Car());
	}

}
