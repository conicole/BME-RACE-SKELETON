
public class Game {
  
  private Track track;
  private ICar car1;
  private ICar car2;


    public void createGame()
    {
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


  
}
