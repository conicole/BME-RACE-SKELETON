import java.util.*;

public class Segment implements ISegment {
	//fields
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
		view.validate();
		view.repaint();
	}
	//adds obstacles
	public void addObstacle(AbstractObstacle o){
		//ensures car is always on to of track
		if(o.name().equalsIgnoreCase("car"))  
			{
			List<AbstractObstacle> l = new ArrayList<AbstractObstacle>();
			l.add(o);
			l.addAll(SObs);
			SObs.clear();
			SObs.addAll(l);
			}
		else{
			SObs.add(o);
		}
		
	}

	// prevent all the object on the segment that
	// a car is coming | manage collision
	public void CarIsComing(ICar c)
	{
		//checks if it is finishline
		if(isFinishLine==true){
			c.setWinner(true);
		}
		//checks if empty
		if(!SObs.isEmpty()){
			for(int i=0;i<SObs.size();i++){
				//if obstacle is myself then skip
				if(SObs.get(i)!=c)
					SObs.get(i).ObstacleHitted(c);
				if(SObs.get(i).HasNoMoreEffect()) SObs.remove(i);
			}
		}
		//adds to track
		this.addObstacle(c);
		if(isOutOfTrack) {
			c.outOfTrack();
		}
		this.updateView();//update view
	}
	//checks if out of track
	public void setOutOfTrack(){
		isOutOfTrack = true;
	}

	//clears repair car from track
	public void clear(RepairCar rc){


		for(int i=0;i<SObs.size();i++){
			if(rc.LifeTime!=0){
				SObs.get(i).collisionWithRepairCar(rc);
			}

		}
	}

	//set as finish line
	public void setInFinishLine(){
		isFinishLine = true;
	}
//set view
	public void setView(SegView sgV){
		view =sgV;
	}

//update view
	public void updateView(){
		view.updateComponent();
		view.validate();
		view.repaint();
	}




}
