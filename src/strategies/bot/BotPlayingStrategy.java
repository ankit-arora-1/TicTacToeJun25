package strategies.bot;

import models.Board;
import models.Move;

public interface BotPlayingStrategy {
    public Move makeMove(Board board);
}
