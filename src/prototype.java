import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//
//      0.0 ----> Y
//       |
//       |
//       |
//      \/
//       X

public class prototype {

    public static String[] cfgPatterns = {
            "Launch",
            "Save ([a-z]*)",
            "Load ([a-z]*)",
            "Add_Glue ([0-9]*) ([0-9]*)",
            "Add_Oil ([0-9]*) ([0-9]*)",
            "Add_Obstacle ([0-9]*) ([0-9]*)",
            "Add_Car ([0-9]*) ([0-9]*)",
            "Add_Repair_Car ([0-9]*) ([0-9]*)",
            "CreateGame ([0-9]*) ([0-9]*)",
            "Add_Grass ([0-9]) ([0-9])",
            "Create_Finish_Line ([0-9]) ([0-9]) ([0-9]) ([0-9])"
    };

    public static String[] cmdPatterns = {"End",
            "Left ([0-9]*)",
            "Right ([0-9]*)",
            "Accelerate ([0-9]*)",
            "Brake ([0-9]*)",
            "Release_Oil ([0-9]*)",
            "Release_Glue ([0-9]*)",
            "Summarize",
            "\\s*" // manage white line
    };

    Game game;
    Matcher matcher;


    public prototype() throws IOException {
        game = new Game();
        Writer.createWriter();
    }

    // check if string s respect a pattern of a configuration command. Return the number of the command(-1). Else return -1
    public  int isConfiguration(String s) {
        int res = -1;
        for (int i = 0; i < cfgPatterns.length && res == -1; i++) {
            Pattern pattern = Pattern.compile(cfgPatterns[i]);
            this.matcher = pattern.matcher(s);
            if (this.matcher.find()) {
                res = i;
            }
        }
        return res;
    }

    // check if string s respect a pattern of an input command. Return the number of the command(-1). Else return -1
    public int isInput(String s)
    {
        int res = -1;
        for (int i = 0; i < cmdPatterns.length && res == -1; i++) {
            Pattern pattern = Pattern.compile(cmdPatterns[i]);
            this.matcher = pattern.matcher(s);
            if (this.matcher.find()) {
                res = i;
            }
        }
        return res;
    }


    public static void main(String args[]) throws IOException {
        //Creates Prototype object
    	prototype proto = new prototype();
        // Open the file
        FileReader fReader = new FileReader("input.txt");
        //Creates buffer reader
            BufferedReader br = new BufferedReader(fReader);
        try {
       
          //runs configuration
            proto.run_configuration(br);
            //runs game commands
            proto.run_game(br);
           
        }
        catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        finally{
        	//close unmanaged resource
        	 br.close();
            Writer.close();
        	
        }
    }

    //Configuartion
    public void run_configuration(BufferedReader br) throws java.io.IOException {
        String strLine;
        int x;
        int y;
        //Determining the type of command
        while( (strLine = br.readLine()) != null) {
            int nbCmd = isConfiguration(strLine);
            switch(nbCmd) {
                case 0:
                    return;
                case 1:
                    this.save(matcher.group(1));
                    break;
                case 2:
                    this.load(matcher.group(1));
                    break;
                case 3:
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.init_add_glue(x,y);
                    break;
                case 4:
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.init_add_oil(x,y);
                    break;
                case 5:
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.init_add_obs(x, y);
                    break;
                case 6:
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.add_car(x, y);
                    break;
                case 7:
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.add_repairCar(x, y);
                    break;
                case 8:
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.setTrack(x,y);
                    break;
                case 9:
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.sow_grass(x,y);
                    break;
                case 10:
                    int x1 = Integer.parseInt(this.matcher.group(1));
                    int y1 = Integer.parseInt(this.matcher.group(2));
                    int x2 = Integer.parseInt(this.matcher.group(3));
                    int y2 = Integer.parseInt(this.matcher.group(4));
                    game.set_finish_line(x1,y1,x2,y2);
                    break;
                default:
                    System.out.println("Error on Config pattern");
                    break;
            }
        }
    }

    public void run_game(BufferedReader br) throws java.io.IOException {
        String strLine;
        while( (strLine = br.readLine()) != null ) {
            int nbCmd = isInput(strLine);
            this.ComputeInputCmd(nbCmd);
            game.runStep();
        }
    }



    
    public void ComputeInputCmd(int nbCmd ){
        int x;
        int y;
        
        switch(nbCmd) {
            case 0:
                return;
            case 1:
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).goLeft();
                break;
            case 2:
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).goRight();
                break;
            case 3:
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).accelerate();
                break;
            case 4:
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).brake();
                break;
            case 5:
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).releaseOil();
                break;
            case 6:
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).releaseGlue();
                break;
            case 7:
                Writer.summarize(game);
                break;
            case 8:
                break;
            default:
                    System.out.println("Error : cmd doesn't existe" );
                break;
        }
    }

    public void save(String name){
        // todo

    }


    public void load(String name){
        // todo

    }
}

