

public class SpeedVector {
//feilds
	double SpeedX;
	double SpeedY;
	double r;
	double teta;
	final static int MAXSPEED = 3;
	final static int MINSPEED = 0;
	final static double ROTATION = 90;
//constructor
	SpeedVector(){
		SpeedX=0;
		SpeedY=0;
		r=0;
		teta =-90;
	}
//decelerate
	void decrease(int a){
		r-=a;
		if(r<MINSPEED) r=MINSPEED;

		// 	   System.out.println(r+" "+teta+" "+SpeedX+" "+SpeedY);

	}
//accelerate
	void increase(int a){
		r+=a;
		if(r>MAXSPEED)r=MAXSPEED;    	   
	}
//turn right
	void turnRight(){
		
        teta= (teta+ROTATION)%360;
		}
//turn left
	void turnLeft(){
		teta=  (teta-ROTATION)%360;

			}
//stops car
	void stop(){
		r = 0;
	}

	public int getSpeedX(){
		//trig math function are in radian
		return  (int)Math.round(r*Math.sin(teta*Math.PI/180));
		
	}

	public int getSpeedY(){
		//trig math function are in radian
		return (int) Math.round(r*Math.cos(teta*Math.PI/180));
	}
}
