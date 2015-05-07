/**
 * Created by Nicole on 04/05/2015.
 */


import java.lang.Thread;

public class RunnerGame extends Thread {


	Controller contr;

	public RunnerGame(Controller c){
		contr = c;
	}

	public RunnerGame() { }
	public void run() {

		try {
            while(contr.winner == 11){
                contr.pollKeyboard();

                if(contr.game.getNumberofCars()!=0)
                    contr.processInput();
                   contr.winner = contr.game.UpdateGame();
                   sleep(100);
                }
            }
		 catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

