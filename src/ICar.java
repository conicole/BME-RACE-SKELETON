
public interface ICar extends AbstractObstacle {

   //interface representing all obstacle
    public void hitCar();
   public void accelerate();   
   public void brake();
   public void goLeft();
   public void goRight();   
   public void stop();   
   public void hitGlue(); 
   public void hitOil();   
   public void hitObstacle();
   public void updateCarPosition();   
   public void releaseOil();
   public void releaseGlue();
   public void setPosition(Segment s);
}
