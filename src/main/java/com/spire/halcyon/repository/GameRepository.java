package com.spire.halcyon.repository;

import com.spire.halcyon.model.Game;
import com.spire.halcyon.model.Platform;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    List<Game> findByPlatformsIn(List<Platform> platforms);
    List<Game> findByPlatforms_name(String name);
}
