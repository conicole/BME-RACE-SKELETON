public class RepairCar implements AbstractObstacle {

	int SpeedX;
	int SpeedY;
	int LifeTime;
	Segment position;
	int id;
	long tStart;
	private RepairCarView view;

	// constructor
	RepairCar(Segment s, int i) {
		position = s;
		LifeTime = 5;
		s.addObstacle(this);

		id = i;
		tStart = System.currentTimeMillis();// Sets the time the car was added
	}

	// get position
	public Segment getPosition() {
		return position;
	}

	// gets id
	public String getID() {
		return Integer.toString(id);
	}

	// /Cleans the segments which contains patches.
	void cleaning() {
		if (LifeTime != 0)
			position.clear(this);
	}

	// /Makes the Car to disapperar from the track when its lifetime is 0.
	void disappear() {
		LifeTime = 0;
		position.remove(this);
	}

	// /Used to move the Repair car around the track.
	public void Move(Segment seg) {
		// System.out.println(seg.getX() + " " + seg.getY());

		position.remove(this);
		position.updateView();
		position = seg;
		Age();
		position.addObstacle(this);
		position.updateView();
		cleaning();

	}

	// /Used to get the lifetime the repairCar has left.
	// /@return : the lifeTime of the repairCar
	int getLifetime() {
		return LifeTime;
	}

	// /Used to decrease the lifetime of the repairCar Object.
	void Age() {

		long elapse = System.currentTimeMillis() - tStart;

		elapse = (long) (elapse / 1000.0);
		if (elapse >= 1.0) {
			LifeTime--;
			tStart = System.currentTimeMillis();
		}

	}

	// collision with car
	public void hitCar() {
		LifeTime = 0;
		position.addObstacle(new Oil());

	}

	//testing method
	public void print(int x, int y) {

		Writer.write("RepairCar " + getId() + " Position " + x + " " + y
				+ " Speed " + SpeedX + " " + SpeedY);
	}

	//sets view
	public void setView(RepairCarView Repaircarview) {
		view = Repaircarview;
	}

	//gets view
	public AbstractObstacleView getView() {
		return view;
	}




	@Override
	public void ObstacleHitted(ICar c) {
		// TODO Auto-generated method stub

	}




	@Override
	public void collisionWithRepairCar(RepairCar rc) {
		// TODO Auto-generated method stub

	}




	@Override
	public boolean HasNoMoreEffect() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "RepairCar";
	}




	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public int effectLeft() {
		// TODO Auto-generated method stub
		return 0;
	}


}
