/**
 * Created by Nicole on 04/05/2015.
 */

import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class CarView extends AbstractObstacleView{

    private Car car;

    private static final int LINE_THICKNESS = 4;
    private static final int LINE_GAP = 10;
    private Color lineColor = Color.red;
    BufferedImage bufferedImage;

    public CarView(Car c){
        car = c;

        bufferedImage = new BufferedImage(20,20,    BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.red);
        g2d.fillOval(0,0,18,18);
        g2d.dispose();
    }

    public void paintComponent(Graphics g){
        g.drawImage(bufferedImage,0,0,this);
    }




}
