package src.TicTacToe.interfaces;

import src.TicTacToe.models.Grid;
import src.TicTacToe.models.Player;

public interface WinEvaluationStrategy {
    public boolean isGameConcluded(Grid grid, int row, int col, Player player);
}
