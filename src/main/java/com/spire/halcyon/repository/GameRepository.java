package com.spire.halcyon.repository;

import com.spire.halcyon.model.Game;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    public List<Game> findByGenresIn(List<String> genres);
}
