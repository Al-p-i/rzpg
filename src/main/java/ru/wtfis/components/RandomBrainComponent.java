package ru.wtfis.components;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * Created by a.pomosov on 12/11/2017.
 */
public class RandomBrainComponent extends BrainComponent {
    private final Random random = new Random();
    private MoveRegistry moveRegistry = MoveRegistry.getInstance();
    private BrainRegistry brainRegistry = BrainRegistry.getInstance();

    public RandomBrainComponent() {
        brainRegistry.register(this);
    }

    @Override
    public void act() {
        Action action = Action.values()[random.nextInt(Action.values().length)];
        switch (action) {
            case MOVE_UP:
                moveRegistry.register(require(MoveComponent.class), MoveComponent.Direction.UP);
                return;
            case MOVE_DOWN:
                moveRegistry.register(require(MoveComponent.class), MoveComponent.Direction.DOWN);
                return;
            case MOVE_RIGHT:
                moveRegistry.register(require(MoveComponent.class), MoveComponent.Direction.RIGHT);
                return;
            case MOVE_LEFT:
                moveRegistry.register(require(MoveComponent.class), MoveComponent.Direction.LEFT);
                return;
        }
    }
}
