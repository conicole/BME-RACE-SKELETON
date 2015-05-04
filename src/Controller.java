//import com.sun.tools.javac.util.List;
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
	
	public void run(){
		
		//while(! keyboard.keyDownOnce( KeyEvent.VK_ENTER ) ){
			///Wait launch the game
		//	keyboard.poll();
		//}
		
		RunnerGame rg = new RunnerGame();
		while(true){
			keyboard.poll();

			processInput();
            timer++;
            if( timer%100000 == 0){
                game.UpdateGame();

            }
		}
	}
	
	 protected void processInput() {
         if( keyboard.keyDownOnce( KeyEvent.VK_ESCAPE ) ) {
             this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
         }
		 if( keyboard.keyDownOnce(KeyEvent.VK_DOWN) ){
			 game.getCar(0).brake();
		 }
		 if( keyboard.keyDownOnce(KeyEvent.VK_UP) ){
			 game.getCar(0).accelerate();
		 }
		 if( keyboard.keyDownOnce(KeyEvent.VK_LEFT) ){
			 game.getCar(0).goLeft();
		 }
		 if( keyboard.keyDownOnce(KeyEvent.VK_RIGHT) ){
			 game.getCar(0).goRight();
		 }
		 
		 if( keyboard.keyDownOnce( KeyEvent.VK_ALT ) ){
			 game.getCar(0).releaseOil();
		 }
		 if( keyboard.keyDownOnce( KeyEvent.VK_SHIFT ) ){
			 game.getCar(0).releaseGlue();
		 }
		 
		 if( keyboard.keyDown( KeyEvent.VK_S ) ){
			 game.getCar(1).brake();
		 }
		 if( keyboard.keyDown( KeyEvent.VK_Z ) ){
			 game.getCar(1).accelerate();
		 }
		 if( keyboard.keyDown( KeyEvent.VK_A ) ){
			 game.getCar(1).goLeft();
		 }
		 if( keyboard.keyDown( KeyEvent.VK_D ) ){
			 game.getCar(1).goRight();
		 }
		 
		 if( keyboard.keyDownOnce( KeyEvent.VK_CAPS_LOCK ) ){
			 game.getCar(1).releaseOil();
		 }
		 if( keyboard.keyDownOnce( KeyEvent.VK_TAB ) ){
			 game.getCar(1).releaseGlue();
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
        app.buildGame(30, 50);
        app.setVisible(true);
        app.game.getTrack().updateview();
        app.run();
    }


}
