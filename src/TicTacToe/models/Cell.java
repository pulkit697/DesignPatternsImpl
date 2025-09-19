package src.TicTacToe.models;

import src.TicTacToe.exceptions.UnsupportedMoveException;
import src.TicTacToe.utils.CommonUtils;

public class Cell {
    private boolean isVacant;
    private Player player;

    public Cell() {
        this.isVacant = true;
    }

    public boolean isVacant() {
        return isVacant;
    }

    public void setPlayer(Player player) throws UnsupportedMoveException {
        if (!isVacant) {
            throw new UnsupportedMoveException("Illegal move.");
        }
        this.isVacant = false;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
