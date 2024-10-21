package com.chess.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.File;

import com.chess.engine.board.Move;
import com.chess.engine.pieces.Piece;
import com.chess.gui.Table.MoveLog;
import com.google.common.primitives.Ints;

public class TakenPiecesPanel extends JPanel {

    private final JPanel northPanel;
    private final JPanel southPanel;

    private static final Color PANEL_COLOR = Color.decode("#BDCFC2");
    private static final Dimension TAKEN_PIECES_DIMENSION = new Dimension(40, 80);
    private static final EtchedBorder PANEL_BORDER = new EtchedBorder(EtchedBorder.RAISED);

    public TakenPiecesPanel() {
            super(new BorderLayout());
            this.setBackground(Color.decode("#A8BA9A"));
            this.setBorder(PANEL_BORDER);
            this.northPanel = new JPanel(new GridLayout(8, 2));
            this.southPanel = new JPanel(new GridLayout(8, 2));
            this.northPanel.setBackground(PANEL_COLOR);
            this.southPanel.setBackground(PANEL_COLOR);
            this.add(this.northPanel, BorderLayout.NORTH);
            this.add(this.southPanel, BorderLayout.SOUTH);
            this.setPreferredSize(TAKEN_PIECES_DIMENSION);
    }

    public void redo(final MoveLog moveLog) {
        this.southPanel.removeAll();
        this.northPanel.removeAll();

        final List<Piece> whiteTakenPieces = new ArrayList<>();
        final List<Piece> blackTakenPieces = new ArrayList<>();

        for (final Move move : moveLog.getMoves()) {
            if (move.isAttack()) {
                final Piece takenPiece = move.getAttackedPiece();
                if (takenPiece.getPieceAlliance().isWhite()) {
                    whiteTakenPieces.add(takenPiece);
                } else if (takenPiece.getPieceAlliance().isBlack()) {
                    blackTakenPieces.add(takenPiece);
                } else {
                    throw new RuntimeException("Should not reach here!");
                }
            }
        }

        Collections.sort(whiteTakenPieces, new Comparator<Piece>() {
            @Override
            public int compare(Piece p1, Piece p2) {
                return Ints.compare(p1.getPieceValue(), p2.getPieceValue());
            }
        });

        Collections.sort(blackTakenPieces, new Comparator<Piece>() {
            @Override
            public int compare(Piece p1, Piece p2) {
                return Ints.compare(p1.getPieceValue(), p2.getPieceValue());
            }
        });

        for (final Piece takenPiece : whiteTakenPieces) {
            try {
                final BufferedImage pieceImage = ImageIO.read(new File("./assets/pieces/Matte/" + takenPiece.getPieceAlliance().toString().charAt(0) + takenPiece.toString().charAt(0) + ".png"));
                final ImageIcon pieceIcon = new ImageIcon(pieceImage);
                final JLabel imageLabel = new JLabel(pieceIcon);
                this.southPanel.add(imageLabel);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        for (final Piece takenPiece : blackTakenPieces) {
            try {
                final BufferedImage pieceImage = ImageIO.read(new File("./assets/pieces/Matte/" + takenPiece.getPieceAlliance().toString().charAt(0) + takenPiece.toString().charAt(0) + ".png"));
                final ImageIcon pieceIcon = new ImageIcon(pieceImage);
                final JLabel pieceImageLabel = new JLabel(pieceIcon);
                this.northPanel.add(pieceImageLabel);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        validate();
    }

}
