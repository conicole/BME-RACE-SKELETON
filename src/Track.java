
public class Track {
	Segment s1;
	Segment s2;
	Segment s3;
	
    public void remove(ICar car,ISegment seg)
    {

    }
    
    public Track(){
    	System.out.println("I create a Track");
    	s1=new Segment();
    	s2=new Segment();
    	s3=new Segment();

    }
    
    public void updateCarPosition(ICar c){
    	System.out.println("I update the car position on the track");
    	Segment s = new Segment();
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
