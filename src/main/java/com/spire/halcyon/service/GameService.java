package com.spire.halcyon.service;

import com.spire.halcyon.client.Filters;
import com.spire.halcyon.client.GiantBombClient;
import com.spire.halcyon.model.Game;
import com.spire.halcyon.model.Platform;
import com.spire.halcyon.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {
    private GameRepository gameRepository;
    private GiantBombClient giantBombClient;

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

    public List<Game> getGamesByPlatform(String platformName) throws Exception {
        Platform platform = giantBombClient.getPlatformByName(platformName);
        return giantBombClient.getGamesByPlatform(platform.getId());
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }
}
