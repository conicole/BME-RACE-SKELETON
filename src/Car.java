
public class Car implements ICar {
  private SpeedVector Sv;

public void accelerate() {
    // TODO Auto-generated method stub
    
}

public void breake() {
    // TODO Auto-generated method stub
    
}


public void goLeft() {
    // TODO Auto-generated method stub
    
}

public void goRight() {
    // TODO Auto-generated method stub
    
}
  
  
  public void glueHitted()
  {
  		Sv.decrease(2);
  }


public void carHitted() {
      Sv.decrease(3);
    
}


public void obstacleHitted() {
	
}


public void oilHitted() {
   Sv.increase(2);
}
  
}



