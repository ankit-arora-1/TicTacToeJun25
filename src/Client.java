import controllers.GameController;
import exceptions.BotCountException;
import exceptions.PlayerCountException;
import models.*;
import strategies.winning.ColWinningStrategy;
import strategies.winning.DiagonalWinningStrategy;
import strategies.winning.RowWinningStrategy;
import strategies.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws PlayerCountException, BotCountException {
        GameController gameController = new GameController();

        int dimension = 3;
        List<Player> players = new ArrayList<>();
        players.add(
                new Player(1L ,
                        new Symbol('X'),
                        "Intezar",
                        PlayerType.HUMAN)
        );

        players.add(
                new Bot(2L,
                        new Symbol('O'),
                        "Bagdeesh",
                        BotDifficultyLevel.EASY)
        );

       List<WinningStrategy> winningStrategies = new ArrayList<>();
       winningStrategies.add(new ColWinningStrategy());
       winningStrategies.add(new RowWinningStrategy());
       winningStrategies.add(new DiagonalWinningStrategy());

       Game game = gameController.startGame(
               players,
               winningStrategies,
               dimension);

       while(gameController.checkGameStatus(game).equals(GameState.IN_PROGRESS)) {
           gameController.printBoard(game);
           gameController.makeMove(game);
       }

       System.out.println("Game  has ended");
       gameController.printBoard(game);

       if(gameController.checkGameStatus(game).equals(GameState.WIN)) {
           Player player = gameController.getWinner(game);
           System.out.println("Winner is: " + player.getName());
       } else {
           System.out.println("Game has drawn");
       }


    }
}
