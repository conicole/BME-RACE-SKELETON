
/**
 * Created by Nicole on 03/05/2015.
 */

import javax.swing.*;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class SegView extends JPanel {

	public boolean car;



	private Segment segment;

	public SegView(int i){
		car = true;
	}

	public SegView(){
		car = false;
	}

	public SegView(Segment s){
		setLayout(new BorderLayout());
		segment = s;
	}

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
			g.setColor(new Color(0,102,0));
			g.fillRect(0, 0, 20,20);



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
			g.setColor(Color.gray);
			g.fillRect(0, 0, 20,20);

		}


	}


}
