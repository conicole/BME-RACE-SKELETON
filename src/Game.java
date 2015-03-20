
public class Game {
  
  private Track track;
  private ICar car1;
  private ICar car2;


    public void createGame()
    {
    	System.out.println("Game : Creation of the game");
    	System.out.println("Game : new Track");
        track = new Track();
        car1 = new Car(this);
        car2 = new Car(this);
        car1.setPosition(track.gets1());
        car2.setPosition(track.gets2());
        track.gets3().addObstacle(new Obstacle());
    }

    public Track getTrack(){
        return track;
    }

    public ICar getCar1(){
        return car1;
    }

    public ICar getCar2(){
        return car2;
    }
    
    public Segment nextSegment(ICar c){
    	System.out.println("Game : Calcul of the next segment of the Car");
    	System.out.println("Game : Compute new position");
    	track.updateCarPosition(c);
    	return new Segment();
    }


  
}
