package src.TicTacToe.models;

public class Player {
    private String name;
    private int index;

    public Player(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return this.name;
    }

    public int getIndex() {
        return index;
    }
}
