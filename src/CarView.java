/**
 * Created by Nicole on 04/05/2015.
 */

import javax.swing.JComponent;
import java.awt.*;

public class CarView extends AbstractObstacleView{

    private Car car;

    public CarView(Car c){
        car = c;
    }

    public void paintComponent(Graphics g){
        //x1, y1, width, height

        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(0,0,20,20);
    }


}
