package src.TicTacToe.UI;

import java.util.Scanner;

import src.TicTacToe.interfaces.GameRuntimeInputTaker;
import src.TicTacToe.models.Player;
import src.TicTacToe.utils.CommonUtils;

public class ConsoleGameRuntimeInputTaker implements GameRuntimeInputTaker {
    private static final Scanner scanner = new Scanner(System.in);
    
    @Override
    public int[] takePlayerInputCoordinates(Player p) {
        char playerChar = CommonUtils.getPlayerCharacter(p);
        System.out.print("Player " + p.getName() + " (" + playerChar + "), Enter row & col to fill: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new int[]{x, y};
    }
}
