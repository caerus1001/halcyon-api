package com.spire.halcyon.rest;

import com.spire.halcyon.model.Game;
import com.spire.halcyon.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {
    public GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<Game> getGames() {
        return gameService.getGames();
    }

    @GetMapping("/games/genres")
    public List<Game> getGames(@RequestBody List<String> genres) {
        return gameService.getGames(genres);
    }

    @PostMapping("/games")
    public void createGame(@RequestBody Game game) {
        gameService.createGame(game);
    }
}
