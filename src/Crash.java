import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Crash extends JPanel implements IView   {


	//Displays that all cars are out of the race

    public void paintComponent(Graphics g) {
        try {
        	//background image
            File img = new File("Crash.jpg");
            BufferedImage image = ImageIO.read(img);
            g.drawImage(image,0,0,this);

        } catch (IOException e) {
            e.printStackTrace();
            
        }

    }

}
