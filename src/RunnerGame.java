/**
 * Created by Nicole on 04/05/2015.
 */


import java.lang.Thread;

public class RunnerGame extends Thread {


    Game game;

    public RunnerGame(Game g){
        game = g;
    }

    public RunnerGame() { }
    public void run() {

            try {
                sleep(160);
                game.UpdateGame();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
}

