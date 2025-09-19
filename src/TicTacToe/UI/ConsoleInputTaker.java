package src.TicTacToe.UI;

import java.util.Scanner;

import src.TicTacToe.interfaces.InputTaker;
import src.TicTacToe.models.Player;
import src.TicTacToe.utils.CommonUtils;

public class ConsoleInputTaker implements InputTaker {
    private static final Scanner scanner = new Scanner(System.in);
    
    @Override
    public int[] takePlayerInputCoordinates(Player p) {
        char playerChar = CommonUtils.getPlayerCharacter(p);
        System.out.print("Player " + p.getName() + " (" + playerChar + "), Enter row & col to fill: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new int[]{x, y};
    }

    @Override
    public String getPlayerName() {
        System.out.print("Please enter your name: ");
        String name = scanner.next();
        return name;
    }

    @Override
    public int getGridSize() {
        System.out.print("Please enter size of grid: ");
        int size = scanner.nextInt();
        return size;
    }

    @Override
    public int getNumberOfPlayers() {
        System.out.print("Please enter number of players: ");
        int numberOfPlayers = scanner.nextInt();
        return numberOfPlayers;
    }

}
