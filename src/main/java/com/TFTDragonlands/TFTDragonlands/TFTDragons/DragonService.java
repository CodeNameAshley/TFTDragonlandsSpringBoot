package com.TFTDragonlands.TFTDragonlands.TFTDragons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DragonService {
    private final DragonsRepository dragonsRepository;

    @Autowired
    public DragonService(DragonsRepository dragonsRepository) {

        this.dragonsRepository = dragonsRepository;
    }

    public List<Dragon> getDragons() {
            return dragonsRepository.findAll();
    }

    public void addNewDragon(Dragon dragon) {
        Optional<Dragon> dragonByName = dragonsRepository
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
        Dragon existingDragon = dragonsRepository.findById(dragonId)
                .orElseThrow(() -> new IllegalStateException(
                "Dragon with " + dragonId + " does not exist"
        ));

        if(updatedDragonName != null &&
                !updatedDragonName.isEmpty() &&
                !existingDragon.getName().equals(updatedDragonName)) {
            Optional<Dragon> getExistingDragonsByName = dragonsRepository.findDragonsByName(updatedDragonName);
            if(getExistingDragonsByName.isPresent()){
                throw new IllegalStateException("A Dragon with the name " + updatedDragonName + " already exists!");
            }
            existingDragon.setName(updatedDragonName);
        }

        if(updatedDragonTrait != null &&
                !updatedDragonTrait.isEmpty() &&
                !existingDragon.getTrait().equals(updatedDragonTrait)) {
            existingDragon.setTrait(updatedDragonTrait);
        }
    }
}
