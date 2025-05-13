package src.TicTacToe.exceptions;

public class UnsupportedMoveException extends Exception {

    public UnsupportedMoveException() {
        super("Illegal move.");
    }
}
