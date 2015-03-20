public class Obstacle extends AbstractObstacle{

	public Obstacle(){
		System.out.println("Obstacle : Creation of an Obstacle\n");
	}

    void ObstacleHitted(ICar c) {
    	    System.out.println("ObstacleHitted : Obstacle\n");
    	    c.hitObstacle();
    }
    
    
}
