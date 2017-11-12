package ru.wtfis.components;

import ru.wtfis.model.Position;

/**
 * Created by a.pomosov on 12/11/2017.
 */
public class PositionComponent extends Component {
    private Position position;

    public PositionComponent() {
        this.position = new Position(0, 0);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
