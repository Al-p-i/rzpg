package ru.wtfis.components;

import org.springframework.stereotype.*;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by a.pomosov on 12/11/2017.
 */
public class MoveRegistry {
    private static MoveRegistry instance = new MoveRegistry();

    public static MoveRegistry getInstance() {
        return instance;
    }

    private final TreeMap<MoveComponent, MoveComponent.Direction> registry = new TreeMap<>((a, b) -> {
        if (a.getPriority() > b.getPriority()) {
            return 1;
        } else if (a.getPriority() < b.getPriority()) {
            return -1;
        }
        return 0;
    });

    public void register(MoveComponent moveComponent, MoveComponent.Direction direction) {
        registry.put(moveComponent, direction);
    }

    public Iterator<Map.Entry<MoveComponent, MoveComponent.Direction>> getRegistry() {
        return registry.entrySet().iterator();
    }
}
