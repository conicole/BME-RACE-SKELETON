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
    BufferedImage bufferedImageAlive;
    BufferedImage bufferedImagedead;

    public CarView(Car c){
        car = c;

        bufferedImageAlive = new BufferedImage(20,20,    BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImageAlive.createGraphics();

        g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.red);
        g2d.fillOval(0,0,18,18);
        g2d.dispose();


        bufferedImagedead = new BufferedImage(20,20,    BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d2 = bufferedImagedead.createGraphics();

        g2d2.setRenderingHint (RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON);
        g2d2.setPaint(Color.black);
        g2d2.fillOval(0,0,18,18);
        g2d2.dispose();



    }

    public void paintComponent(Graphics g){
        if(!car.dead)
        {
            g.drawImage(bufferedImageAlive,0,0,this);
        }
        else {
            g.drawImage(bufferedImagedead,0,0,this);

        }
    }




}
