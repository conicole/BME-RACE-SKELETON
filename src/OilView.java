import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class OilView extends AbstractObstacleView{

	private Oil oil;
	private static final int LINE_THICKNESS = 4;
	private static final int LINE_GAP = 10;
	private Color lineColor = Color.orange;
	BufferedImage bufferedImage;

	public OilView(Oil o){
		oil=o;
		bufferedImage = new BufferedImage(20,20,    BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bufferedImage.createGraphics();

		g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setPaint(Color.orange);
		g2d.fillRect(0,0,18,18);
		g2d.dispose();
	}

	public void paintComponent(Graphics g){
		g.setColor(Color.orange);
		g.fillRect(0,0,20,20);
		g.drawImage(bufferedImage,0,0,this);
	}

}