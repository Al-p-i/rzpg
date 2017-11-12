package ru.wtfis.components;

import ru.wtfis.model.Position;

/**
 * Created by a.pomosov on 12/11/2017.
 */
public class ObstacleComponent extends Component {
    public ObstacleComponent(){
    }

    public Position getPosition() {
        return require(PositionComponent.class).getPosition();
    }
}
