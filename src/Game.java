
public class Game {
  
  private Track track;
  private ICar car1;
  private ICar car2;

  		//create new game
    public void createGame()
    {
    	//Prints text to the output
    	System.out.println("Game : Creation of the game");
        //Definitions of attributes
    	track = new Track();
        car1 = new Car(this);
        car2 = new Car(this);
        car1.setPosition(track.gets1());//initialize position of car 1
        car2.setPosition(track.gets2());//initialize position of car 2
        track.gets3().addObstacle(new Obstacle());
    }

    public Track getTrack(){
        return track;
    }

    //gets car 1
    public ICar getCar1(){
        return car1;
    }
  //gets car 2
    public ICar getCar2(){
        return car2;
    }
    
    //Gets the next segments to move to
    
    public Segment nextSegment(ICar c){
    	//output to screen
    	System.out.println("Game : Compute the next segment of the Car");
        Segment newSegment = new Segment();
        //updates the car's position
    	track.updateCarPosition(c,newSegment);
    	return newSegment;
    }


  
}
