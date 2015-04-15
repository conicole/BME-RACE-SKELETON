import java.util.*;
  
public class Segment implements ISegment {
  private int x;
  private int y;
  public List<AbstractObstacle> SObs;
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
    
    public boolean hasObstacle(){
    	return SObs.isEmpty();
    }
    
    public void remove(AbstractObstacle obj){
    		
    }
  
  public void addObstacle(AbstractObstacle o){
	  System.out.println("Segment : add an obstacle on the segment");
	  SObs.add(o);
  }
  
  // prevent all the object on the segment that
  // a car is coming | manage collision
  public void CarIsComing(ICar c)
  {
	  
	  if(!SObs.isEmpty()){
		  for(int i=0;i<SObs.size();i++){
		     SObs.get(i).ObstacleHitted(c);
		     if(SObs.get(i).HasNoMoreEffect()) SObs.remove(i);
		  }
	  }
	  this.addObstacle(c);
	  if(isOutOfTrack) {
		  c.outOfTrack();
	  }
  }
  
  public void setOutOfTrack(){
	  isOutOfTrack = true;
  }
  
  public void clear(RepairCar rc){
	  for(int i=0;i<SObs.size();i++){
		  SObs.get(i).collisionWithRepairCar(rc);
	  }
  }
  
}
