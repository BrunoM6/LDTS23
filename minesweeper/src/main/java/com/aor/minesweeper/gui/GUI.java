package com.aor.minesweeper.gui;

import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.Cell;
import com.aor.minesweeper.model.game.elements.Clock;

import java.io.IOException;

public interface GUI {

    void drawCell(Cell cell, int row, int col);

    void drawBoard(Board board);

    void drawClock(Clock clock, int x, int y);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

}
