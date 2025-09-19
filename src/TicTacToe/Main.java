package src.TicTacToe;

import src.TicTacToe.UI.ConsoleInputTaker;
import src.TicTacToe.UI.ConsoleOutputRenderer;
import src.TicTacToe.controller.GameController;
import src.TicTacToe.exceptions.UnsupportedMoveException;
import src.TicTacToe.interfaces.OutputRenderer;
import src.TicTacToe.interfaces.PlayerInputTaker;
import src.TicTacToe.models.Player;

public class Main {
    public static void main(String[] args) {
        PlayerInputTaker playerInputTaker = new ConsoleInputTaker();
        OutputRenderer outputRenderer = new ConsoleOutputRenderer();

        GameController game = new GameController();

        while (!game.isGameOver()) {
            try {
                int[] coordinates = playerInputTaker.takePlayerInputCoordinates();
                game.play(coordinates[0], coordinates[1]);
                outputRenderer.displayGrid(game.getGrid());
                if (game.isGameConcluded()) {
                    Player winner = game.getCurrentPlayer();
                    outputRenderer.displayWinner(winner);
                    break;
                }
                game.nextTurn();
            } catch (UnsupportedMoveException e) {
                outputRenderer.displayIncorrectMove(e.getMessage());
            }
        }
        if (game.isGameOver()) {
            outputRenderer.displayTie();
        }
    }
}
