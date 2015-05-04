import java.lang.Math.*;

public class SpeedVector {

	int SpeedX;
	int SpeedY;
	double r;
	double teta;
	final static int MAXSPEED = 3;
	final static int MINSPEED = 0;
	final static double ROTATION = 10;
	
    SpeedVector(){
    	SpeedX=0;
    	SpeedY=0;
    	r=0;
    	teta =0;
    }

    void decrease(int a){
    	   r-=a;
    	   if(r<MINSPEED) r=MINSPEED;
     	   SpeedX=(int) Math.round(r*Math.sin(teta));
    	   SpeedY=(int) Math.round (r*Math.cos(teta));
    	   System.out.println(r+" "+teta+" "+SpeedX+" "+SpeedY);
    
    }
 
    void increase(int a){
 	   r+=a;
 	   if(r>MAXSPEED)r=MAXSPEED;    	   
 	   SpeedX=(int) Math.round(r*Math.sin(teta));
	   SpeedY=(int) Math.round (r*Math.cos(teta));
	   System.out.println(r+" "+teta+" "+SpeedX+" "+SpeedY);

    }
    
    void turnRight(){
 	   teta=teta-ROTATION-90;
 	   SpeedX=(int) Math.round(r*Math.sin(teta));
	   SpeedY=(int) Math.round (r*Math.cos(teta));
	   System.out.println(r+" "+teta+" "+SpeedX+" "+SpeedY);
    }
 
    void turnLeft(){
    	teta=teta+ROTATION+90;
  	   SpeedX=(int) Math.round(r*Math.cos(teta));
	   SpeedY=(int) Math.round (r*Math.sin(teta));
 	  System.out.println(r+" "+teta+" "+SpeedX+" "+SpeedY);
    }

    void stop(){
    	SpeedX=0;
   	    SpeedY=0;
    }
    
    public int getSpeedX(){
    	return  (int) (SpeedX);
    }
    
    public int getSpeedY(){
    	return  (int) (SpeedY);
    }
}
