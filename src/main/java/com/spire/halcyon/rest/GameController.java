package com.spire.halcyon.rest;

import com.spire.halcyon.model.Game;
import com.spire.halcyon.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    public GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/gamesByCurrentDate")
    public List<Game> getGames() throws Exception{
        return gameService.getGamesByCurrentDate();
    }

    @GetMapping("games/platforms/{name}")
    public List<Game> getGamesByPlatform(@PathVariable String name) throws Exception {
        return gameService.getGamesByPlatform(name);
    }

    @GetMapping("/games/genres")
    public List<Game> getGames(@RequestBody List<String> genres) {
        //return gameService.getGames(genres);
        return null;
    }

    @PostMapping("/games")
    public Game createGame(@RequestBody Game game) {
        return gameService.createGame(game);
    }

    @GetMapping("/game/{id}")
    public Game getGame(@PathVariable String id) throws Exception {
        return gameService.getGame(id);
    }
}
