package src.TicTacToe.UI;

import src.TicTacToe.interfaces.OutputRenderer;
import src.TicTacToe.models.Grid;
import src.TicTacToe.models.Player;

public class ConsoleOutputRenderer implements OutputRenderer {
    
    @Override
    public void displayGrid(Grid grid) {
        int size = grid.getSize();
        for (int i = 0; i<size; i++) {
            for (int j=0; j<size; j++) {
                System.out.print(grid.getCell(i, j) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void displayWinner(Player p) {
        System.out.println("Congratulations!! Player " + p.getName() + " has won!!");
    }

    @Override
    public void displayIncorrectMove(String error) {
        System.out.println("Incorrect Move: " + error);
    }

    @Override
    public void displayTie() {
        System.out.println("OOPS! This round tied. Well Played!");
    }
}
