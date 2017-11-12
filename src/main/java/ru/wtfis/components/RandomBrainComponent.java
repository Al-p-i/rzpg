package ru.wtfis.components;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * Created by a.pomosov on 12/11/2017.
 */
public class RandomBrainComponent extends BrainComponent {
    private final Random random = new Random();
    @Autowired
    private MoveRegistry moveRegistry;

    @Override
    public Action getAction() {
        Action action = Action.values()[random.nextInt(Action.values().length)];
        switch (action) {
            case MOVE_UP:
                moveRegistry.register(require(MoveComponent.class), MoveComponent.Direction.UP);
                return action;
            case MOVE_DOWN:
                moveRegistry.register(require(MoveComponent.class), MoveComponent.Direction.DOWN);
                return action;
            case MOVE_RIGHT:
                moveRegistry.register(require(MoveComponent.class), MoveComponent.Direction.RIGHT);
                return action;
            case MOVE_LEFT:
                moveRegistry.register(require(MoveComponent.class), MoveComponent.Direction.LEFT);
                return action;
        }
        return action;
    }
}
