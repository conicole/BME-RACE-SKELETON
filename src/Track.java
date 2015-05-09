
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


	}
    //gets track
	public Segment[][] getTrack(){
		return tabSeg;

	}
	//sets track segments
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
	
	//removes obj from a seg
	public void remove(AbstractObstacle obj, Segment seg){
		int x=seg.getX();
		int y=seg.getY();    	
		this.tabSeg[x][y].remove(obj);
	}
//constructor
	public Track(){
		height = 10;
		length = 10;
		createTrack();

	}
//updates the position of a car
	public void updateCarPosition(ICar c, ISegment s ){
		s.CarIsComing(c);
	}
//gets a segment
	public Segment getSegment(int i, int j){

		return tabSeg[i][j];
	}

	//gets height of track
	public int getHeight(){
		return height;
	}
//sets lenght
	public int getLength(){
		return length;
	}
//sets finish line
	public void setFinish(int x,int y){
		getSegment(x,y).setInFinishLine();
	}
//sets view
	public void  setView(TrackView tv) {
		view = tv;
	}
//gets view
	public TrackView getView(){
		return view;
	}
//updates view
	public void updateview(){
		this.view.updateView();
	}
}
