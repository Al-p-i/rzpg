package ru.wtfis.core;

import ru.wtfis.components.Component;

import java.util.LinkedHashMap;

/**
 * Created by a.pomosov on 12/11/2017.
 */
public abstract class GameObject {
    private LinkedHashMap<Class<? extends Component>, Component> components = new LinkedHashMap<>();

    public GameObject addComponent(Component component){
        components.put(component.getClass(), component);
        component.setGameObject(this);
        return this;
    }

    public <T extends Component> T getComponent(Class<T> componentType) {
        return (T) components.get(componentType);
    }
}
