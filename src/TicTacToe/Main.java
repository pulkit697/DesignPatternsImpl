package src.TicTacToe;

import src.TicTacToe.UI.ConsoleGameInitiationInputTaker;
import src.TicTacToe.UI.ConsoleGameRuntimeInputTaker;
import src.TicTacToe.UI.ConsoleOutputRenderer;
import src.TicTacToe.controller.GameLoop;
import src.TicTacToe.interfaces.OutputRenderer;
import src.TicTacToe.interfaces.WinEvaluationStrategy;
import src.TicTacToe.strategy.StandardWinningStrategy;
import src.TicTacToe.interfaces.GameInitiationInputTaker;
import src.TicTacToe.interfaces.GameRuntimeInputTaker;

public class Main {
    public static void main(String[] args) {
        GameRuntimeInputTaker playerInputTaker = new ConsoleGameRuntimeInputTaker();
        GameInitiationInputTaker initiationInputTaker = new ConsoleGameInitiationInputTaker();
        OutputRenderer outputRenderer = new ConsoleOutputRenderer();
        WinEvaluationStrategy winEvaluationStrategy = new StandardWinningStrategy();

        GameLoop gameLoop = new GameLoop(playerInputTaker, initiationInputTaker, outputRenderer, winEvaluationStrategy);
        gameLoop.setUp();
        gameLoop.start();
    }
}
