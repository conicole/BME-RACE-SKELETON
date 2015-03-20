
public class Track {
	Segment s1;
	Segment s2;
	Segment s3;
	
    public void remove(ICar car,ISegment seg)
    {
    	System.out.println("Track : remove the car of the position");
    	seg.remove(car);
    }
    
    public Track(){
    	System.out.println("Track : creation a Track");
    	s1=new Segment();
    	s2=new Segment();
    	s3=new Segment();

    }
    
    public void updateCarPosition(ICar c, ISegment s ){
    	System.out.println("Track : Updating the car position on the track");
    	s.CarIsComing(c);
    }
    
    public Segment gets1(){
    	return s1;
    }
    
    public Segment gets2(){
    	return s2;
    }
    
    public Segment gets3(){
    	return s3;
    }
}
