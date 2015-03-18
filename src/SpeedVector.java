
public class SpeedVector {

  public int dg;
  public int r;
  public final static int R_MAX = 10;
  public final static int R_MIN =0;


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