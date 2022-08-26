package com.TFTDragonlands.TFTDragonlands.TFTDragons;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class DragonsRepositoryTest {

    @Autowired
    private DragonsRepository testDragonsRepository;

    @Test
    void doesDragonExistByName() {
        //given
        Dragon sohm = new Dragon(
                123451234L,
                "Sohm",
                "Lagoon",
                7,
                800,
                40
        );
        testDragonsRepository.save(sohm);

        //when
        Optional<Dragon> expectedDragon = testDragonsRepository.findDragonsByName("Sohm");

        //then
        assertThat(expectedDragon).isPresent();
    }
}
