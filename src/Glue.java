


public class Glue extends AbstractObstacle{

    @Override
    void ObstacleHitted(ICar c)
    {
        c.glueHitted();
    }
}
