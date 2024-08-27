package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import com.chess.engine.board.Board.Builder;

public abstract class Move {
    final Board board;
    final Piece movedPiece;
    final int destinationCoordinate;

    public Move(final Board board, final Piece movedPiece, final int destinationCoordinate) {
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }

    public int getDestinationCoordinate() {
        return this.destinationCoordinate;
    }

    public Piece getMovedPiece() {
        return this.movedPiece;
    }

    public abstract Board execute();

    // Normal Move
    public static final class MajorMove extends Move {

        public MajorMove(final Board board, final Piece movedPiece, final int destinationCoordinate) {
            super(board, movedPiece, destinationCoordinate);
        }

        // This method will build and return a new board
        @Override
        public Board execute() {
            // Creating a Builder that will help use create a board that we will return
            final Builder builder = new Builder();

            // Traversing through all the pieces of current player and placing all the pieces on the new board except the moved piece
            for (final Piece piece : this.board.currentPlayer().getActivePieces()) {
                // TODO hashcode and equals for pieces
                if (!this.movedPiece.equals(piece)) {
                    builder.setPiece(piece);
                }
            }

            // Traversing through all the opponent's pieces and placing them on the board
            for (final Piece piece : this.board.currentPlayer().getOpponent().getActivePieces()) {
                builder.setPiece(piece);
            }

            // Move the piece
            builder.setPiece(this.movedPiece.movePiece(this));

            // Set opponent as next move maker
            builder.setMoveMaker(this.board.currentPlayer().getOpponent().getAlliance());

            // Build and return the board
            return builder.build();
        }
    } 

    // Attacking Move
    public static final class AttackingMove extends Move {
        final Piece attackedPiece;

        public AttackingMove(final Board board, final Piece movedPiece, final int destinationCoordinate, final Piece attackedPiece) {
            super(board, movedPiece, destinationCoordinate);
            this.attackedPiece = attackedPiece;
        }

        // TODO need more work
        // this method will build and return a new board
        @Override
        public Board execute() {
            return null;
        }
    }
}
