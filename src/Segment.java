import java.util.*;
  
public class Segment implements ISegment {
    public int Id;
  


  public Stack<AbstractObstacle> SObs;


    public Segment(int id){
        Id = id;
    }

    public int getId(){
        return Id;
    }


    public void remove(AbstractObstacle obj){
//todO
    }
  
  public void addObstacle(AbstractObstacle o){
	  System.out.println("Segment : add an obstacle on the segment");
  }
  
  // prevent all the object on the segment that
  // a car is coming | manage collision
  public void CarIsComing(ICar c)
  {
	  System.out.println("Segment : A car is coming on the Segment");
	  System.out.println("Segment : Do I have some obstacle on me ?");
	  boolean notAnswered = true;

      while(notAnswered) {
          System.out.println("Please choose an option");
          System.out.println("(1) No");
          System.out.println("(2) Oil");
          System.out.println("(3) Car");
          System.out.println("(4) Glue");
          System.out.println("(5) Obstacle");
          Scanner reader = new Scanner(System.in);
          String input = reader.nextLine();
          switch (input) {
              case "1":
            	  System.out.println("Segment : car hit nothing");
                  notAnswered = false;
                  break;
              case "2":
            	  System.out.println("Segment :car hit oil");
            	  Oil oil = new Oil();
            	  oil.ObstacleHitted(c);
                  notAnswered = false;
                  return;
              case "3":
            	  System.out.println("Segment : car hit a car");
                  Car car = new Car();
            	  car.ObstacleHitted(c);
                  notAnswered = false;
                  return;
              case "4":
            	  System.out.println("Segment : hit Glue");
            	  Glue glue = new Glue();
            	  glue.ObstacleHitted(c);
                  notAnswered = false;
                  return;
              case "5":
            	  System.out.println("Segment : hit Obstacle");
            	  Obstacle o=new Obstacle(1);
            	  o.ObstacleHitted(c);
                  notAnswered = false;
                  return;
              default:
                  System.out.println("Please enter correct option");
                  break;
          }

          this.addObstacle(c);
          
      }

  }
  
}
