package strategies.winning;

import models.Board;
import models.Move;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {
    private Map<Symbol, Integer> leftDiagonal = new HashMap<>();
    private Map<Symbol, Integer> rightDiagonal = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
       int row = move.getCell().getRow();
       int col = move.getCell().getCol();
       Symbol symbol = move.getPlayer().getSymbol();

       if(row == col) {
           leftDiagonal.put(symbol,
                   leftDiagonal.getOrDefault(symbol, 0) + 1);

           if(leftDiagonal.get(symbol) == board.getSize()) {
               return true;
           }
       }

       if(row + col == board.getSize() - 1) {
           rightDiagonal.put(symbol,
                   rightDiagonal.getOrDefault(symbol, 0) + 1);

           if(rightDiagonal.get(symbol) == board.getSize()) {
               return true;
           }
       }


        return false;
    }

    @Override
    public void handleUndo(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col) {
            leftDiagonal.put(
                    symbol,
                    leftDiagonal.get(symbol) - 1
            );
        }

        if(row + col == board.getSize() - 1) {
            rightDiagonal.put(
                    symbol,
                    rightDiagonal.get(symbol) - 1
            );
        }
    }
}
