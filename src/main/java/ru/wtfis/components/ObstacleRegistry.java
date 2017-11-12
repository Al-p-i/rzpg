package ru.wtfis.components;

import ru.wtfis.model.Position;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by a.pomosov on 12/11/2017.
 */
public class ObstacleRegistry {
    private static ObstacleRegistry instance = new ObstacleRegistry();

    public static ObstacleRegistry getInstance() {
        return instance;
    }

    private Map<Position, ObstacleComponent> obstaclesRegistry = new HashMap<>();

    public void register(ObstacleComponent obstacleComponent) {
        obstaclesRegistry.put(obstacleComponent.getPosition(), obstacleComponent);
    }

    public Map<Position, ObstacleComponent> getRegistry() {
        return new HashMap<>(obstaclesRegistry);
    }
}
