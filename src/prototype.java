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

	//Stores all the syntax of the input language
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
            "Create_Finish_Line ([0-9]*) ([0-9]*)"
    };
  //Stores all the syntax of the input language configuration
    public static String[] cmdPatterns = {"End",
            "Left ([0-9]*)",
            "Right ([0-9]*)",
            "Accelerate ([0-9]*)",
            "Brake ([0-9]*)",
            "Release_Oil ([0-9]*)",
            "Release_Glue ([0-9]*)",
            "Summarize",
            "\\s*", // manage white line
            "-"
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
    public void run_configuration(BufferedReader br) throws java.io.IOException, ClassNotFoundException {
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
                	//saving config
                    this.save(matcher.group(1));
                    break;
                case 2:
                	//Loading config
                    this.load(matcher.group(1));
                    break;
                case 3:
                	//Adding glue
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.init_add_glue(x,y);
                    break;
                case 4:
                	//adding oil
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.init_add_oil(x,y);
                    break;
                case 5:
                	//Adding Obstacles
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.init_add_obs(x, y);
                    break;
                case 6:
                	//Creating car
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.add_car(x, y);
                    break;
                case 7:
                	//Creating RepairCar
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.add_repairCar(x, y);
                    break;
                case 8:
                	//Creating Track
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.setTrack(x,y);
                    break;
                case 9:
                	//setting up track
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.sow_grass(x,y);
                    break;
                case 10:
                	//Seting up finish line
               /* 	int i=1;
                	while(this.matcher.group(i) != null && this.matcher.group(i+1) != null){
                    int x1 = Integer.parseInt(this.matcher.group(i));
                    int y1 = Integer.parseInt(this.matcher.group(i+1));
                      game.set_finish_line(x1,y1);
                      i=+2;
                	}
*/
                    x = Integer.parseInt(this.matcher.group(1));
                    y = Integer.parseInt(this.matcher.group(2));
                    game.set_finish_line(x,y);
                    break;
                default:
                	//If error occurs
                    System.out.println("Error on Config pattern");
                    break;
            }
        }
    }

    //Runs the game
    public void run_game(BufferedReader br) throws java.io.IOException {
        String strLine;
        int gameOn = 11;
        while( ((strLine = br.readLine()) != null ) && gameOn == 11) {
            int nbCmd = isInput(strLine);
            this.ComputeInputCmd(nbCmd);
            gameOn = game.UpdateGame();
        }
    }



    //determines what each commands does
    public void ComputeInputCmd(int nbCmd ){
        int x;
        int y;
        switch(nbCmd) {
            case 0:
                return;
            case 1:
            	//go left
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).goLeft();
                break;
            case 2:
            	//go right
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).goRight();
                break;
            case 3:
            	//accelerate
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).accelerate();
                break;
            case 4:
            	//accelerate
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).brake();
                break;
            case 5:
            	//release oil
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).releaseOil();
                break;
            case 6:
            	//release glue
            	x = Integer.parseInt(this.matcher.group(1));
                game.getCar(x-1).releaseGlue();
                break;
            case 7:
            	//create summmary
                Writer.summarize(game);
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                    System.out.println("Error : cmd doesn't existe" );
                break;
        }
    }

    
    //save config file
    public void save(String name) throws IOException{
        // todo
    	FileOutputStream f =
    		new FileOutputStream(name);
    	ObjectOutputStream out =
    		new ObjectOutputStream(f);
    	try {
    	
    		out.writeObject(game);
    		
    	}
    	finally{
    	out.close();	
    	}
    }

 //load game from config file
    public Game load(String name) throws IOException, ClassNotFoundException{
    	FileInputStream f =
    		new FileInputStream(name);
    		ObjectInputStream in =
    		new ObjectInputStream(f);
    	try {
    		
    		Game o_ins = (Game)in.readObject();
    		
    		return o_ins;
    		}
    	finally{
    		in.close();
    	}
    }
}

