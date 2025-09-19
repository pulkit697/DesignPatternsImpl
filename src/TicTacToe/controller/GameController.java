package src.TicTacToe.controller;

import src.TicTacToe.exceptions.UnsupportedMoveException;
import src.TicTacToe.models.Grid;
import src.TicTacToe.models.Player;
import src.TicTacToe.utils.GameUtils;

public class GameController {
    private final Grid grid;
    private int numberOfVacantCells = 9;
    private boolean isGameConcluded = false;

    private final Player[] players;
    private int currentPlayer = 0;

    public GameController(int gridSize, Player[] players) {
        grid = new Grid(gridSize);
        this.players = players;
    }

    public void play(int row, int col) throws UnsupportedMoveException {
        if (row<0 || row>=grid.getSize() || col<0 || col>=grid.getSize()) {
            throw new UnsupportedMoveException("Invalid cell location!");
        }
        if (!grid.getCell(row, col).isVacant()) {
            throw new UnsupportedMoveException("Cell already filled");
        }
        grid.getCell(row, col).setPlayer(players[currentPlayer]);
        isGameConcluded = GameUtils.isGameConcluded(grid, row, col, players[currentPlayer]);
    }

    public boolean isGameOver() {
        return numberOfVacantCells==0;
    }

    public boolean isGameConcluded() {
        return isGameConcluded;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    public void nextTurn() {
        currentPlayer = (currentPlayer + 1) % players.length;
        numberOfVacantCells--;
    }

    public Grid getGrid() {
        return grid;
    }
}
