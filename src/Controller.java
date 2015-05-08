//import com.sun.tools.javac.util.List;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Controller extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Declaration
	ArrayList<IView> views;
	Game game;
	TrackView track;
	KeyboardInput keyboard;
    int timer;
    int winner;
    JPanel card;
    
    //constructor of the controller
	public Controller(){
        timer = 0;
        keyboard = new KeyboardInput();
        this.addKeyListener(keyboard);
        this.setTitle("BME - RACE");
        this.setSize(1050, 650);//screensize
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);//not resizable
        winner = 11;
        card = new JPanel();
        OverlayLayout ov = new OverlayLayout(card);
        card.setLayout(ov);
	}
	
	public void addViews(IView v){
		views.add(v);//add view
	}
	
	public void setTrackView(TrackView t){
		track=t; //addview
	}
	
	public void setGame(Game t){
		game=t;//set game
	}

    public void pollKeyboard(){
        keyboard.poll();//wait for keyboeard
    }
	
	public void run() throws InterruptedException {
		

		//run game
		RunnerGame rg = new RunnerGame(this);
        rg.run();
        rg.join();
        System.out.println(winner);

	}
	
	//red keyboard input
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
             if (keyboard.keyDownOnce(KeyEvent.VK_Q)) {
                 game.getCar(1).releaseGlue();
             }
         }
         catch (NullPointerException e){
             System.err.println("Car " + e.getMessage() + " is not on the circuit ");
         }
		 
	 }

	 //reset game
    public void reset(){
        winner = 11;
    }

    //build game
    public void buildGame(int sizeX,int sizeY){
        //empty cards
    	card.removeAll();
        GameFactory gf = new GameFactory();
        game = gf.createGame(sizeX,sizeY);
        // put the track view as major panel
        this.setContentPane(card);
        startTimer st = new startTimer();
        card.add(st);
        card.add(game.getTrackView());
        setSize(1050, 650);
        setLocationRelativeTo(getParent());
        setVisible(true);
        st.WaitEndTimer();
    }

    //main of the application
    public static void main(String[] args) {
    	//creates controller
        Controller app = new Controller();
        //creates start screen
        StartMenu sm = new StartMenu();
        app.setContentPane(sm);
        app.setSize(578, 456);
        app.setLocationRelativeTo(app.getParent());
        //screen visible
        app.setVisible(true); 



        while (true) {


            ///Wait launch the game
            while(!app.keyboard.keyDownOnce(KeyEvent.VK_ENTER)) {
                app.keyboard.poll();
            }
            //make game visible
            app.setVisible(false);
            app.buildGame(30, 50);


            //load track view
            app.game.getTrack().updateview();
            try {
                app.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(app.winner==10){
            	//if all cars crash out
             	app.setVisible(false);
                Crash wm = new Crash();
                app.setContentPane(wm);
                app.setSize(595, 410);
                app.setLocationRelativeTo(app.getParent());
                app.setVisible(true);
            }
            else if(app.winner==0){
            	//if there is a winner and it is car 1
            	app.setVisible(false);
            	WinMenu wm = new WinMenu();
            	app.setContentPane(wm);
            	app.setSize(499, 498);
            	app.setLocationRelativeTo(app.getParent());
            	app.setVisible(true);
            }
            else if(app.winner==1){
            	//if there is a winner and it is car 2
            	app.setVisible(false);
            	WinMenu2 wm2 = new WinMenu2();
            	app.setContentPane(wm2);
            	app.setSize(499, 498);
            	app.setLocationRelativeTo(app.getParent());
            	app.setVisible(true);
            }
            //reset game
            app.reset();



        }


    }



}
