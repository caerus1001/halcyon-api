package com.spire.halcyon.service;

import com.spire.halcyon.model.Game;
import com.spire.halcyon.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public List<Game> getGames(List<String> genres) {
        return gameRepository.findByGenresIn(genres);
    }

    public void createGame(Game game) {
        gameRepository.save(game);
    }
}
