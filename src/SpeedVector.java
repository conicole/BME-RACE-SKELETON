import java.lang.Math.*;

public class SpeedVector {

	double SpeedX;
	double SpeedY;
	double r;
	double teta;
	final static int MAXSPEED = 3;
	final static int MINSPEED = 0;
	final static double ROTATION = 5;

	SpeedVector(){
		SpeedX=0;
		SpeedY=0;
		r=0;
		teta =90;
	}

	void decrease(int a){
		r-=a;
		if(r<MINSPEED) r=MINSPEED;

		// 	   System.out.println(r+" "+teta+" "+SpeedX+" "+SpeedY);

	}

	void increase(int a){
		r+=a;
		if(r>MAXSPEED)r=MAXSPEED;    	   

		//  System.out.println(r+" "+teta+" "+SpeedX+" "+SpeedY);

	}

	void turnRight(){
		teta=teta-ROTATION;

		//   System.out.println(r+" "+teta+" "+SpeedX+" "+SpeedY);
	}

	void turnLeft(){
		teta=teta+ROTATION;

		//	  System.out.println(r+" "+teta+" "+SpeedX+" "+SpeedY);
	}

	void stop(){
		r = 0;
	}

	public int getSpeedX(){
		return  (int)Math.round(r*Math.sin(teta));
	}

	public int getSpeedY(){
		return (int) Math.round(r*Math.cos(teta));
	}
}
