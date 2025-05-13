package src.TicTacToe.utils;

import src.TicTacToe.models.Cell;

public class GameUtils {

    public static void printGrid(Cell[][] grid) {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                grid[i][j].print();
                if (j<2) {
                    System.out.print("|");
                }
            }
            if (i<2) {
                System.out.print("\n");
                System.out.println("–+–+–");
            }
        }
        System.out.println("\n");
    }

    public static boolean isGameConcluded(Cell[][] grid, int row, int col, boolean parity) {
        return isRowComplete(grid, row, parity) || isColComplete(grid, col, parity) || isLeftDiagComplete(grid, row, col, parity) || isRightDiagComplete(grid, row, col, parity);
    }

    private static boolean isRowComplete(Cell[][] grid, int row, boolean parity) {
        for (int j=0; j<3; j++) {
            if (grid[row][j].isVacant() || grid[row][j].getParity() != parity) {
                return false;
            }
        }
        return true;
    }

    private static boolean isColComplete(Cell[][] grid, int col, boolean parity) {
        for (int i=0; i<3; i++) {
            if (grid[i][col].isVacant() || grid[i][col].getParity() != parity) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLeftDiagComplete(Cell[][] grid, int row, int col, boolean parity) {
        if (row != col) return false;
        for (int i=0; i<3; i++) {
            if (grid[i][i].isVacant() || grid[i][i].getParity() != parity) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRightDiagComplete(Cell[][] grid, int row, int col, boolean parity) {
        if (row+col != 2) return false;
        for (int i=0; i<3; i++) {
            if (grid[i][2-i].isVacant() || grid[i][2-i].getParity() != parity) {
                return false;
            }
        }
        return true;
    }
}
