package com.TFTDragonlands.TFTDragonlands.TFTDragons;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DragonsService {

        public List<Dragons> getDragons() {
            return List.of(new Dragons("Ao Shin", "Tempest", 10, 2460, 180 )
            );
        }

}
