package src.TicTacToe.controller;

import src.TicTacToe.exceptions.UnsupportedMoveException;
import src.TicTacToe.interfaces.WinEvaluationStrategy;
import src.TicTacToe.models.Grid;
import src.TicTacToe.models.Player;

public class GameController {
    private final Grid grid;
    private final WinEvaluationStrategy winEvaluationStrategy;
    private int numberOfMovesRemaining;
    private boolean isGameConcluded = false;

    private final Player[] players;
    private int currentPlayer = 0;

    public GameController(WinEvaluationStrategy winEvaluationStrategy, int gridSize, Player[] players) {
        this.winEvaluationStrategy = winEvaluationStrategy;
        grid = new Grid(gridSize);
        this.players = players;
        numberOfMovesRemaining = gridSize*gridSize;
    }

    public void play(int row, int col) throws UnsupportedMoveException {
        if (row<0 || row>=grid.getSize() || col<0 || col>=grid.getSize()) {
            throw new UnsupportedMoveException("Invalid cell location!");
        }
        if (!grid.getCell(row, col).isVacant()) {
            throw new UnsupportedMoveException("Cell already filled");
        }
        grid.getCell(row, col).setPlayer(players[currentPlayer]);
        isGameConcluded = winEvaluationStrategy.isGameConcluded(grid, row, col, players[currentPlayer]);
        if (!isGameConcluded) {
            nextTurn();
        }
    }

    public boolean isGameOver() {
        return numberOfMovesRemaining==0 || isGameConcluded;
    }

    public boolean isGameTied() {
        return !isGameConcluded && numberOfMovesRemaining == 0;
    }

    public boolean isGameConcluded() {
        return isGameConcluded;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    private void nextTurn() {
        currentPlayer = (currentPlayer + 1) % players.length;
        numberOfMovesRemaining--;
    }

    public Grid getGrid() {
        return grid;
    }
}
