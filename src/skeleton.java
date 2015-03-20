import java.util.Scanner;
/**
 * Created by Nicole on 19/03/2015.
 */
public class skeleton {

    public static void writeLine(){
        System.out.println("*****************");
    }
    public static void main(String[] args){
        writeLine();
        System.out.println("Skeleton Program ");
        writeLine();
        boolean notAnswered = true;

        while(notAnswered) {
            System.out.println("Please choose an option");
            System.out.println("(1) New game");
            System.out.println("(2) Quit Program");
            Scanner reader = new Scanner(System.in);
            String input = reader.nextLine();
            switch (input) {
                case "1":
                    notAnswered = false;
                    break;
                case "2":
                    return;
                default:
                    System.out.println("Please enter 1 or 2");
                    break;
            }
        }

        writeLine();
        System.out.println("Launch game");
        Game game = new Game();
        game.createGame();

        notAnswered = true;

        while(notAnswered) {
            writeLine();
            System.out.println("Please choose an option");
            System.out.println("(1) Accelerate");
            System.out.println("(2) Decelerate");
            System.out.println("(3) Next Segment");
            System.out.println("(4) Go left");
            System.out.println("(5) Go right");
            System.out.println("(6) Release Oil");
            System.out.println("(7) Release Glue");
            System.out.println("(8) Quit game");
            Scanner reader = new Scanner(System.in);
            String input = reader.nextLine();
            switch (input) {
                case "1":
                    writeLine();
                    game.getCar1().accelerate();
                    writeLine();
                    break;
                case "2":
                    writeLine();
                    game.getCar1().brake();
                    writeLine();
                    break;
                case "3":
                    writeLine();
                    game.getCar1().updateCarPosition();
                    writeLine();
                    break;
                case "4":
                    writeLine();
                    game.getCar1().goLeft();
                    writeLine();
                    break;
                case "5":
                    writeLine();
                    game.getCar1().goRight();
                    writeLine();
                    break;
                case "6":
                    writeLine();
                    game.getCar1().releaseOil();
                    writeLine();
                    break;
                case "7":
                    writeLine();
                    game.getCar1().releaseGlue();
                    writeLine();
                    break;
                case "8":
                    writeLine();
                    System.out.println("Quit Game");
                    writeLine();
                    return;
                default:
                    writeLine();
                    System.out.println("Please enter your choice");
                    writeLine();
                    break;
            }
        }



    }
}

