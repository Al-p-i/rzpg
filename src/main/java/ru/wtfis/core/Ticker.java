package ru.wtfis.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.wtfis.components.BrainEngine;
import ru.wtfis.components.MoveEngine;

/**
 * Created by a.pomosov on 12/11/2017.
 */
@Component
public class Ticker {
    @Autowired
    private MoveEngine moveEngine;
    @Autowired
    private BrainEngine brainEngine;
    private volatile long tact = 0;

    public void loop() {
        while (true) {
            System.out.println("tact [" + tact + "]");
            brainEngine.tickAll();
            moveEngine.moveAll();
            tact++;
        }
    }
}
