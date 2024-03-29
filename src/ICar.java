
public interface ICar extends AbstractObstacle {

//abstracle obstacle interface
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
	public void outOfTrack();
	public SpeedVector getSpeedVector();
	public Segment getPosition();
	public int getId();
	public String getID();
	public void setWinner(boolean b);
	public boolean isWinner();
}
