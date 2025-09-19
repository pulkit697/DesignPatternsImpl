package src.TicTacToe.interfaces;

import src.TicTacToe.models.Player;

public interface InputTaker {
    int[] takePlayerInputCoordinates(Player p);
    String getPlayerName();
    int getGridSize();
    int getNumberOfPlayers();
}
