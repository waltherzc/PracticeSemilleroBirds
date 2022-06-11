package com.ias.practice.aves.application.services;

import com.ias.practice.aves.application.domain.Bird;
import com.ias.practice.aves.application.domain.valueObjs.IdBird;
import com.ias.practice.aves.application.ports.input.DeleteBirdUseCase;
import com.ias.practice.aves.application.ports.output.BirdRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteBirdService implements DeleteBirdUseCase {

    private final BirdRepository birdRepository;

    public DeleteBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public Boolean execute(Long id) {

        IdBird idBird = new IdBird(id);
        Optional<Bird> birdDB = birdRepository.get(idBird);

        if (birdDB.isPresent()) {
            birdRepository.delete(idBird);
        }

        return birdDB.isPresent();
    }
}
