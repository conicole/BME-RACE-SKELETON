/**
 * Created by Nicole on 04/05/2015.
 */


import java.lang.Thread;

public class RunnerGame extends Thread {


    Game game;

    public RunnerGame(Game g){
        game = g;
    }


    public void run() {
        while(true){
            try {
                sleep(80);
                game.UpdateGame();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
