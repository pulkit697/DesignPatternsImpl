package src.TicTacToe.UI;

import src.TicTacToe.interfaces.OutputRenderer;
import src.TicTacToe.models.Grid;

public class ConsoleOutputRenderer implements OutputRenderer {
    
    @Override
    public void render(Grid grid) {
        int size = grid.getSize();
        for (int i = 0; i<size; i++) {
            for (int j=0; j<size; j++) {
                System.out.print(grid.getCell(i, j) + " ");
            }
            System.out.println();
        }
    }
}
