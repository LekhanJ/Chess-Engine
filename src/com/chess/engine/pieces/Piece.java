package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.Collection;

public abstract class Piece {
    protected final int piecePosition;
    protected final Alliance pieceAlliance;
    protected final boolean isFirstMove;

    protected Piece(final int piecePosition, final Alliance pieceAlliance) {
        this.piecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
        // TODO need more work
        this.isFirstMove = false;
    }

    public int getPiecePosition() {
        return this.piecePosition;
    }

    public Alliance getPieceAlliance() {
        return this.pieceAlliance;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public abstract Collection<Move> calculateLegalMoves(final Board board);

    public enum PieceType {
        BLACKPAWN("♙"),
        WHITEPAWN("♟"),
        BLACKKNIGHT("♘"),
        WHITEKNIGHT("♞"),
        BLACKBISHOP("♗"),
        WHITEBISHOP("♝"),
        BLACKROOK("♖"),
        WHITEROOK("♜"),
        BLACKQUEEN("♕"),
        WHITEQUEEN("♛"),
        BLACKKING("♔"),
        WHITEKING("♚");

        private String pieceName;

        PieceType(final String pieceName) {
            this.pieceName = pieceName;
        }

        @Override
        public String toString() {
            return this.pieceName;
        }
    }
}
