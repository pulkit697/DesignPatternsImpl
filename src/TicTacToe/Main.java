package src.TicTacToe;

import src.TicTacToe.UI.ConsoleInputTaker;
import src.TicTacToe.UI.ConsoleOutputRenderer;
import src.TicTacToe.controller.GameLoop;
import src.TicTacToe.interfaces.OutputRenderer;
import src.TicTacToe.interfaces.WinEvaluationStrategy;
import src.TicTacToe.strategy.StandardWinningStrategy;
import src.TicTacToe.interfaces.InputTaker;

public class Main {
    public static void main(String[] args) {
        InputTaker playerInputTaker = new ConsoleInputTaker();
        OutputRenderer outputRenderer = new ConsoleOutputRenderer();
        WinEvaluationStrategy winEvaluationStrategy = new StandardWinningStrategy();

        GameLoop gameLoop = new GameLoop(playerInputTaker, outputRenderer, winEvaluationStrategy);
        gameLoop.setUp();
        gameLoop.start();
    }
}
