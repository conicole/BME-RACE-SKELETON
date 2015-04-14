public interface  AbstractObstacle{
	
	public int effectLeft = 4;

    public void ObstacleHitted(ICar c);
    public void collisionWithRepairCar(RepairCar rc);
    
    
}
