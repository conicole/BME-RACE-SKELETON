import com.sun.tools.javac.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.JFrame;


public class Controller extends JFrame{
	List<IView> views;
	Game game;
	TrackView track;

	public Controller(Game g){
		game = g;
		KeyboardInput keyboard = new KeyboardInput();
		addKeyListener( keyboard );
	}
	
	public void addViews(IView v){
		views.add(v);
	}
	
	public void setTrackView(TrackView t){
		track=t;
	}
	
}
