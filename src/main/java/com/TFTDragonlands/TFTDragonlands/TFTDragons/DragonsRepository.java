package com.TFTDragonlands.TFTDragonlands.TFTDragons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DragonsRepository extends JpaRepository<Dragons, String> {
}
