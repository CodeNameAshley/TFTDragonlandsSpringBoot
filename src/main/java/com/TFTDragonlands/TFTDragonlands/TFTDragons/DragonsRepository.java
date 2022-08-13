package com.TFTDragonlands.TFTDragonlands.TFTDragons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DragonsRepository
        extends JpaRepository<Dragons, Long> {

    @Query("SELECT d FROM Dragons d WHERE d.trait = ?1")
    Optional<Dragons> findDragonsByName(String trait);
}
