import java.util.*;
  
public class Segment implements ISegment {
  public int Id;
  public Stack<AbstractObstacle> SObs;
  public boolean isOutOfTrack;


    public Segment(int id){
        Id = id;
        isOutOfTrack = false;
    }

    public int getId(){
        return Id;
    }


    public void remove(AbstractObstacle obj){
//todO
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
