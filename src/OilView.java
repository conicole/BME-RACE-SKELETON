import java.awt.*;
import java.awt.image.BufferedImage;


public class OilView extends AbstractObstacleView{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage bufferedImage;
//constructor
	public OilView(Oil o){
		bufferedImage = new BufferedImage(20,20,    BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bufferedImage.createGraphics();
//redering
		g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setPaint(Color.orange);
		g2d.fillRect(0,0,18,18);
		g2d.dispose();
	}
//draws object
	public void paintComponent(Graphics g){
		g.setColor(Color.orange);
		g.fillRect(0,0,20,20);
		g.drawImage(bufferedImage,0,0,this);
	}

}