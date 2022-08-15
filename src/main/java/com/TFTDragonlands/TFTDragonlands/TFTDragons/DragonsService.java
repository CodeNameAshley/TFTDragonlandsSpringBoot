package com.TFTDragonlands.TFTDragonlands.TFTDragons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    public void deleteAnExistingDragon(Long dragonId) {
        boolean doesDragonExist = dragonsRepository.existsById(dragonId);
        if (!doesDragonExist) {
            throw new IllegalStateException("Dragon with " + dragonId + " does not exist!");
        }
        dragonsRepository.deleteById(dragonId);
    }

    @Transactional
    public void updateAnExistingDragon(Long dragonId, String updatedDragonName, String updatedDragonTrait) {
        Dragons existingDragon = dragonsRepository.findById(dragonId).orElseThrow(() -> new IllegalStateException(
                "Dragon with " + dragonId + " does not exist"
        ));

        if(updatedDragonName != null && !updatedDragonName.isEmpty() && !existingDragon.getName().equals(updatedDragonName)) {
            Optional<Dragons> getExistingDragonsByName = dragonsRepository.findDragonsByName(updatedDragonName);
            if(getExistingDragonsByName.isPresent()){
                throw new IllegalStateException("A Dragon with the name " + updatedDragonName + " already exists!");
            }
            existingDragon.setName(updatedDragonName);
        }

        if(updatedDragonTrait != null && !updatedDragonTrait.isEmpty() && !existingDragon.getTrait().equals(updatedDragonTrait)) {
            existingDragon.setTrait(updatedDragonTrait);
        }
    }
}
