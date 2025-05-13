package src.TicTacToe.models;

import src.TicTacToe.exceptions.UnsupportedMoveException;

public class Cell {
    private boolean isVacant;
    private boolean parity;

    public Cell() {
        this.isVacant = true;
    }

    public boolean isVacant() {
        return isVacant;
    }

    public void setParity(boolean parity) throws UnsupportedMoveException {
        if (!isVacant) {
            throw new UnsupportedMoveException();
        }
        this.isVacant = false;
        this.parity = parity;
    }

    public boolean getParity() {
        return parity;
    }

    public void print() {
        if (isVacant) {
            System.out.print(" ");
        } else if (parity) {
            System.out.print("X");
        } else {
            System.out.print("O");
        }
    }
}
