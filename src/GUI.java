import javax.swing.*;
import java.awt.*;

/**
 * Created by Nicole on 03/05/2015.
 */
public class GUI extends JFrame {

    public GUI() {
        this.setTitle("BME - RACE");
        //Instanciation d'un objet JPanel
        TrackView trv = new TrackView();
        //Définition de sa couleur de fond
    //    pan.setBackground(Color.ORANGE);
        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(trv);
       // this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(1000,700);
        this.setVisible(true);
        setResizable(false);
    }


    public static void main(String args[]) {
        GUI g = new GUI();

    }
}
