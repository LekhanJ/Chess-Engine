package com.chess.engine.board;

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = null; // size 64, every value false except the first column
    public static final boolean[] SECOND_COLUMN = null; // size 64, every value false except the second column
    public static final boolean[] SEVENTH_COLUMN = null; // size 64, every value false except the seventh column
    public static final boolean[] EIGHTH_COLUMN = null; // size 64, every value false except the eighth column

    private BoardUtils() {
        throw new RuntimeException("You cannot instantiate me!");
    }

    public static boolean isValidTileCoordinate(int candidateDestinationCoordinate) {
        return candidateDestinationCoordinate >= 0 && candidateDestinationCoordinate < 64;
    }
}
