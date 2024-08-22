package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends Piece {

    private final static int[] CANDIDATE_MOVE_OFFSETS = {8, 16};

    private Pawn(final int piecePosition, final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calculateLegalMoves(Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentOffset : CANDIDATE_MOVE_OFFSETS) {
            final int candidateDestinationCoordinate = this.piecePosition + (currentOffset * this.getPieceAlliance().getDirection());

            if (!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                continue;
            }

            if (currentOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                // Need more work
                legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
            }
        }

        return ImmutableList.copyOf(legalMoves);
    }
}
