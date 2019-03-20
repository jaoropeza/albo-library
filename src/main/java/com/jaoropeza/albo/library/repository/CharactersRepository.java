package com.jaoropeza.albo.library.repository;

import com.jaoropeza.albo.library.domain.Characters;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharactersRepository extends MongoRepository<Characters, String> {
}
