package com.TFTDragonlands.TFTDragonlands.TFTDragons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DragonsRepository
        extends JpaRepository<Dragon, Long> {

    @Query("" +
            "SELECT CASE WHEN COUNT(d) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Dragon d " +
            "WHERE d.name = ?1"
    )

    Optional<Dragon> findDragonsByName(String name);

}
