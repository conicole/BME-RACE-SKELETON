import java.util.*;
  
public class Segment implements ISegment {
  
  
  public Stack<AbstractObstacle> SObs;
  
  
  // prevent all the object on the segment that
  // a car is coming | manage collision
  public void CarIsComing(ICar c)
  {
    Stack<AbstractObstacle> STmp;
    STmp = SObs;
    while ( !(STmp.empty()) )
    {
      STmp.pop().ObstacleHitted(c);
    }
  }
  
}
