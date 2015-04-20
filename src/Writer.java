import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;



public class Writer  {
    public static File f;
    public static FileWriter fw;
    private static BufferedWriter bw;

    //Creates the static writer object
    public static void createWriter() throws IOException{
        f= new File("ouput.txt");
        fw= new FileWriter(f);
        bw = new BufferedWriter(fw);

    }


    //closes connection
    public static void close() throws IOException{
        bw.flush();
        bw.close();
    }


    //write go left
    public static void writeGoLeft(Car c){
        try{
            bw.append("Car "+c.getId()+" Moved_Left ");
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }
    //writes go right
    public static void writeGoRight(Car c){
        try{
            bw.append("Car "+c.getId()+" Moved_Right ");
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }
    //outputs acceleration
    public static void writeAccelerrate(Car c){
        try{
            bw.append("Car "+c.getId()+" Accelerated ");
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }
    //outputs brake
    public static void writeBrake(Car c){
        try{
            bw.append("Car "+c.getId()+" Braked ");
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }
    //ouputs when repair car moves
    public static void Move(RepairCar c, int i,int j){
    	try{
            bw.append("Repair Car "+c.getId()+" "+i+ " "+ j);
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }

    
    public static void writeOutOfTrack(Car c){
        try{
            bw.append("Car "+c.getId()+" Out_Of_Track ");
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }
    //Output for release of oil
    public static void writeReleaseOil(Car c, Oil o){
        try{
            bw.append("Car "+c.getId()+" Released_Oil "+o.getId()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }
  //Output for release of glue
    public static void writeReleaseGlue(ICar c, Glue g){
        try{
            bw.append("Car "+c.getId()+" Released_Glue "+g.getId()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }
  //Output for collision with oil
    public static void writeCollisionOil(ICar c,Oil o){
        try{
            bw.append("Car "+c.getId()+" Collided_With Oil "+o.getId()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }
  //Output for collision with glue
    public static void writeCollisionGlue(ICar c, Glue g){
        try{
            bw.append("Car "+c.getId()+" Collided_With Glue "+g.getId()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }
  //Output for collision with repair cars
    public static void writeCollisionRepairCar(Car c,RepairCar rc){
        try{
            bw.append("Car "+c.getId()+" Collided_With Repair Car "+rc.getId()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }

    //Output for collision between cars
    public static void writeCollisionCar(Car c,ICar c2){
        try{
            bw.append("Car "+c.getId()+" Collided_With Car "+c2.getID()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }
    public static void writefinish(Car c, Oil o){
    	  try{
              bw.append("Car "+c.getId()+" Wins race At "+c.getPosition().getX()+" "+c.getPosition().getY());
              bw.newLine();
          } catch(IOException e){
          	  System.err.println("Error during summarize" + e.getMessage());
          }
    }

// output for cleaning oil by repair car
    public static void writeCleanOil(RepairCar c, Oil o){
        try{
            bw.append("RepairCar "+c.getId()+" Cleaned_Patch_of Oil "+o.getId()+" From "+c.getPosition().getX()+" "+c.getPosition().getY());
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }
 
    public static void writeCleanGlue(RepairCar c, Glue g){
    // output for cleaning glue by repair car
    	try{
            bw.append("RepairCar "+c.getId()+" Cleaned_Patch_of Glue "+g.getId()+" From "+c.getPosition().getX()+" "+c.getPosition().getY());
            bw.newLine();
        } catch(IOException e){
        	  System.err.println("Error during summarize" + e.getMessage());
        }
    }

    public static void writeRepairCarBecomesOil(RepairCar rc){

    }
    //summerize
    public static void summarize(Game g){
        try{
            bw.append("-------------Summarize-----------------");
            bw.newLine();
            bw.append("Game : "+g.getTrack().getHeight()+" "+g.getTrack().getLength());
            bw.newLine();
			/*for(int i=0;i<g.nbCar;i++){
				ICar c =g.getCar(i);
				Segment p = c.getPosition();
				SpeedVector sv = c.getSpeedVector();
				bw.append("Car "+c.getId()+" Position "+p.getX()+" "+p.getY()+" Speed "+sv.getSpeedX()+" "+sv.getSpeedY());
				bw.newLine();
			}
			for(int i=0;i<g.nbRepairCar;i++){
				RepairCar c =g.getRepairCar(i);
				Segment p = c.getPosition();
				bw.append("Car "+c.getId()+" Position "+p.getX()+" "+p.getY()+" Speed "+c.getSpeedX()+" "+c.getSpeedY());
				bw.newLine();
			}*/
            Track t=g.getTrack();


            //Prints out output to file
            for(int i=0;i<t.getHeight();i++){

                for(int j=0;j<t.getLength();j++){
                    Segment s = t.getSegment(i,j);
                    for(AbstractObstacle o : s.SObs){
                        o.print(i,j);
                        //bw.newLine();
                    }
                }
            }
            bw.append("---------------------------------------");
            bw.newLine();
        } catch(IOException e){
            System.err.println("Error during summarize" + e.getMessage());

        }
    }

    public static void write(String string) {
        try {
            bw.append(string);
            bw.newLine();
        } catch (IOException e) {
            System.err.println( "Error with writing : " + e.getMessage());
        }

    }

}
