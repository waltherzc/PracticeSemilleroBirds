package com.ias.practice.aves.application.services;

import com.ias.practice.aves.application.domain.Bird;
import com.ias.practice.aves.application.domain.valueObjs.*;
import com.ias.practice.aves.application.ports.input.CreateBirdUseCase;
import com.ias.practice.aves.application.ports.output.BirdRepository;
import com.ias.practice.aves.infrastructure.models.BirdDTO;
import org.springframework.stereotype.Service;

@Service
public class CreateBirdService implements CreateBirdUseCase {

    private final BirdRepository birdRepository;

    public CreateBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public BirdDTO execute(BirdDTO birdDTO) {
        //valid Aut
        //Valid Priv
        //Ops

        Bird bird = new Bird(null,
                new CommonNameBird(birdDTO.getCommonN()),
                new ScientificNameBird(birdDTO.getScientificN()),
                new ZoneNameBird(birdDTO.getZone()),
                new ConfirmedQuantityBird(birdDTO.getQuantity()));
        birdRepository.store(bird);

        return birdDTO;
    }
}
