package com.TFTDragonlands.TFTDragonlands.TFTDragons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/dragons")
public class DragonController {

    private final DragonService dragonsService;

    @Autowired
    public DragonController(DragonService dragonsService) {
        this.dragonsService = dragonsService;
    }

    @GetMapping
    public List<Dragon> getDragons() {

        return dragonsService.getDragons();
    }

    @PostMapping
    public void registerNewDragon(@RequestBody Dragon newDragon){
        dragonsService.addNewDragon(newDragon);
    }

    @DeleteMapping(path="{dragonId}")
    public void deleteDragon(@PathVariable("dragonId") Long dragonId) {
        dragonsService.deleteAnExistingDragon(dragonId);
    }

    @PutMapping(path="{dragonId}")
    public void updateDragonDetails(@PathVariable("dragonId") Long dragonId,
                                    @RequestParam(required = false) String updatingName,
                                    @RequestParam(required = false) String updatingTrait) {
        dragonsService.updateAnExistingDragon(dragonId, updatingName, updatingTrait);
    }

}
