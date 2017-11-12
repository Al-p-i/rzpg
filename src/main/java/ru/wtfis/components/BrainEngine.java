package ru.wtfis.components;

/**
 * @author apomosov
 * @since 12.11.17
 */
@org.springframework.stereotype.Component
public class BrainEngine {
    private BrainRegistry brainRegistry = BrainRegistry.getInstance();

    public void tickAll(){
        for (BrainComponent brainComponent : brainRegistry.getBrainComponents()) {
            brainComponent.act();
        }
    }
}
