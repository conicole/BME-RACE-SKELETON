public interface  AbstractObstacle{
   //abstractObstacle interface
//specifies contract of all obstacles
    public final int  EFFECTLONG=4;

    public void ObstacleHitted(ICar c);
    public void collisionWithRepairCar(RepairCar rc);
    public boolean HasNoMoreEffect();
    public String name();
    public int getId();
    public int effectLeft();
   public void print(int x, int y);
    public AbstractObstacleView getView();

    
}
