package ru.wtfis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.wtfis.components.*;
import ru.wtfis.core.Ticker;
import ru.wtfis.model.Avatar;

@SpringBootApplication
public class RZPGApplication {
    @Autowired
    private Ticker ticker;

    public static void main(String[] args) {
        SpringApplication.run(RZPGApplication.class, args);
    }

    @Bean
    public Avatar avatar(){
        Avatar avatar = new Avatar();
        avatar.addComponent(new RandomBrainComponent())
                .addComponent(new PositionComponent())
                .addComponent(new MoveComponent())
                .addComponent(new ObstacleComponent());

        ticker.loop();
        return avatar;
    }
}
