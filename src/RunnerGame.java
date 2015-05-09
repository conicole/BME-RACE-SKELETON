/**
 * Created by Nicole on 04/05/2015.
 */


import java.lang.Thread;

public class RunnerGame extends Thread {


	Controller contr;
	//constructor
	public RunnerGame(Controller c){
		contr = c;
	}
//constructor
	public RunnerGame() { }
	//runs the game
	public void run() {

		try {
			//11 means no winner
            while(contr.winner == 11){
                contr.pollKeyboard();
                //if cars are still on the track kep game on
                if(contr.game.getNumberofCars()!=0)
                    contr.processInput();
                   contr.winner = contr.game.UpdateGame();
                   sleep(100);
                }
            }
		 catch (InterruptedException e) {
			e.printStackTrace();//exception stack
		}

	}
}

