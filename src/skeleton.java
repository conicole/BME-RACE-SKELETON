import java.util.Scanner;
/**
 * Created by Nicole on 19/03/2015.
 */
public class skeleton {

    public static void writeLine(){
        System.out.println("*************");
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
        writeLine();
        notAnswered = true;

        while(notAnswered) {
            System.out.println("Please choose an option");
            System.out.println("(1) Accelerate");
            System.out.println("(2) Decelerate");
            System.out.println("(3) Next Segment");
            System.out.println("(4) Go left");
            System.out.println("(5) Go right");
            System.out.println("(6) Release Oil");
            System.out.println("(7) Release Glue");
            Scanner reader = new Scanner(System.in);
            String input = reader.nextLine();
            switch (input) {
                case "1":
                    notAnswered = false;
                    game.getCar1().accelerate();
                    break;
                case "2":
                    notAnswered = false;
                    game.getCar1().decelerate();
                    break;
                case "3":
                    notAnswered = false;
                    game.getCar1().updateCarPosition();
                    break;
                case "4":
                    notAnswered = false;
                    game.getCar1().goLeft();
                    break;
                case "5":
                    notAnswered = false;
                    game.getCar1().goRight();
                    break;
                case "6":
                    notAnswered = false;
                    game.getCar1().releaseOil();
                    break;
                case "7":
                    notAnswered = false;
                    game.getCar1().releaseGlue();
                    break;
                default:
                    System.out.println("Please enter 1 or 2");
                    break;
            }
        }



    }
}

