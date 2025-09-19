package src.TicTacToe.utils;

import java.util.List;

public class CommonUtils {
    private static final List<Character> PLAYER_CHARS = List.of('X', '0');

    public static Character getPlayerCharacter(int player) {
        return PLAYER_CHARS.get(player);
    }
}
