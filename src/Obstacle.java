public class Obstacle implements AbstractObstacle{

	public Obstacle(){
		//Create an obstacle
		System.out.println("Obstacle : Creation of an Obstacle");
	}
    public Obstacle(int i){}

    public void ObstacleHitted(ICar c) {
    	//outputs the type of interface hit
    	
    	    System.out.println("ObstacleHitted : Obstacle");
    	    c.hitObstacle();
    }
    
    
}
