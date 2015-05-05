
public class RepairCar extends Oil  {

    int SpeedX;
    int SpeedY;
    int LifeTime;
    Segment position;
    int id;
    long tStart;
    private RepairCarView view;
    
    //constructor
    RepairCar(Segment s, int i){
        position=s;
        LifeTime=4;
        s.addObstacle(this);
        id=i;
        tStart = System.currentTimeMillis();//Sets the time the car was added
        
    }
    


  
    //get position
    public Segment getPosition(){
        return position;
    }
    	//gets id
    public String getID(){
        return Integer.toString(id);
    }


    ///Cleans the segments which contains patches.
    void cleaning(){
        position.clear(this);
    }

    ///Makes the Car to disapperar from the track when its lifetime is 0.
    void  Disappear(){
      //Gui
    	position.remove(this);
    }




    ///Used to move the Repair car around the track.
    public void Move(Segment seg){
       // position.remove(this);
    	position=seg;
        Age();
        seg.addObstacle(this);
    }

    ///Used to get the lifetime the repairCar has left.
    ///@return : the lifeTime of the repairCar
    int getLifetime(){
        return LifeTime;
    }

    ///Used to decrease the lifetime of the repairCar Object.
    void Age(){
        if(LifeTime!=0)
        {
        	long elapse = System.currentTimeMillis()-tStart;
        	
        	elapse = (long) (elapse / 1000.0);
        	if (elapse>1.0){
        		LifeTime--;
        		tStart=System.currentTimeMillis();
        	}
        }
        else{
        	
        	Disappear();
        }
       
       
    }
    //collision with car
    public void hitCar(){
        position.addObstacle(new Oil());
    	LifeTime=0;
        
        Disappear();
    }

    public void print(int x, int y){
    
        Writer.write("RepairCar "+getId()+" Position "+ x +" "+ y +" Speed "+ SpeedX +" "+ SpeedY);
    }
    
    public void setView(RepairCarView Repaircarview) {   view =Repaircarview; }


    public AbstractObstacleView getView(){
        return view;
    }


}
