
public class Track {
    public void remove(ICar car,ISegment seg)
    {

    }
    
    public void updateCarPosition(ICar c){
    	System.out.println("I update the car position on the track");
    	Segment s = new Segment();
    	s.CarIsComing(c);
    }
}
