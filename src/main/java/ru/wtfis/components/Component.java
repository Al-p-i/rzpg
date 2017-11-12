package ru.wtfis.components;

import ru.wtfis.core.GameObject;

/**
 * Created by a.pomosov on 12/11/2017.
 */
public abstract class Component {
    private GameObject gameObject;
    public GameObject getGameObject() {
        return gameObject;
    }

    <T extends Component> T require(Class<T> require) {
        T required = getGameObject().getComponent(require);
        if (required == null) {
            throw new RuntimeException(require + " component is required for " + this.getClass());
        }
        return required;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }
}
