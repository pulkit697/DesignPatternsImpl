package src.TicTacToe.controller;

import src.TicTacToe.exceptions.UnsupportedMoveException;
import src.TicTacToe.interfaces.OutputRenderer;
import src.TicTacToe.interfaces.InputTaker;
import src.TicTacToe.models.Player;

public class GameLoop {
    private int size = 3;
    private int numberOfPlayers = 2;
    private GameController game;
    private final InputTaker inputTaker;
    private final OutputRenderer outputRenderer;

    public GameLoop(InputTaker inputTaker, OutputRenderer outputRenderer) {
        this.inputTaker = inputTaker;
        this.outputRenderer = outputRenderer;
    }

    public void setUp() {
        size = inputTaker.getGridSize();
        numberOfPlayers = inputTaker.getNumberOfPlayers();
        Player[] players = new Player[numberOfPlayers];
        for (int i=0; i<numberOfPlayers; i++) {
            String name = inputTaker.getPlayerName();
            players[i] = new Player(name, i);
        }
        game = new GameController(size, players);
    }

    public void start() {
        while (!game.isGameOver()) {
            try {
                int[] coordinates = inputTaker.takePlayerInputCoordinates(game.getCurrentPlayer());
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
