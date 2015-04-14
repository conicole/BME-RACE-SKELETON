
public class Track {
	Segment[][] tabSeg;
    int height;
    int length;
    int area = height*length;

    public Track(int l,int h) {
        height = h;
        length = l;
        createTrack();
    }

    private void createTrack(){
        tabSeg = new Segment[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                tabSeg[i][j] = new Segment(i,j);
            }
        }
    }
    public void remove(AbstractObstacle obj, Segment seg){
        int segX = seg.getId()/length;
        int segY = seg.getId()%height;
        tabSeg[segX][segY].remove(obj);
    }

    public Track(){
        height = 10;
        length = 10;
        createTrack();
    }
    
    public void updateCarPosition(ICar c, ISegment s ){
    	s.CarIsComing(c);
    }
    
    public Segment getSegment(int i, int j){
    	return tabSeg[i][j];
    }
    
    public int getHeight(){
    	return height;
    }
    
    public int getLength(){
    	return length;
    }
}
