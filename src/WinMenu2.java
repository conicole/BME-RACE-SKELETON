import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nicole on 06/05/2015.
 */
public class WinMenu2 extends JPanel implements IView   {


    public void paintComponent(Graphics g) {
        try {
            File img = new File("WIN2.jpg");
            BufferedImage image = ImageIO.read(img);
            g.drawImage(image,0,0,this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
