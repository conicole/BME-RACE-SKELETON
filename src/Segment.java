import java.util.*;
  
public class Segment implements ISegment {
  private int x;
  private int y;
  public ArrayList<AbstractObstacle> SObs;
  public boolean isOutOfTrack;
  public boolean isFinishLine;
    private SegView view;

//constructor
    public Segment(int i,int j){
        isFinishLine = false;
        x = i;
        y=j;
        isOutOfTrack = false;
        SObs = new ArrayList<AbstractObstacle>();
    }
//getters
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    //checks if there is obstacle
    public boolean hasObstacle(){
    	return !SObs.isEmpty();
    }
    
    //removes obstacles
    public void remove(AbstractObstacle obj){
        SObs.remove(obj);
        view.updateComponent();
        view.repaint();

    }
  //adds obstacles
  public void addObstacle(AbstractObstacle o){
	  SObs.add(o);
  }
  
  // prevent all the object on the segment that
  // a car is coming | manage collision
  public void CarIsComing(ICar c)
  {
	 if(isFinishLine==true){
		 c.setWinner(true);
	 }
	  if(!SObs.isEmpty()){
		  for(int i=0;i<SObs.size();i++){
		    //if obstacle is myself then skip
			  if(SObs.get(i)!=c)
			  SObs.get(i).ObstacleHitted(c);
		     if(SObs.get(i).HasNoMoreEffect()) SObs.remove(i);
		  }
	  }
	  this.addObstacle(c);
	  if(isOutOfTrack) {
		  c.outOfTrack();
	  }

        view.updateComponent();
        view.repaint();
  }
  //checks if out of track
  public void setOutOfTrack(){
	  isOutOfTrack = true;
  }
  
  //
  public void clear(RepairCar rc){
	  for(int i=0;i<SObs.size();i++){
		  SObs.get(i).collisionWithRepairCar(rc);
	  }
  }

  //set as finish line
  public void setInFinishLine(){
      isFinishLine = true;
  }

    public void setView(SegView sgV){
        view =sgV;
    }
  
  
  
  
}
