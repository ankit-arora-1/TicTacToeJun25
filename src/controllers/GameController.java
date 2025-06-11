package controllers;

import exceptions.BotCountException;
import exceptions.PlayerCountException;
import models.Game;
import models.GameState;
import models.Player;
import strategies.winning.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(List<Player> players,
                          List<WinningStrategy> winningStrategies,
                          int dimension) throws PlayerCountException, BotCountException {

        return Game
                .getBuilder()
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .setDimension(dimension)
                .build();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public GameState checkGameStatus(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }
}
