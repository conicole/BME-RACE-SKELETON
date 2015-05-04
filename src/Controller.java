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
		keyboard.poll();
		while(true){
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
		 
		 if( keyboard.keyDown( KeyEvent.VK_ALT ) ){
			 game.getCar(1).releaseOil();
		 }
		 if( keyboard.keyDown( KeyEvent.VK_SHIFT ) ){
			 game.getCar(1).releaseGlue();
		 }
		 
	 }
	
}
