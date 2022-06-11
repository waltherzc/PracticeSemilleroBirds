package com.ias.practice.aves.application.services;

import com.ias.practice.aves.application.domain.Bird;
import com.ias.practice.aves.application.ports.input.UpdateBirdUseCase;
import com.ias.practice.aves.application.ports.output.BirdRepository;
import com.ias.practice.aves.infrastructure.models.BirdDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateBirdService implements UpdateBirdUseCase {

    private final BirdRepository birdRepository;

    public UpdateBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public BirdDTO execute(BirdDTO birdDTO) {

        Bird bird = BirdDTO.toDomain();

        Optional<Bird> birdBD = birdRepository.get(bird.getIdBird());

        if(birdBD.isPresent()) {
            birdRepository.update(bird);
            BirdDTO.setStatus("Updated");
        } else {
            BirdDTO.setStatus("No Updated");
        }
        return birdDTO;
    }

}
