public class Car implements  ICar{

	// Definition of attributes
    private SpeedVector sv;///
    private Game g;///
    private Segment position;///
    
    //Car class constructor
    Car(){
    	sv = new SpeedVector(1);
    }
    
    //Car class constructor with object Game Parameter
    Car(Game game){
         g=game;
         sv=new SpeedVector();
         //Prints text to the output
         System.out.println("Car : Creation of a car");
         
    }
    
    //Obstacle hitted
    public void ObstacleHitted(ICar c){
    	 //Prints text to the output
        System.out.println("Car Hitted : ObstacleHitted : Car");
        //runs the carhit method of the car that his an obstacle
        c.hitCar();
        //Accelerates the car
        this.accelerate();
    }

    public void hitCar(){
    	 //Prints text to the output
         System.out.println("Car : hit a car");
         //Stops the car
         this.stop();
    }

    public void accelerate(){
    	 //Prints text to the output
        System.out.println("Car : accelerate");
        //increase the cars speed by 2
        sv.increase(2);
    }
    
    //decrease the speed vector
    public void brake(){
    	//Prints text to the output
      System.out.println("Car : brake");
      //decrease the cars speed by 1 
      sv.decrease(1);
    }
    
    public void goLeft(){
    	//Prints text to the output
      System.out.println("Car : go left");
        sv.turnLeft();
    }
    //turns to the right
    public void goRight(){
    	//Prints text to the output
      System.out.println("Car : go right");
       //turns to the right
      sv.turnRight();
    }
    
    public void stop(){
    	//Prints text to the output
        System.out.println("Hitter Car : stop");
      //Stops the car by changing speed vector to zero
        sv.stop();
    }
    
    public void hitGlue(){
    	//Prints text to the output
         System.out.println("Car : hit glue");
       //decrease the cars speed by 2
         sv.decrease(2);
    }
    
    public void hitOil(){
    	//Prints text to the output
    	System.out.println("Car : hit oil");
    	  //increase the cars speed by 2
    	sv.increase(2);
    }
    
    public void hitObstacle(){
    	//Prints text to the output
    	System.out.println("Car : hit an obstacle");
    }
    
    public void updateCarPosition(){
    	  //decrease the cars speed by 2  
    	System.out.println("Car : update car position");
        
    	g.getTrack().remove(this, position); //remove from current segment
          position = g.nextSegment(this); // move to the next segment
        //Prints text to the output
          System.out.println("Car : has a new segment position");
    }
    
    public void releaseOil(){
    	//Prints text to the output
    	System.out.println("Car : release Oil");
        //add obstacle oil to segment
    	position.addObstacle(new Oil());
    }
    public void releaseGlue(){
    	
         System.out.println("Car : release Glue");
       //add obstacle glue to segment
         position.addObstacle(new Glue());
    }
    
    //Set new position of car
    public void setPosition(Segment s){
    	position=s;
    }
    
}
