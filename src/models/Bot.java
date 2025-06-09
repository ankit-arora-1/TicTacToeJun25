package models;

import strategies.bot.BotPlayingFactory;
import strategies.bot.BotPlayingStrategy;
import strategies.bot.EasyBotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Long id, Symbol symbol, String name, BotDifficultyLevel botDifficultyLevel) {
        super(id, symbol, name, PlayerType.BOT);
        this.difficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingFactory
                .getBotPlayingStrategy(difficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);

        return move;
    }
}
