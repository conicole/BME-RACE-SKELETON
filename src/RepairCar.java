
public class RepairCar implements  ICar {

    int SpeedX = 1;
    int SpeedY = 1;
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

    public void accelerate() {

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
    void StartPosition(int x, int y){

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
        if(LifeTime==0) Disappear();
        else LifeTime--;
    }

    public void hitCar(){
        //position.remove(this);
        position.addObstacle(new Oil());
        Disappear();
    }

    public int getSpeedY() {
        // TODO Auto-generated method stub
        return SpeedY;
    }

    public int getSpeedX() {
        // TODO Auto-generated method stub
        return SpeedX;
    }

    public void brake() {

    }

    public void stop(){

    }

    public void hitGlue(){

    }

    public void hitOil(){

    }

    public void hitObstacle(){

    }


    public boolean HasNoMoreEffect(){
        return false;
    }

    public String type(){
        return null;
    }

    @Override
    public int effectLeft() {
        return 1;
    }


    public void updateCarPosition(){
        // algo to implement TODO
    }

    public void goLeft(){

    }

    public void goRight(){

    }

    public void releaseOil(){

    }

    public void releaseGlue(){

    }

    public void collisionWithRepairCar(RepairCar rc) {

    }

    public SpeedVector getSpeedVector(){
        return null;
    }



    public void ObstacleHitted(ICar c){

    }

    public void outOfTrack() {

    }

    public void print(int x, int y){
        SpeedVector sv = getSpeedVector();
        Writer.write("RepairCar "+getId()+" Position "+ x +" "+ y +" Speed "+sv.getSpeedX()+" "+sv.getSpeedY());
    }

}
