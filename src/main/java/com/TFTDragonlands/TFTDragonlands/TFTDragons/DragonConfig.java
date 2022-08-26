package com.TFTDragonlands.TFTDragonlands.TFTDragons;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DragonConfig {

    @Bean
    CommandLineRunner commandLineRunner(DragonsRepository repository) {
        return args -> {
            Dragon aoshin = new Dragon("Ao Shin", "Tempest", 10, 900, 200 );
            Dragon aurelionsol = new Dragon("Aurelion Sol", "Astral", 10, 900, 90 );
//            Dragon daeja = new Dragon("Daeja", "Mirage", 8, 850, 100 );
//            Dragon idas = new Dragon("Idas", "Shimmerscale", 8, 1100, 160 );
//            Dragon shiohyu = new Dragon("Shi Oh Yu", "Jade", 8, 900, 90 );
//            Dragon shyvana = new Dragon("Shyvana", "Ragewing", 10, 1200, 60 );
//            Dragon syfen = new Dragon("Sy'fen", "Whispers", 8, 1100, 175 );

            repository.saveAll(List.of(aoshin, aurelionsol));
        };
    }
}
