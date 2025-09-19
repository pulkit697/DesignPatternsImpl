package src.TicTacToe.utils;

import java.util.List;

import src.TicTacToe.models.Player;

public class CommonUtils {
    private static final List<Character> PLAYER_CHARS = List.of('X', 'O', '*', '$', '#', 'µ', '@', 'A', 'B');

    public static Character getPlayerCharacter(Player player) {
        return PLAYER_CHARS.get(player.getIndex());
    }

    public static int getMaxNumberOfPlayers () {
        return PLAYER_CHARS.size();
    }
}
