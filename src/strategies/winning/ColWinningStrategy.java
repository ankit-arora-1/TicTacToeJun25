package strategies.winning;

import models.Board;
import models.Move;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy {
    private Map<Integer, Map<Symbol, Integer>> countMap = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!countMap.containsKey(col)) {
            countMap.put(col, new HashMap<>());
        }

        Map<Symbol, Integer> colMap = countMap.get(col);
        colMap.put(symbol, colMap.getOrDefault(symbol, 0) + 1);

        if(colMap.get(symbol) == board.getSize()) {
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol, Integer> colMap = countMap.get(col);
        colMap.put(symbol, colMap.get(symbol) - 1);
    }
}
