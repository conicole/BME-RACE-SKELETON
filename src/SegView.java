
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
        setLayout(new BorderLayout());
        segment = s;
    }

    public void updateComponent(){
        this.removeAll();
        if( segment.hasObstacle() ){
            for(int i=0;i<segment.SObs.size();i++) {
                    this.add(segment.SObs.get(i).getView());
            }

        }

    }

    public void paintComponent(Graphics g){

        //x1, y1, width, height
        g.setColor(Color.gray);
        g.fillRect(0, 0, 20,20);

    }
}
