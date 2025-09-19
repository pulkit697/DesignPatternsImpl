package src.TicTacToe.utils;

import src.TicTacToe.models.Grid;

public class GameUtils {

    public static boolean isGameConcluded(Grid grid, int row, int col, int player) {
        return isRowComplete(grid, row, player) || isColComplete(grid, col, player) || isLeftDiagComplete(grid, row, col, player) || isRightDiagComplete(grid, row, col, player);
    }

    private static boolean isRowComplete(Grid grid, int row, int player) {
        for (int j=0; j<3; j++) {
            if (grid.getCell(row,j).isVacant() || grid.getCell(row,j).getPlayer() != player) {
                return false;
            }
        }
        return true;
    }

    private static boolean isColComplete(Grid grid, int col, int player) {
        for (int i=0; i<3; i++) {
            if (grid.getCell(i,col).isVacant() || grid.getCell(i,col).getPlayer() != player) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLeftDiagComplete(Grid grid, int row, int col, int player) {
        if (row != col) return false;
        for (int i=0; i<3; i++) {
            if (grid.getCell(i, i).isVacant() || grid.getCell(i, i).getPlayer() != player) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRightDiagComplete(Grid grid, int row, int col, int player) {
        if (row+col != 2) return false;
        for (int i=0; i<3; i++) {
            if (grid.getCell(i,2-i).isVacant() || grid.getCell(i,2-i).getPlayer() != player) {
                return false;
            }
        }
        return true;
    }
}
