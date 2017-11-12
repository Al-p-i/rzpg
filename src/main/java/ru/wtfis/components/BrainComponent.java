package ru.wtfis.components;

/**
 * Created by a.pomosov on 12/11/2017.
 */
public abstract class BrainComponent extends Component {

    public abstract Action getAction();

    public enum Action {
        IDLE, MOVE_UP, MOVE_DOWN, MOVE_RIGHT, MOVE_LEFT
    }
}
