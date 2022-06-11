package com.ias.practice.aves.application.services;

import com.ias.practice.aves.application.domain.Bird;
import com.ias.practice.aves.application.domain.valueObjs.IdBird;
import com.ias.practice.aves.application.ports.input.GetByIdBirdUseCase;
import com.ias.practice.aves.application.ports.output.BirdRepository;
import com.ias.practice.aves.infrastructure.models.BirdDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetBirdService implements GetByIdBirdUseCase {

    private final BirdRepository birdRepository;

    public GetBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }


    @Override
    public Optional<BirdDTO> execute(Long id) {
        IdBird idBird = new IdBird(id);

        Optional<Bird> birdOptional = birdRepository.get(idBird);

        return birdOptional.map(bird -> {
            BirdDTO birdDTO = BirdDTO.fromDomain(bird);
            return birdDTO;
        });
    }
}
