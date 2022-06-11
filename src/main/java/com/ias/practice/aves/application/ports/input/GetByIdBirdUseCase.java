package com.ias.practice.aves.application.ports.input;

import com.ias.practice.aves.commons.UseCase;
import com.ias.practice.aves.infrastructure.models.BirdDTO;

import java.util.Optional;

public interface GetByIdBirdUseCase extends UseCase<Long, Optional<BirdDTO>> {
}
