import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nicole on 04/05/2015.
 */
public class StartMenu extends JPanel implements IView   {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//paints component on screen
    public void paintComponent(Graphics g) {
        try {
        	//sets image as background
            File img = new File("start.png");
            BufferedImage image = ImageIO.read(img);
            g.drawImage(image,0,0,this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
