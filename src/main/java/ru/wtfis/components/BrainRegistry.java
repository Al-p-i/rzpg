package ru.wtfis.components;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author apomosov
 * @since 12.11.17
 */
public class BrainRegistry {
    private static BrainRegistry instance = new BrainRegistry();

    public static BrainRegistry getInstance() {
        return instance;
    }

    private Set<BrainComponent> brainComponents = new LinkedHashSet<>();

    public void register(BrainComponent brainComponent) {
        brainComponents.add(brainComponent);
    }

    public Set<BrainComponent> getBrainComponents() {
        return brainComponents;
    }
}
