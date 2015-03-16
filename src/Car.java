
public class Car implements ICar {
  private SpeedVector Sv;

@Override
public void accelerate() {
    // TODO Auto-generated method stub
    
}

@Override
public void breake() {
    // TODO Auto-generated method stub
    
}

@Override
public void goLeft() {
    // TODO Auto-generated method stub
    
}

@Override
public void goRight() {
    // TODO Auto-generated method stub
    
}
  
  
  public void glueHitted()
  {
  		Sv.decrease(2);
  }

@Override
public void carHitted() {
      Sv.decrease(3);
    
}

@Override
public void obstacleHitted() {
	
}

@Override
public void oilHitted() {
   Sv.increase(2);
}
  
}



