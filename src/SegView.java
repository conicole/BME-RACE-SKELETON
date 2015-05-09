
/**
 * Created by Nicole on 03/05/2015.
 */

import javax.swing.*;

import java.awt.*;


public class SegView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean car;

	private Segment segment;
	//sets view
	public SegView(int i){
		car = true;
	}
	//sets view
	public SegView(){
		car = false;
	}

	//constructor
	public SegView(Segment s){
		setLayout(new BorderLayout());
		segment = s;

	}

	//update view
	public void updateComponent(){
		this.removeAll();
		if( segment.hasObstacle() ){
			for(int i=0;i<segment.SObs.size();i++) {
				// System.out.println("seg : "+ segment.getX() + " , " + segment.getY() + " obstacle " + i);
				if (segment.SObs.get(i)!=null)
				{
					this.add(segment.SObs.get(i).getView());
				}
			}


		}



	}

	public void paintComponent(Graphics g){

		if(segment.isOutOfTrack){

			if(TrackView.getGrassImg()==null)
			{
				g.setColor(new Color(0,102,0));
				g.fillRect(0, 0, 20,20);
			}
			else{
				g.drawImage(TrackView.getGrassImg(), 0, 0,this);
			}



		}
		else if(segment.isFinishLine){
			int CHECKER_SIZE = 10;

			g.setColor(Color.white);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.BLACK);
			for (int stripeX = 0; stripeX < getWidth(); stripeX += CHECKER_SIZE) {
				for (int y = 0, row = 0; y < getHeight(); y += CHECKER_SIZE/2, ++row) {
					int x = (row % 2 == 0) ? stripeX : (stripeX + CHECKER_SIZE/2);
					g.fillRect(x, y, CHECKER_SIZE/2, CHECKER_SIZE/2);
				}
			}
		}

		else{


			if(TrackView.getGrassImg()==null)
			{
				g.setColor(Color.gray);
				g.fillRect(0, 0, 20,20);
			}
			else{
				g.drawImage(TrackView.getRoadImg(), 0, 0,this);
			}
		}


	}


}
