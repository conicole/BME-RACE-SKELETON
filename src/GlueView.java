import java.awt.*;
import java.awt.image.BufferedImage;

//glue view
public class GlueView extends AbstractObstacleView{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage bufferedImage;

	public GlueView(Glue g){
	}
//paints component
	public void paintComponent(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(0,0,20,20);
	}
}