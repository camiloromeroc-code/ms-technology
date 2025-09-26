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
                        return Mono.error(new IllegalArgumentException("La tecnología ya existe"));
                    }
                    return repository.save(technology);
                });
    }

    public Flux<Technology> listTechnologies() {
        return repository.findAll();
    }

    public Mono<Technology> getTechnologyById(Long id) {
        return repository.findById(id);
    }


    public Mono<Technology> updateTechnology(Long id, Technology technology) {
        return repository.findById(id)
                .flatMap(existing -> {
                    Technology updated = new Technology(
                            id,
                            technology.name(),
                            technology.description()
                    );
                    return repository.save(updated);
                });
    }

    public Mono<Boolean> deleteTechnology(Long id) {
        return repository.findById(id)
                .flatMap(existing -> repository.deleteById(id).thenReturn(true))
                .defaultIfEmpty(false);
    }
}
