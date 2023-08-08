// Factory Method Pattern
interface Obstacle {
    void avoid();
}

class Tree implements Obstacle {
    @Override
    public void avoid() {
        System.out.println("Avoid the tree!");
    }
}

class Rock implements Obstacle {
    @Override
    public void avoid() {
        System.out.println("Jump over the rock!");
    }
}

class ObstacleFactory {
    public static Obstacle createObstacle(String type) {
        if (type.equalsIgnoreCase("tree")) {
            return new Tree();
        } else if (type.equalsIgnoreCase("rock")) {
            return new Rock();
        }
        return null;
    }
}

// Client code for Factory Method
public class FactoryMethodExample {
    public static void main(String[] args) {
        Obstacle obstacle1 = ObstacleFactory.createObstacle("tree");
        obstacle1.avoid();

        Obstacle obstacle2 = ObstacleFactory.createObstacle("rock");
        obstacle2.avoid();
    }
}
