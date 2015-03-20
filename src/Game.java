
public class Game {
  
  private Track track;
  private ICar car1;
  private ICar car2;


    public void createGame()
    {
    	System.out.print("Creation of the game\n");
        track = new Track();
        car1 = new Car(this);
        car2 = new Car(this);
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
    	System.out.println("Calcul of the next segment of the Car\n");
    	System.out.println("Compute new position\n");
    	track.updateCarPosition(c);
    	return new Segment();
    }


  
}
