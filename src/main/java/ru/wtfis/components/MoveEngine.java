package ru.wtfis.components;

import org.springframework.beans.factory.annotation.Autowired;
import ru.wtfis.model.Position;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by a.pomosov on 12/11/2017.
 */
@org.springframework.stereotype.Component
public class MoveEngine {
    private ObstacleRegistry obstacleRegistry = ObstacleRegistry.getInstance();
    private MoveRegistry moveRegistry = MoveRegistry.getInstance();

    public void moveAll() {
        Iterator<Map.Entry<MoveComponent, MoveComponent.Direction>> registry = moveRegistry.getRegistry();
        while (registry.hasNext()) {
            Map.Entry<MoveComponent, MoveComponent.Direction> movement = registry.next();
            registry.remove();
            Position newPosition = moveWithCollisions(movement.getValue(), movement.getKey().getPosition(), movement.getKey().getMaxSpeed());
            movement.getKey().setPosition(newPosition);
            System.out.println(newPosition);
        }
    }

    private boolean hasCollision(Position newPossiblePosition, Map<Position, ObstacleComponent> obstacles) {
        return obstacles.containsKey(newPossiblePosition);
    }

    private Position moveWithCollisions(MoveComponent.Direction direction, Position startPosition, int speed) {
        Map<Position, ObstacleComponent> obstacles = obstacleRegistry.getRegistry();
        Position newPossiblePosition;
        switch (direction) {
            case UP:
                newPossiblePosition = new Position(startPosition.getX(), startPosition.getY() + speed);
                break;
            case DOWN:
                newPossiblePosition = new Position(startPosition.getX(), startPosition.getY() - speed);
                break;
            case RIGHT:
                newPossiblePosition = new Position(startPosition.getX() + speed, startPosition.getY());
                break;
            case LEFT:
                newPossiblePosition = new Position(startPosition.getX() - speed, startPosition.getY());
                break;
            default:
                newPossiblePosition = startPosition;
        }
        if(hasCollision(newPossiblePosition, obstacles)){
            return startPosition;
        } else {
            return newPossiblePosition;
        }
    }
}
