//import com.sun.tools.javac.util.List;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

import javax.swing.JFrame;


public class Controller extends JFrame{
	ArrayList<IView> views;
	Game game;
	TrackView track;
	KeyboardInput keyboard = new KeyboardInput();

	public Controller(){
		addKeyListener( keyboard );
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
		
		while(! keyboard.keyDownOnce( KeyEvent.VK_ENTER ) ){
			///Wait launch the game
			keyboard.poll();
		}
		
		
		while(true){
			keyboard.poll();
			if( keyboard.keyDownOnce( KeyEvent.VK_ESCAPE ) )  break;
			processInput();
			game.UpdateGame();
		}
	}
	
	 protected void processInput() {
		 if( keyboard.keyDown( KeyEvent.VK_DOWN ) ){
			 game.getCar(1).brake();
		 }
		 if( keyboard.keyDown( KeyEvent.VK_UP ) ){
			 game.getCar(1).accelerate();
		 }
		 if( keyboard.keyDown( KeyEvent.VK_LEFT ) ){
			 game.getCar(1).goLeft();
		 }
		 if( keyboard.keyDown( KeyEvent.VK_RIGHT ) ){
			 game.getCar(1).goRight();
		 }
		 
		 if( keyboard.keyDownOnce( KeyEvent.VK_ALT ) ){
			 game.getCar(1).releaseOil();
		 }
		 if( keyboard.keyDownOnce( KeyEvent.VK_SHIFT ) ){
			 game.getCar(1).releaseGlue();
		 }
		 
		 if( keyboard.keyDown( KeyEvent.VK_S ) ){
			 game.getCar(2).brake();
		 }
		 if( keyboard.keyDown( KeyEvent.VK_Z ) ){
			 game.getCar(2).accelerate();
		 }
		 if( keyboard.keyDown( KeyEvent.VK_A ) ){
			 game.getCar(2).goLeft();
		 }
		 if( keyboard.keyDown( KeyEvent.VK_D ) ){
			 game.getCar(2).goRight();
		 }
		 
		 if( keyboard.keyDownOnce( KeyEvent.VK_CAPS_LOCK ) ){
			 game.getCar(2).releaseOil();
		 }
		 if( keyboard.keyDownOnce( KeyEvent.VK_TAB ) ){
			 game.getCar(2).releaseGlue();
		 }
		 
	 }
	
}
