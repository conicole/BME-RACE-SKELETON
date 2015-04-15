public interface  AbstractObstacle{
	
	public final int  EFFETLONG=4;

    public void ObstacleHitted(ICar c);
    public void collisionWithRepairCar(RepairCar rc);
    public boolean HasNoMoreEffect();
    public String type();
    public int getId();
    public int effectLeft();
    
}
