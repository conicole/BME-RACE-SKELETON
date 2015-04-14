public class SpeedVector {
	//Represents the speed vector of the car
    SpeedVector(){
    //creation of speedvector
	System.out.println("Speed Vector : Creation of the speed vector");
    }
    SpeedVector(int i){    }

    void decrease(int a){
    	//decrease speed
    	   System.out.println("Speed Vector : decrease of "+a);
    }
 
    void increase(int a){
    	//increase speed
    	   System.out.println("Speed Vector :increase of "+a);
    }
    
    void turnRight(){
    	//moves car to the right
    	  System.out.println("Speed Vector : turn right");
    }
 
    void turnLeft(){
    	//moves car to the left
    	  System.out.println("Speed Vector : turn left");
    }

    void stop(){
    	//stops car
        System.out.println("Speed Vector : set to zero");
    }
}
