import java.lang.Math.*;

public class SpeedVector {

	double SpeedX;
	double SpeedY;
	final static int MAXSPEED = 10;
	final static int MINSPEED = 0;
	final static double ROTATION = 10;
	
    SpeedVector(){
    	SpeedX=0;
    	SpeedY=0;
    }
    SpeedVector(int i){    }

    void decrease(int a){
    	   double r= (double) Math.sqrt((double)(SpeedX*SpeedX +SpeedY*SpeedY ));
    	   r-=a;
    	   if(r>MINSPEED){
	    	   double teta = Math.atan(SpeedX/SpeedY);
	    	   SpeedX=r*Math.cos(teta);
	    	   SpeedX=r*Math.sin(teta);
    	   }
    	   else r=MINSPEED;
    }
 
    void increase(int a){
 	   double r= (double) Math.sqrt((double)(SpeedX*SpeedX +SpeedY*SpeedY ));
 	   r-=a;
 	   if(r<MAXSPEED){
	    	   double teta = Math.atan(SpeedX/SpeedY);
	    	   SpeedX=r*Math.cos(teta);
	    	   SpeedX=r*Math.sin(teta);
 	   }
 	   else r=MAXSPEED;
    }
    
    void turnRight(){
 	   double r= (double) Math.sqrt((double)(SpeedX*SpeedX +SpeedY*SpeedY ));
 	   double teta = Math.atan(SpeedX/SpeedY);
 	   teta-=ROTATION;
	   SpeedX=r*Math.cos(teta);
	   SpeedX=r*Math.sin(teta);
    }
 
    void turnLeft(){
  	   double r= (double) Math.sqrt((double)(SpeedX*SpeedX +SpeedY*SpeedY ));
  	   double teta = Math.atan(SpeedX/SpeedY);
  	   teta+=ROTATION;
 	   SpeedX=r*Math.cos(teta);
 	   SpeedX=r*Math.sin(teta);
    }

    void stop(){
    	SpeedX=0;
   	    SpeedX=0;
    }
}
