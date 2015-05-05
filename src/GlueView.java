import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class GlueView extends AbstractObstacleView{

    private Glue glue;
    private static final int LINE_THICKNESS = 4;
    private static final int LINE_GAP = 10;
    private Color lineColor = Color.green;
    BufferedImage bufferedImage;

    public GlueView(Glue g){
    	glue=g;
        bufferedImage = new BufferedImage(20,20,    BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.green);
        g2d.fillRect(0,0,18,18);
        g2d.dispose();
    }

    public void paintComponent(Graphics g){
        g.drawImage(bufferedImage,0,0,this);
    }

}