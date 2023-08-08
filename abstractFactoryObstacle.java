// Abstract Factory Pattern
interface ObstacleFactoryAbstract {
    Obstacle createObstacle();
}

class TreeFactory implements ObstacleFactoryAbstract {
    @Override
    public Obstacle createObstacle() {
        return new Tree();
    }
}

class RockFactory implements ObstacleFactoryAbstract {
    @Override
    public Obstacle createObstacle() {
        return new Rock();
    }
}

// Client code for Abstract Factory
public class AbstractFactoryExample {
    public static void main(String[] args) {
        ObstacleFactoryAbstract treeFactory = new TreeFactory();
        Obstacle obstacle1 = treeFactory.createObstacle();
        obstacle1.avoid();

        ObstacleFactoryAbstract rockFactory = new RockFactory();
        Obstacle obstacle2 = rockFactory.createObstacle();
        obstacle2.avoid();
    }
}
