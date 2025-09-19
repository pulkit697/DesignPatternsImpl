package src.TicTacToe.models;

public class Grid {
    private final int size;
    private final Cell[][] grid;

    public Grid(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public int getSize() {
        return size;
    }
}
