package com.spire.halcyon.service;

import com.spire.halcyon.client.GiantBombClient;
import com.spire.halcyon.model.Game;
import com.spire.halcyon.repository.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.Assert.assertNotNull;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {
    @Mock
    private GameRepository gameRepository;
    @Mock
    private GiantBombClient giantBombClient;
    @InjectMocks
    private GameService gameService;

    @Test
    public void CreateGame_ValidGameProvided_GameShouldBeNonNull() {
        Game game = new Game();
        when(gameRepository.save(any(Game.class))).thenReturn(game);
        Game createdGame = gameService.createGame(game);
        assertNotNull(createdGame);
    }
}
