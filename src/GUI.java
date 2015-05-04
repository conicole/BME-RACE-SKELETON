import javax.swing.*;

import java.awt.*;

/**
 * Created by Nicole on 03/05/2015.
 */
public class GUI extends JFrame {

    Game game;
    Controller controller;
    KeyboardInput keyboard = new KeyboardInput();
    

    public GUI() {
    	controller = new Controller(keyboard);
        this.setTitle("BME - RACE");
        //Instanciation d'un objet JPanel
       // TrackView trv = new TrackView();
        //Définition de sa couleur de fond
    //    pan.setBackground(Color.ORANGE);
        //On prévient notre JFrame que notre JPanel sera son content pane
       // this.setContentPane(trv);
       // this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(1050, 650);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       setResizable(false);
    }

    public void buildGame(int sizeX,int sizeY){
        GameFactory gf = new GameFactory();
        game = gf.createGame(sizeX,sizeY);
        controller.setGame(game);
        // put the track view as major panel
        this.setContentPane(game.getTrackView());
        

    }
    
    public void run(){
    	controller.run();
    }

    

    public static void main(String args[]) {

        GUI g = new GUI();
        g.buildGame(30,50);
        g.setVisible(true);
        g.game.getTrack().updateview();
        g.run();

    }
}
