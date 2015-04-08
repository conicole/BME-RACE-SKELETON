import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class prototype {

    public static String[] cfgPatterns = {
            "Launch",
            "End",
            "Save ([a-z]*)",
            "Load ([a-z]*)",
            "Add_Glue [0-9]",
            "Add_Oil [0-9]",
            "Add_Obstacle [0-9]",
            "Add_Car [Position]",
            "Add_Repair_Car [Position][0-9]",
            "CreateGame ([0-9])",
            "Add_Grass ([0-9])([0-9])",
            "Create_Finish_Line ([0-9])([0-9])([0-9])([0-9])"
    };

    Game game;


    public prototype() {
        game = new Game();
    }

    // check if string s respect a pattern of a configuration command. Return the number of the command(-1). Else return -1
    public static int isConfiguration(String s) {
        int res = -1;
        //System.out.println("let's check " + s);
        for (int i = 0; i < cfgPatterns.length && res == -1; i++) {
            Pattern pattern = Pattern.compile(cfgPatterns[i]);
            Matcher matcher = pattern.matcher(s);
           // System.out.println(cfgPatterns[i]);
            if (matcher.find()) {
                res = i;

            }
        }
        return res;
    }


    public static void main(String args[]) throws IOException {
        prototype proto = new prototype();
        try {
            Game game = new Game();

            // Open the file
            FileInputStream fstream = new FileInputStream("input.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            br.mark(100);
            while ((strLine = br.readLine()) != null) {
                if (isConfiguration(strLine) != -1) {
                    proto.configuration(br);
                }

                in.close();
            }
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }


    public void configuration(BufferedReader br) throws java.io.IOException {
        br.reset();
        String strLine;
        if ((strLine = br.readLine()) != null) {
            int nbCmd = isConfiguration(strLine);
            System.out.println(nbCmd);
            this.ComputeCfgCmd(nbCmd);


            // res = matcher.group(1);


        }
        br.reset();
    }


    public void ComputeCfgCmd(int nbCmd ){
        System.out.println("cmd + "+ nbCmd);
        switch(nbCmd) {
            case 9:
                System.out.println("Creation of game");
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}

