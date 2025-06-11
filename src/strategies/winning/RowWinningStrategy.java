package strategies.winning;

import models.Board;
import models.Move;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {

    private Map<Integer, Map<Symbol, Integer>> countMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!countMap.containsKey(row)) {
            countMap.put(row, new HashMap<>());
        }

        Map<Symbol, Integer> rowMap = countMap.get(row);
        rowMap.put(symbol, rowMap.getOrDefault(symbol, 0) + 1);

        if(rowMap.get(symbol) == board.getSize()) {
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol, Integer> rowMap = countMap.get(row);
        rowMap.put(symbol, rowMap.get(symbol) - 1);
    }
}
