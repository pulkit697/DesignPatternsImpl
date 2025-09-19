package src.TicTacToe.UI;

import java.util.Scanner;

import src.TicTacToe.interfaces.PlayerInputTaker;

public class ConsoleInputTaker implements PlayerInputTaker {
    private static final Scanner scanner = new Scanner(System.in);
    
    @Override
    public int[] takePlayerInputCoordinates() {
        System.out.println("Player, Enter row & col to fill: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new int[]{x, y};
    }

    @Override
    public String getName() {
        String name = scanner.next();
        return name;
    }

}
