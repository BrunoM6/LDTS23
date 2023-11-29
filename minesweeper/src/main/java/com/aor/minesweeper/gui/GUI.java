package com.aor.minesweeper.gui;

import com.aor.minesweeper.model.game.elements.Cell;

import java.io.IOException;

public interface GUI {

    void drawCell(Cell cell, int row, int col);

    void drawBoard();
    void drawClock();
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

}
