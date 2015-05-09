
import java.awt.*;
import java.awt.image.BufferedImage;


public class RepairCarView extends AbstractObstacleView{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
BufferedImage bufferedImage;
//constructor
	public RepairCarView(RepairCar c){
		//stores image of repair car
		bufferedImage = new BufferedImage(20,20,    BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bufferedImage.createGraphics();
		//redering
		g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON);
//sets color
		g2d.setPaint(Color.WHITE);
		g2d.fillOval(0,0,18,18);
		//sets color of text
	    g2d.setPaint(Color.RED);
	    g2d.setFont(new Font("Times Roman", Font.BOLD, 18));
		//drawing
		g2d.drawString("+", 4, 15);
		
		g2d.dispose();
	}

	//draws object
	public void paintComponent(Graphics g){
		g.drawImage(bufferedImage,0,0,this);
	}




}
