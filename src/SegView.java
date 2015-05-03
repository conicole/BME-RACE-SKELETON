
/**
 * Created by Nicole on 03/05/2015.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SegView extends JPanel {

    public boolean car;

    public SegView(int i){
        car = true;
    }

    public SegView(){
        car = false;
    }

    public void paintComponent(Graphics g){
        //x1, y1, width, height
        g.setColor(Color.gray);
        if(!car) {
            g.fillRect(0, 0, 500, 205);
        }
        else{
                try {
                    Image img = ImageIO.read(new File("car.png"));
                    g.drawImage(img, 0, 0, 50,25, Color.gray, this);

                            //Pour une image de fond
                            //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
