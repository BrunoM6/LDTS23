package com.aor.minesweeper.viewer;

import com.aor.minesweeper.gui.LanternaGUI;
import com.aor.minesweeper.model.game.board.Board;

public class BoardViewer {
    public void draw(Board board, LanternaGUI gui) {
        gui.drawBoard(board);
    }
}