package com.jaoropeza.albo.library.repository;

import com.jaoropeza.albo.library.domain.Colaborators;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColaboratorsRepository extends MongoRepository<Colaborators, String> {
}
