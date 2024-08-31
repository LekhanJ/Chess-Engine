package com.chess.engine.player;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.concurrent.Future;

/*
    this class represents that when you make a move the transition from one board to another
    and all the information that you want to carry forth in that.
*/
public class MoveTransition {
    private final Board transitionBoard;
    private final Move move;
    private final MoveStatus moveStatus;

    public MoveTransition(final Board transitionBoard, final Move move, final MoveStatus moveStatus) {
        this.transitionBoard = transitionBoard;
        this.move = move;
        this.moveStatus = moveStatus;
    }

    public MoveStatus getMoveStatus() {
        return this.moveStatus;
    }

    public Board getTransitionBoard() {
        return this.transitionBoard;
    }
}
