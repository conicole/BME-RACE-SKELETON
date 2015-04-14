
public class RepairCar extends Oil {

	int SpeedX = 1;
	int SpeedY = 1;
	int LifeTime;
	Segment position;
	
	RepairCar(Segment s){
		position=s;
		LifeTime=4;
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
	
	void hitCar(){
		//position.remove(this);
		position.addObstacle(new Oil());
		Disappear();
	}

}
