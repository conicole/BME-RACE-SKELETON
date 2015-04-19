import java.util.*;
  
public class Segment implements ISegment {
  private int x;
  private int y;
  public ArrayList<AbstractObstacle> SObs;
  public boolean isOutOfTrack;
  public boolean isFinishLine;


    public Segment(int i,int j){
        isFinishLine = false;
        x = i;
        y=j;
        isOutOfTrack = false;
        SObs = new ArrayList<AbstractObstacle>();
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
    		SObs.remove(obj);
    }
  
  public void addObstacle(AbstractObstacle o){
	  SObs.add(o);
  }
  
  // prevent all the object on the segment that
  // a car is coming | manage collision
  public void CarIsComing(ICar c)
  {
	  if(!SObs.isEmpty()){
		  for(int i=0;i<SObs.size();i++){
		    if(SObs.get(i)!=c){

                SObs.get(i).ObstacleHitted(c);
            }
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

  public void setInFinishLine(){
      isFinishLine = true;
  }
  
}
