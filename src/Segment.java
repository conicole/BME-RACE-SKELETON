import java.util.*;
  
public class Segment implements ISegment {
  private int x;
  private int y;
  public Stack<AbstractObstacle> SObs;
  public boolean isOutOfTrack;


    public Segment(int i,int j){
        x = i;
        y=j;
        isOutOfTrack = false;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }


    public void remove(AbstractObstacle obj){
    		
    }
  
  public void addObstacle(AbstractObstacle o){
	  System.out.println("Segment : add an obstacle on the segment");
	  SObs.push(o);
  }
  
  // prevent all the object on the segment that
  // a car is coming | manage collision
  public void CarIsComing(ICar c)
  {
	  if(!SObs.empty()){
		     SObs.peek().ObstacleHitted(c);
      }
	  if(SObs.peek().HasNoMoreEffect()) SObs.pop();
	  this.addObstacle(c);
	  if(isOutOfTrack) c.outOfTrack();
  }
  
  public void setOutOfTrack(){
	  isOutOfTrack = true;
  }
  
  public void clear(RepairCar rc){
	  while(!SObs.empty()){
		  SObs.pop().collisionWithRepairCar(rc);
	  }
  }
  
}
