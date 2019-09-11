package com.spire.halcyon.service;

import com.mongodb.client.AggregateIterable;
import com.spire.halcyon.client.Filters;
import com.spire.halcyon.client.GiantBombClient;
import com.spire.halcyon.model.Game;
import com.spire.halcyon.model.Genre;
import com.spire.halcyon.model.Platform;
import com.spire.halcyon.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {
    private GameRepository gameRepository;
    private GiantBombClient giantBombClient;

    @Autowired
    public GameService(GameRepository gameRepository, GiantBombClient giantBombClient) {
        this.gameRepository = gameRepository;
        this.giantBombClient = giantBombClient;
    }

    public List<Game> getGamesByCurrentDate() throws Exception {
        List<Game> customGames = gameRepository.findAll();

        Calendar calendar = Calendar.getInstance();
        String currentYear = String.valueOf(calendar.get(Calendar.YEAR));
        String currentMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String currentDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        Map<Filters, String> filters = new HashMap<>();
        filters.put(Filters.EXPECTED_RELEASE_YEAR, currentYear);
        filters.put(Filters.EXPECTED_RELEASE_MONTH, currentMonth);
        filters.put(Filters.EXPECTED_RELEASE_DAY, currentDay);

        List<Game> originalGames = giantBombClient.getGames(filters);

        List<Game> allGames = new ArrayList<>();
        allGames.addAll(customGames);
        allGames.addAll(originalGames);

        return allGames;
    }

    public Game getGame(String id) throws Exception {
        return giantBombClient.getGame(id);
    }

    public List<Game> getGamesByPlatforms(List<Platform> platforms) throws Exception {
        List<Game> customGames = gameRepository.findByPlatformsIn(platforms);

        List<Game> gamesByPlatform = giantBombClient.getGamesByPlatforms(platforms);
        return null;
    }

    public List<Game> getGamesByPlatform(String platformName) throws Exception {
        List<Game> customGames = gameRepository.findByPlatforms_name(platformName);

        Platform platform = giantBombClient.getPlatformByName(platformName);
        List<Game> gamesByPlatformFromClient = giantBombClient.getGamesByPlatform(platform.getId());

        List<Game> allGames = new ArrayList<>();
        allGames.addAll(customGames);
        allGames.addAll(gamesByPlatformFromClient);

        return allGames;
    }

    public void createGame(Game game) {
        gameRepository.save(game);
    }
}
