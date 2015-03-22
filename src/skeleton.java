import java.util.Scanner;
/**
 * Created by Nicole on 19/03/2015.
 */
public class skeleton {

	//Demo program to test all features of the use cases
    public static void writeLine(){
    	//output
        System.out.println("*****************");
    }
    public static void main(String[] args){
        //Decoration
    	writeLine();
        System.out.println("Skeleton Program ");
       //Decoration
        writeLine();
        
        boolean notAnswered = true;

        while(notAnswered) {
        	//Ask input from the user
            System.out.println("Please choose an option");
            System.out.println("(1) New game");
            System.out.println("(2) Quit Program");
            
            //Get input from user
            
            Scanner reader = new Scanner(System.in);
            String input = reader.nextLine();
            reader.close();
            //Finds out what was selected by the user
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
        //Decoration
        writeLine();
        System.out.println("Launch game");
        
        //Creates a new game
        Game game = new Game();
        game.createGame();

        notAnswered = true;

        while(notAnswered) {
            writeLine();
            //Outputs to the user
            System.out.println("Please choose an option");
            System.out.println("(1) Accelerate");
            System.out.println("(2) Decelerate");
            System.out.println("(3) Next Segment");
            System.out.println("(4) Go left");
            System.out.println("(5) Go right");
            System.out.println("(6) Release Oil");
            System.out.println("(7) Release Glue");
            System.out.println("(8) Quit game");
            
            // Gets input from the user
            Scanner reader = new Scanner(System.in);
            String input = reader.nextLine();
            //Close connection 
            reader.close();
            
            //Use input from user to perform a particular task
            switch (input) {
                case "1":
                	
                    writeLine();
                    game.getCar1().accelerate();
                    break;
                case "2":
                    writeLine();
                    game.getCar1().brake();
                    break;
                case "3":
                    writeLine();
                    game.getCar1().updateCarPosition();
                    break;
                case "4":
                    writeLine();
                    game.getCar1().goLeft();
                    break;
                case "5":
                    writeLine();
                    game.getCar1().goRight();
                    break;
                case "6":
                    writeLine();
                    game.getCar1().releaseOil();
                    break;
                case "7":
                    writeLine();
                    game.getCar1().releaseGlue();
                    break;
                case "8":
                    writeLine();
                    System.out.println("Quit Game");
                    return;
                default:
                    writeLine();
                    System.out.println("Please enter your choice");
                    break;
            }
        }



    }
}

