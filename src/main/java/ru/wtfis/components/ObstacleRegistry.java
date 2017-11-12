package ru.wtfis.components;

import org.springframework.stereotype.Repository;
import ru.wtfis.model.Position;

import java.util.*;

/**
 * Created by a.pomosov on 12/11/2017.
 */
@Repository
public class ObstacleRegistry {
    private Map<Position, ObstacleComponent> obstaclesRegistry = new HashMap<>();

    public void register(ObstacleComponent obstacleComponent) {
        obstaclesRegistry.put(obstacleComponent.getPosition(), obstacleComponent);
    }

    public Map<Position, ObstacleComponent> getRegistry() {
        return new HashMap<>(obstaclesRegistry);
    }
}
