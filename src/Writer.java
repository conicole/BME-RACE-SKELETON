import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;



public class Writer {
	public static File f= new File("ouput.txt");
	public static FileWriter fw=new FileWriter(f);
	private static BufferedWriter bw = new BufferedWriter(fw);
	
	public static void writeGoLeft(Car c){
		try{
			bw.append("Car "+c.getId()+" Moved_Left ");
			bw.newLine();
		} catch(IOException e){
			
		}
	}
	
	public static void writeGoRight(Car c){
		try{
			bw.append("Car "+c.getId()+" Moved_Right ");
			bw.newLine();
		} catch(IOException e){
			
		}
	}
	
	public static void writeAccelerrate(Car c){
		try{
			bw.append("Car "+c.getId()+" Accelerated ");
			bw.newLine();
		} catch(IOException e){
			
		}
	}
	
	public static void writeBrake(Car c){
		try{
			bw.append("Car "+c.getId()+" Braked ");
			bw.newLine();
		} catch(IOException e){
			
		}
	}
	
	public static void writeGoLeft(RepairCar c, int i){
		
	}
	
	public static void writeGoRight(RepairCar c, int i){
		
	}
	
	public static void writeAcceleratet(RepairCar c, int i){
		
	}
	
	public static void writeBrake(RepairCar c, int i){
		
	}
	
	public static void writeOutOfTrack(Car c){
		try{
			bw.append("Car "+c.getId()+" Out_Of_Track ");
			bw.newLine();
		} catch(IOException e){
			
		}
	}
	
	public static void writeReleaseOil(Car c, Oil o){
		try{
			bw.append("Car "+c.getId()+" Released_Oil "+o.getId()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
			bw.newLine();
		} catch(IOException e){
			
		}
	}
	
	public static void writeReleaseGlue(Car c, Glue g){
		try{
			bw.append("Car "+c.getId()+" Released_Glue "+g.getId()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
			bw.newLine();
		} catch(IOException e){
			
		}
	}
	
	public static void writeCollisionOil(Car c,Oil o){
		try{
			bw.append("Car "+c.getId()+" Collided_With Oil "+o.getID()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
			bw.newLine();
		} catch(IOException e){
			
		}
	}
	
	public static void writeCollisionGlue(Car c, Glue g){
		try{
			bw.append("Car "+c.getId()+" Collided_With Glue "+g.getId()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
			bw.newLine();
		} catch(IOException e){
			
		}
	}
	
	public static void writeCollisionRepairCar(Car c,RepairCar rc){
		try{
			bw.append("Car "+c.getId()+" Collided_With Repair Car "+rc.getID()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
			bw.newLine();
		} catch(IOException e){
			
		}
	}
	
	public static void writeCollisionCar(Car c,ICar c2){
		try{
			bw.append("Car "+c.getId()+" Collided_With Car "+c2.getID()+" At "+c.getPosition().getX()+" "+c.getPosition().getY());
			bw.newLine();
		} catch(IOException e){
			
		}
	}
	
	
	public static void writeCleanOil(RepairCar c, Oil o){
		
	}
	
	public static void writeCleanGlue(RepairCar c, Glue g){
		
	}
	
	public static void writeRepairCarBecomesOil(RepairCar rc){
		
	}
	
	public static void summarize(Game g){
		try{
			bw.append("Game : "+g.getTrack().getHeight()+" "+g.getTrack().getLength());
			bw.newLine();
			for(int i=0;i<g.nbCar;i++){
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
			}
			Track t=g.getTrack();
			for(int i=0;i<t.getHeight();i++){
				for(int j=0;i<t.getLength();j++){
					Segment s = t.getSegment(i,j);
					if(s.hasObstacle()) {
						for (int k=0;i<s.SObs.size();k++){
							AbstractObstacle o = s.SObs.get(k);
							bw.append(o.type()+" "+o.getId()+" Position : "+s.getX()+" "+s.getY()+" Effect_Left "+o.effectLeft());
							bw.newLine();
						}		
					}
				}		
			}
		} catch(IOException e){
			
		}
	}
	
}
