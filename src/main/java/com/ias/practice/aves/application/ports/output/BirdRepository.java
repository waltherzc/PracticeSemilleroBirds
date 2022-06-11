package com.ias.practice.aves.application.ports.output;

import com.ias.practice.aves.application.domain.Bird;
import com.ias.practice.aves.application.domain.valueObjs.IdBird;

import java.util.Optional;

public interface BirdRepository {
    void store(Bird bird);

    Optional<Bird> get(IdBird idBird);

    void update(Bird bird);

    Boolean delete(IdBird idBird);
}
