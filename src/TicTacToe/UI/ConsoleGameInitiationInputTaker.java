package src.TicTacToe.UI;

import java.util.Scanner;

import src.TicTacToe.interfaces.GameInitiationInputTaker;

public class ConsoleGameInitiationInputTaker implements GameInitiationInputTaker {
    private static final Scanner scanner = new Scanner(System.in);
    
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
