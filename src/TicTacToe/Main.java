package src.TicTacToe;

import src.TicTacToe.UI.ConsoleInputTaker;
import src.TicTacToe.UI.ConsoleOutputRenderer;
import src.TicTacToe.controller.GameController;
import src.TicTacToe.interfaces.OutputRenderer;
import src.TicTacToe.interfaces.PlayerInputTaker;

public class Main {
    public static void main(String[] args) {
        PlayerInputTaker playerInputTaker = new ConsoleInputTaker();
        OutputRenderer outputRenderer = new ConsoleOutputRenderer();

        GameController game = new GameController();

        while (!game.isGameOver()) {
            int[] coordinates = playerInputTaker.takePlayerInputCoordinates();
            
            game.play(coordinates[0], coordinates[1]);
            outputRenderer.render(game.getGrid());
        }
    }
}
