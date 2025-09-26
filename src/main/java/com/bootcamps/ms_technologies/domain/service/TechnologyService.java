package com.bootcamps.ms_technologies.domain.service;

import com.bootcamps.ms_technologies.domain.model.Technology;
import com.bootcamps.ms_technologies.domain.port.out.TechnologyRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TechnologyService {
    private final TechnologyRepositoryPort repository;

    public Mono<Technology> createTechnology(Technology technology) {
        return repository.existsByName(technology.name())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new IllegalArgumentException("Ya existe"));
                    }
                    return repository.save(technology);
                });
    }

    public Flux<Technology> listTechnologies() {
        return repository.findAll();
    }
}
