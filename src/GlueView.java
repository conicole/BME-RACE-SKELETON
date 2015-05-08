import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

//glue view
public class GlueView extends AbstractObstacleView{

	private Glue glue;
	BufferedImage bufferedImage;

	public GlueView(Glue g){
	}
//paints component
	public void paintComponent(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(0,0,20,20);
	}
}