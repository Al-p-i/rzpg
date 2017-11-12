package ru.wtfis.components;

import org.springframework.beans.factory.annotation.Autowired;
import ru.wtfis.model.Position;

/**
 * Created by a.pomosov on 12/11/2017.
 */
public class MoveComponent extends Component {
    private int maxSpeed;
    private int priority;
    @Autowired
    private MoveRegistry moveRegistry;

    public MoveComponent() {
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Position getPosition() {
        return require(PositionComponent.class).getPosition();
    }

    public void setPosition(Position position) {
        require(PositionComponent.class).setPosition(position);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getPriority() {
        return priority;
    }

    public enum Direction {
        UP, RIGHT, DOWN, LEFT
    }
}
