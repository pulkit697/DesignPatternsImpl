package src.TicTacToe.controller;

import src.TicTacToe.exceptions.UnsupportedMoveException;
import src.TicTacToe.interfaces.OutputRenderer;
import src.TicTacToe.interfaces.WinEvaluationStrategy;
import src.TicTacToe.interfaces.GameInitiationInputTaker;
import src.TicTacToe.interfaces.GameRuntimeInputTaker;
import src.TicTacToe.models.Player;
import src.TicTacToe.utils.CommonUtils;

public class GameLoop {
    private int size = 3;
    private int numberOfPlayers = 2;
    private GameController game;
    private final GameRuntimeInputTaker runtimeInputs;
    private final GameInitiationInputTaker initiationInput;
    private final OutputRenderer outputRenderer;
    private final WinEvaluationStrategy winEvaluationStrategy;

    public GameLoop(GameRuntimeInputTaker runtimeInputs, GameInitiationInputTaker gameInitiationInputTaker, OutputRenderer outputRenderer, WinEvaluationStrategy winEvaluationStrategy) {
        this.runtimeInputs = runtimeInputs;
        this.initiationInput = gameInitiationInputTaker;
        this.outputRenderer = outputRenderer;
        this.winEvaluationStrategy = winEvaluationStrategy;
    }

    public void setUp() {
        size = initiationInput.getGridSize();
        numberOfPlayers = initiationInput.getNumberOfPlayers();
        while (numberOfPlayers > CommonUtils.getMaxNumberOfPlayers()) {
            outputRenderer.displayMaxNumberOfPlayersSupported();
            numberOfPlayers = initiationInput.getNumberOfPlayers();
        }
        Player[] players = new Player[numberOfPlayers];
        for (int i=0; i<numberOfPlayers; i++) {
            String name = initiationInput.getPlayerName();
            players[i] = new Player(name, i);
        }
        game = new GameController(winEvaluationStrategy, size, players);
    }

    public void start() {
        while (!game.isGameOver()) {
            try {
                int[] coordinates = runtimeInputs.takePlayerInputCoordinates(game.getCurrentPlayer());
                game.play(coordinates[0], coordinates[1]);
                outputRenderer.displayGrid(game.getGrid());
                if (game.isGameConcluded()) {
                    Player winner = game.getCurrentPlayer();
                    outputRenderer.displayWinner(winner);
                    break;
                }
            } catch (UnsupportedMoveException e) {
                outputRenderer.displayIncorrectMove(e.getMessage());
            }
        }
        if (game.isGameTied()) {
            outputRenderer.displayTie();
        }
    }
}
