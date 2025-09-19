package src.TicTacToe.controller;

import src.TicTacToe.exceptions.UnsupportedMoveException;
import src.TicTacToe.models.Grid;
import src.TicTacToe.utils.GameUtils;

public class GameController {
    private final Grid grid;
    private boolean playerTurn = false;
    private int numberOfVacantCells = 9;

    public GameController() {
        grid = new Grid(3);
    }

    public void play(int row, int col) {
        if (row<0 || row>=3 || col<0 || col>=3) {
            System.out.println("Invalid cell location!");
            return;
        }
        if (!grid.getCell(row, col).isVacant()) {
            System.out.println("Cell already filled");
            return;
        }
        try {
            grid.getCell(row, col).setParity(playerTurn);
        } catch (UnsupportedMoveException e) {
            System.out.println("Invalid move");
            return;
        }
        boolean isGameConcluded = GameUtils.isGameConcluded(grid, row, col, playerTurn);
        if (isGameConcluded) {
            numberOfVacantCells = 0;
            System.out.println("Congratulations!! Player '" + getCurrentPlayer() + "' has won!!");
            return;
        }
        playerTurn = !playerTurn;
        numberOfVacantCells--;
    }

    public boolean isGameOver() {
        return numberOfVacantCells==0;
    }

    public char getCurrentPlayer() {
        if (playerTurn) {
            return 'X';
        }
        return 'O';
    }

    public void display() {
        grid.print();
    }

    public Grid getGrid() {
        return grid;
    }
}
