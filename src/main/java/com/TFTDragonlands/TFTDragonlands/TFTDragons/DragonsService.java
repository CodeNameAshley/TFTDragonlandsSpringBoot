package com.TFTDragonlands.TFTDragonlands.TFTDragons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DragonsService {
    private final DragonsRepository dragonsRepository;

    @Autowired
    public DragonsService(DragonsRepository dragonsRepository) {

        this.dragonsRepository = dragonsRepository;
    }

    public List<Dragons> getDragons() {
            return dragonsRepository.findAll();
    }

    public void addNewDragon(Dragons dragon) {
        Optional<Dragons> dragonByName = dragonsRepository
                .findDragonsByName(dragon.getName());
        if(dragonByName.isPresent()) {
            throw new IllegalStateException("This Dragon Already Exists");
        }
        dragonsRepository.save(dragon);
    }

    public void deleteDragon(Long dragonId) {
        boolean doesDragonIdExist = dragonsRepository.existsById(dragonId);
        if (!doesDragonIdExist) {
            throw new IllegalStateException("Dragon with " + dragonId + " does not exist!");
        }
        dragonsRepository.deleteById(dragonId);
    }
}
