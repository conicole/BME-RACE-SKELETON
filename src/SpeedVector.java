public class SpeedVector {

    SpeedVector(){
	System.out.println("Speed Vector : Creation of the speed vector");
    }
    SpeedVector(int i){    }

    void decrease(int a){
    	   System.out.println("Speed Vector : decrease of "+a);
    }
 
    void increase(int a){
    	   System.out.println("Speed Vector :increase of "+a);
    }
    
    void turnRight(){
    	  System.out.println("Speed Vector : turn right");
    }
 
    void turnLeft(){
    	  System.out.println("Speed Vector : turn left");
    }

    void stop(){
        System.out.println("Speed Vector : set to zero");
    }
}
