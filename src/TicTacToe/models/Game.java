package src.TicTacToe.models;

import src.TicTacToe.exceptions.UnsupportedMoveException;
import src.TicTacToe.utils.GameUtils;

public class Game {
    private final Cell[][] grid = new Cell[3][3];
    private boolean playerTurn = false;
    private int numberOfVacantCells = 9;

    public Game() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void play(int row, int col) {
        if (row<0 || row>=3 || col<0 || col>=3) {
            System.out.println("Invalid cell location!");
            return;
        }
        if (!grid[row][col].isVacant()) {
            System.out.println("Cell already filled");
            return;
        }
        try {
            grid[row][col].setParity(playerTurn);
        } catch (UnsupportedMoveException e) {
            System.out.println("Invalid move");
            return;
        }
        boolean isGameConcluded = GameUtils.isGameConcluded(grid, row, col, playerTurn);
        if (isGameConcluded) {
            numberOfVacantCells = 0;
            System.out.println("Congratulations!! Player '" + getCurrentPlayer() + "' has won!!");
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
}
