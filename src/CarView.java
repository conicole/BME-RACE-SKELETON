/**
 * Created by Nicole on 04/05/2015.
 */

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;



public class CarView extends AbstractObstacleView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//initialization
    private Car car;
    BufferedImage bufferedImageAlive;
    BufferedImage bufferedImagedead;

    
    //costructor
    public CarView(Car c){
        car = c;
        //set appearance of cars 
        bufferedImageAlive = new BufferedImage(20,20, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImageAlive.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.red);
        g2d.fillOval(0, 0, 18, 18);
        g2d.setPaint(Color.white);
        //sets fontsize
        int fontSize = 17;
        //set font
        g2d.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
        //draw string on car
        g2d.drawString(car.getID(), 5, 16);
        
        //create appearance when dead
        
        bufferedImagedead = new BufferedImage(20,20,    BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d2 = bufferedImagedead.createGraphics();

        g2d2.setRenderingHint (RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON);
        g2d2.setPaint(Color.black);
        g2d2.fillOval(0,0,18,18);
        
        g2d2.setPaint(Color.RED);
        g2d2.setFont(new Font("Times Roman", Font.BOLD, fontSize));
        //draw x on dead car
        g2d2.drawString("x", 5, 14);
        g2d2.dispose();



    }
    //paints car to screen
    public void paintComponent(Graphics g){
       //if car is alive change the appearance of the car
    	if(!car.dead)
        {
            AffineTransform at = new AffineTransform();
            double rot = ((car.getSpeedVector().teta)+90)*(Math.PI/180);
         
            at.translate(getWidth() / 2, getHeight() / 2);

            at.rotate( rot );
            at.translate(-bufferedImageAlive.getWidth()/2, -bufferedImageAlive.getHeight()/2);


            Graphics2D g2d = (Graphics2D) g;
           g2d.drawImage(bufferedImageAlive,at,this);
        }
        else {
        	   //if car is dead change the appearance of the car
            g.drawImage(bufferedImagedead,0,0,this);

        }
    }




}
