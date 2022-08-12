package com.TFTDragonlands.TFTDragonlands.TFTDragons;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DragonsConfig {

    @Bean
    CommandLineRunner commandLineRunner(DragonsRepository repository) {
        return args -> {
            Dragons aoshin = new Dragons("Ao Shin", "Tempest", 10, 900, 200 );
            Dragons aurelionsol = new Dragons("Aurelion Sol", "Astral", 10, 900, 90 );
//            Dragons daeja = new Dragons("Daeja", "Mirage", 8, 850, 100 );
//            Dragons idas = new Dragons("Idas", "Shimmerscale", 8, 1100, 160 );
//            Dragons shiohyu = new Dragons("Shi Oh Yu", "Jade", 8, 900, 90 );
//            Dragons shyvana = new Dragons("Shyvana", "Ragewing", 10, 1200, 60 );
//            Dragons syfen = new Dragons("Sy'fen", "Whispers", 8, 1100, 175 );

            repository.saveAll(List.of(aoshin, aurelionsol));
        };
    }
}
