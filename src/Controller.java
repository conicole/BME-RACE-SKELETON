//import com.sun.tools.javac.util.List;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class Controller extends JFrame {
	ArrayList<IView> views;
	Game game;
	TrackView track;
	KeyboardInput keyboard;
    int timer;

	public Controller(){
        timer = 0;
        keyboard = new KeyboardInput();
        this.addKeyListener(keyboard);
        this.setTitle("BME - RACE");
        this.setSize(1050, 650);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
	}
	
	public void addViews(IView v){
		views.add(v);
	}
	
	public void setTrackView(TrackView t){
		track=t;
	}
	
	public void setGame(Game t){
		game=t;
	}
	
	public int run(){
		
		//while(! keyboard.keyDownOnce( KeyEvent.VK_ENTER ) ){
			///Wait launch the game
		//	keyboard.poll();
		//}
		
		RunnerGame rg = new RunnerGame();
        int res = 11;
		while(res == 11){
			keyboard.poll();
			
			if(game.getNumberofCars()!=0)
				processInput();
			
			timer++;
			if( timer%500000 == 0){
				res = game.UpdateGame();
			}
		}
        return res;
	}
	
	 protected void processInput() throws java.lang.NullPointerException {
         try {
             if (keyboard.keyDownOnce(KeyEvent.VK_ESCAPE)) {
                 this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
             }
             if (keyboard.keyDownOnce(KeyEvent.VK_DOWN)) {
                 game.getCar(0).brake();
             }
             if (keyboard.keyDownOnce(KeyEvent.VK_UP)) {
                 game.getCar(0).accelerate();
             }
             if (keyboard.keyDownOnce(KeyEvent.VK_LEFT)) {
                 game.getCar(0).goLeft();
             }
             if (keyboard.keyDownOnce(KeyEvent.VK_RIGHT)) {
                 game.getCar(0).goRight();
             }

             if (keyboard.keyDownOnce(KeyEvent.VK_CONTROL)) {
                 game.getCar(0).releaseOil();
             }
             if (keyboard.keyDownOnce(KeyEvent.VK_SHIFT)) {

                 game.getCar(0).releaseGlue();

             }

             if (keyboard.keyDownOnce(KeyEvent.VK_S)) {
                 game.getCar(1).brake();
             }
             if (keyboard.keyDownOnce(KeyEvent.VK_W)) {
                 game.getCar(1).accelerate();
             }
             if (keyboard.keyDownOnce(KeyEvent.VK_A)) {
                 game.getCar(1).goLeft();
             }
             if (keyboard.keyDownOnce(KeyEvent.VK_D)) {
                 game.getCar(1).goRight();
             }

             if (keyboard.keyDownOnce(KeyEvent.VK_CAPS_LOCK)) {
                 game.getCar(1).releaseOil();
             }
             if (keyboard.keyDownOnce(KeyEvent.VK_TAB)) {
                 game.getCar(1).releaseGlue();
             }
         }
         catch (NullPointerException e){
             System.err.println("Car " + e.getMessage() + " is not on the circuit ");
         }
		 
	 }

    public void buildGame(int sizeX,int sizeY){
        GameFactory gf = new GameFactory();
        game = gf.createGame(sizeX,sizeY);
        // put the track view as major panel
        this.setContentPane(game.getTrackView());
    }

    public static void main(String[] args) {

        Controller app = new Controller();
        StartMenu sm = new StartMenu();
        app.setContentPane(sm);
        app.setSize(578, 456);
        app.setLocationRelativeTo(app.getParent());
        app.setVisible(true);



        while (true) {

            ///Wait launch the game
            while(!app.keyboard.keyDownOnce(KeyEvent.VK_ENTER)) {
                app.keyboard.poll();
            }

            app.setVisible(false);
            app.buildGame(30, 50);
            app.setSize(1050, 650);
            app.setLocationRelativeTo(app.getParent());
            app.setVisible(true);


            app.game.getTrack().updateview();
            int winner = app.run();

            if(winner==10){
             	app.setVisible(false);
                Crash wm = new Crash();
                app.setContentPane(wm);
                app.setSize(595, 410);
                app.setLocationRelativeTo(app.getParent());
                app.setVisible(true);
            }
            else if(winner==0){
            	app.setVisible(false);
            	WinMenu wm = new WinMenu();
            	app.setContentPane(wm);
            	app.setSize(499, 498);
            	app.setLocationRelativeTo(app.getParent());
            	app.setVisible(true);
            }
            else if(winner==1){
            	app.setVisible(false);
            	WinMenu2 wm2 = new WinMenu2();
            	app.setContentPane(wm2);
            	app.setSize(499, 498);
            	app.setLocationRelativeTo(app.getParent());
            	app.setVisible(true);
            }


        }


    }



}
