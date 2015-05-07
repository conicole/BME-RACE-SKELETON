import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class GlueView extends AbstractObstacleView{

	private Glue glue;
	BufferedImage bufferedImage;

	public GlueView(Glue g){
	}

	public void paintComponent(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(0,0,20,20);
	}
}