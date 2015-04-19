
public class RepairCar extends Oil  {

    int SpeedX;
    int SpeedY;
    int LifeTime;
    Segment position;
    int id;

    RepairCar(Segment s, int i){
        position=s;
        LifeTime=4;
        s.addObstacle(this);
        id=i;
    }

    public void setPosition(Segment position) {
        this.position = position;
    }

  

    public Segment getPosition(){
        return position;
    }

    public int getId(){
        return id;
    }
    public String getID(){
        return Integer.toString(id);
    }


    ///Cleans the segments which contains patches.
    void cleaning(){
        position.clear(this);
    }

    ///Makes the Car to disapperar from the track when its lifetime is 0.
    void  Disappear(){
      
    }

    ///Creates the RepairCar and specifies its how long it will be on the Track
    void  Create(int l){
        LifeTime = l;
    }

    ///Specifies where the repair car will be placed on the track when it is created.
    void StartPosition(Segment s){
    	position = s;
    }

    ///Used to move the Repair car around the track.
    void Move(Segment seg){
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
        if(LifeTime==0);
        else LifeTime--;
    }
    public void hitCar(){
        //position.remove(this);
        position.addObstacle(new Oil());
        Disappear();
    }

    public String type(){
        return null;
    }

    public void print(int x, int y){
    
        Writer.write("RepairCar "+getId()+" Position "+ x +" "+ y +" Speed "+ SpeedX +" "+ SpeedY);
    }

}
