package src.TicTacToe.UI;

import java.util.Scanner;

import src.TicTacToe.interfaces.PlayerInputTaker;

public class ConsoleInputTaker implements PlayerInputTaker {
    private static final Scanner scanner = new Scanner(System.in);
    
    @Override
    public int[] takePlayerInputCoordinates() {
        System.out.print("Player, Enter row & col to fill: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new int[]{x, y};
    }

    @Override
    public String getName() {
        System.out.print("Please enter your name: ");
        String name = scanner.next();
        return name;
    }

}
