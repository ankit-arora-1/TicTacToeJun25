package strategies.bot;

import models.Board;
import models.Cell;
import models.CellState;
import models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> cells: board.getBoard()) {
            for(Cell cell: cells) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, null);
                }
            }
        }

        return null;
    }
}
