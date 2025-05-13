package src.TicTacToe;

import src.TicTacToe.models.Game;
import src.TicTacToe.utils.GameUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        while (!game.isGameOver()) {
            GameUtils.printGrid(game.getGrid());
            System.out.print("(Player '" + game.getCurrentPlayer() + "') Enter row & col to fill: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            game.play(row, col);
        }
    }
}
