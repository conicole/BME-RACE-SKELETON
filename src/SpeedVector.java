
public class SpeedVector {

  public int dg;
  public int r;


	public void decrease(int i){
	  r+=i;
	}
  
  public void increase(int i){
   r-=i;
  }
  
  public void goLeft() {
    dg++;
  }

  public void goRight() {
    dg--;
  }

}