package com.chess.engine.board;

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = initColumn(0); // size 64, every value false except the first column
    public static final boolean[] SECOND_COLUMN = initColumn(1); // size 64, every value false except the second column
    public static final boolean[] SEVENTH_COLUMN = initColumn(6); // size 64, every value false except the seventh column
    public static final boolean[] EIGHTH_COLUMN = initColumn(7); // size 64, every value false except the eighth column

    public static final int NUM_TILES = 64;
    public static final int NUM_TILES_PER_ROW = 8;

    private BoardUtils() {
        throw new RuntimeException("You cannot instantiate me!");
    }

    private static boolean[] initColumn(int columnNumber) {
        final boolean[] column = new boolean[NUM_TILES];
        do {
            column[columnNumber] = true;
            columnNumber += NUM_TILES_PER_ROW;
        } while (columnNumber < NUM_TILES);
        return column;
    }

    public static boolean isValidTileCoordinate(final int candidateDestinationCoordinate) {
        return candidateDestinationCoordinate >= 0 && candidateDestinationCoordinate < 64;
    }
}
