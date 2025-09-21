package src.TicTacToe.interfaces;

import src.TicTacToe.models.Player;

public interface GameRuntimeInputTaker {
    int[] takePlayerInputCoordinates(Player p);
}
