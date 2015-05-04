
public class Track {
	//Fields
	Segment[][] tabSeg;
    int height;
    int length;
    private TrackView view;
    //Constructor
    public Track(int h,int l) {
        height = h;
        length = l;
        createTrack();
        
    }
    
    public Segment[][] getTrack(){
    	return tabSeg;
    	
    }

    public void setTabSeg(Segment[][] tbS){
        tabSeg = tbS;
    }


    //create track
    private void createTrack(){
        tabSeg = new Segment[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                tabSeg[i][j] = new Segment(i,j);
            }
         
        }
    }
    public void remove(AbstractObstacle obj, Segment seg){
    	int x=seg.getX();
    	int y=seg.getY();    	
        this.tabSeg[x][y].remove(obj);
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

    public void setFinish(int x,int y){
        getSegment(x,y).setInFinishLine();
    }

    public void  setView(TrackView tv) {
        view = tv;
    }
}
