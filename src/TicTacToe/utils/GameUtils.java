package src.TicTacToe.utils;

import src.TicTacToe.models.Grid;

public class GameUtils {

    public static boolean isGameConcluded(Grid grid, int row, int col, boolean parity) {
        return isRowComplete(grid, row, parity) || isColComplete(grid, col, parity) || isLeftDiagComplete(grid, row, col, parity) || isRightDiagComplete(grid, row, col, parity);
    }

    private static boolean isRowComplete(Grid grid, int row, boolean parity) {
        for (int j=0; j<3; j++) {
            if (grid.getCell(row,j).isVacant() || grid.getCell(row,j).getParity() != parity) {
                return false;
            }
        }
        return true;
    }

    private static boolean isColComplete(Grid grid, int col, boolean parity) {
        for (int i=0; i<3; i++) {
            if (grid.getCell(i,col).isVacant() || grid.getCell(i,col).getParity() != parity) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLeftDiagComplete(Grid grid, int row, int col, boolean parity) {
        if (row != col) return false;
        for (int i=0; i<3; i++) {
            if (grid.getCell(i, i).isVacant() || grid.getCell(i, i).getParity() != parity) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRightDiagComplete(Grid grid, int row, int col, boolean parity) {
        if (row+col != 2) return false;
        for (int i=0; i<3; i++) {
            if (grid.getCell(i,2-i).isVacant() || grid.getCell(i,2-i).getParity() != parity) {
                return false;
            }
        }
        return true;
    }
}
