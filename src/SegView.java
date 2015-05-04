
/**
 * Created by Nicole on 03/05/2015.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SegView extends JPanel {

    public boolean car;
    private Segment segment;

    public SegView(int i){
        car = true;
    }

    public SegView(){
        car = false;
    }

    public SegView(Segment s){
        segment = s;
    }

    public void paintComponent(Graphics g){
        //x1, y1, width, height
        g.setColor(Color.gray);
        if(!car) {
            g.fillRect(0, 0, 50, 20);
        }
        else{
                try {
                    BufferedImage image = ImageIO.read(new File("car.png"));

                  //   AffineTransform af = AffineTransform.getRotateInstance(Math.toRadians(30), 0, 0);


                    g.drawImage(image, 0, 0, 50, 25, Color.gray, this);
                  //  g.dra7
                //    AffineTransform identity = new AffineTransform();

                 //   Graphics2D g2d = (Graphics2D)g;
                //    AffineTransform trans = new AffineTransform();
               //     trans.setTransform(identity);
                 //   trans.rotate( Math.toRadians(45) );
               //     trans.scale(0.2,0.2);
               //     g2d.drawImage(image, trans, this);




                            //Pour une image de fond
                            //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
