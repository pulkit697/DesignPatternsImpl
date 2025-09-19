package src.TicTacToe.interfaces;

import src.TicTacToe.models.Player;

public interface PlayerInputTaker {
    int[] takePlayerInputCoordinates(Player p);
    String getName();
}
