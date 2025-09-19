package src.TicTacToe.strategy;

import src.TicTacToe.interfaces.WinEvaluationStrategy;
import src.TicTacToe.models.Grid;
import src.TicTacToe.models.Player;

public class StandardWinningStrategy implements WinEvaluationStrategy {

    @Override
    public boolean isGameConcluded(Grid grid, int row, int col, Player player) {
        return isRowComplete(grid, row, player) || isColComplete(grid, col, player) || isLeftDiagComplete(grid, row, col, player) || isRightDiagComplete(grid, row, col, player);
    }

    private boolean isRowComplete(Grid grid, int row, Player player) {
        for (int j=0; j<grid.getSize(); j++) {
            if (grid.getCell(row,j).isVacant() || grid.getCell(row,j).getPlayer() != player) {
                return false;
            }
        }
        return true;
    }

    private boolean isColComplete(Grid grid, int col, Player player) {
        for (int i=0; i<grid.getSize(); i++) {
            if (grid.getCell(i,col).isVacant() || grid.getCell(i,col).getPlayer() != player) {
                return false;
            }
        }
        return true;
    }

    private boolean isLeftDiagComplete(Grid grid, int row, int col, Player player) {
        if (row != col) return false;
        for (int i=0; i<grid.getSize(); i++) {
            if (grid.getCell(i, i).isVacant() || grid.getCell(i, i).getPlayer() != player) {
                return false;
            }
        }
        return true;
    }

    private boolean isRightDiagComplete(Grid grid, int row, int col, Player player) {
        if (row+col != grid.getSize()-1) return false;
        for (int i=0; i<grid.getSize(); i++) {
            if (grid.getCell(i,grid.getSize()-1-i).isVacant() || grid.getCell(i,grid.getSize()-1-i).getPlayer() != player) {
                return false;
            }
        }
        return true;
    }
}
