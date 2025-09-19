package src.TicTacToe.interfaces;

import src.TicTacToe.models.Grid;
import src.TicTacToe.models.Player;

public interface OutputRenderer {
    void displayGrid(Grid grid);
    void displayWinner(Player player);
    void displayIncorrectMove(String error);
    void displayTie();
    void displayMaxNumberOfPlayersSupported();
}
