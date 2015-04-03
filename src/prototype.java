import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class prototype {
    Game game;



    public static void main(String args[]) throws IOException
    {
        try{
            Game game = new Game();

            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("input.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            if( (strLine = br.readLine()) != null) {
                String res = "";
                String patternStr = "CreateGame ([0-9])";
                Pattern pattern = Pattern.compile(patternStr);
                Matcher matcher = pattern.matcher(strLine);
                boolean matchFound = matcher.find();
                System.out.println(matchFound);
                if (matchFound && matcher.groupCount() >= 1) {
                    res = matcher.group(1);
                    for (int i = Integer.parseInt(res); i > 0; i--) {
                        System.out.println("CAR CREATION");
                    }
                } else {
                    return;
                }
            }
            else {
                return;
            }

            while ((strLine = br.readLine()) != null)   {

            }


            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
