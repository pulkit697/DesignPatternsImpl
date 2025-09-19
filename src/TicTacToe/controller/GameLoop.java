package src.TicTacToe.controller;

import src.TicTacToe.exceptions.UnsupportedMoveException;
import src.TicTacToe.interfaces.OutputRenderer;
import src.TicTacToe.interfaces.PlayerInputTaker;
import src.TicTacToe.models.Player;

public class GameLoop {
    private GameController game = new GameController();
    private final PlayerInputTaker playerInputTaker;
    private final OutputRenderer outputRenderer;

    public GameLoop(PlayerInputTaker playerInputTaker, OutputRenderer outputRenderer) {
        this.playerInputTaker = playerInputTaker;
        this.outputRenderer = outputRenderer;
    }

    public void setUp() {
        Player[] players = new Player[2];
        for (int i=0; i<2; i++) {
            String name = playerInputTaker.getName();
            players[i] = new Player(name, i);
        }
        game.setPlayers(players);
    }

    public void start() {
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
