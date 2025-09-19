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

    public void print() {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                grid[i][j].print();
                if (j<size-1) {
                    System.out.print("|");
                }
            }
            if (i<size-1) {
                System.out.print("\n");
                for (int j=0; j<size; j++) {
                    if (j<size-1) {
                        System.out.println("–+");
                    } else {
                        System.out.println("–");
                    }
                }
            }
        }
        System.out.println("\n");
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public int getSize() {
        return size;
    }
}
