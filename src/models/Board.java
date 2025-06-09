package models;

import java.util.*;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>(); // []
        for(int i = 0; i < size; i++) {
           this.board.add(new ArrayList<>()); // [[], [], []]
           for(int j = 0; j < size; j++) {
               this.board.get(i).add(new Cell(i, j)); // [[cell, cell, cell], [cell, cell, cell], [cell, cell, cell]]
           }
        }
    }

    public void printBoard() {
        for(List<Cell> cells: board) {
            for(Cell cell: cells) {
                cell.display();
            }

            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
