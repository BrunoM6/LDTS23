package com.aor.minesweeper.gui;

import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.Cell;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private final Board board;
    public LanternaGUI(Screen screen,Board board) {
        this.screen = screen;
        this.board = board;
    }
    public LanternaGUI(int width, int height,Board board) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.board = board;
        this.screen = createScreen(terminal);
    }
    private Screen createScreen(Terminal terminal) throws IOException{
        final Screen screen1;
        screen1 = new TerminalScreen(terminal);
        screen1.setCursorPosition(null);
        screen1.startScreen();
        screen1.doResizeIfNecessary();
        return screen1;
    }
    private Terminal createTerminal(int col, int row , AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(col, row);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }
    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }
    @Override
    public void drawCell(Cell cell, int row, int col) {
        char displayChar = '-';
        if (cell.isRevealed()) {
            if (cell.isMine()) {
                displayChar = '*';
            } else {
                displayChar = (char) ('0' + cell.getAdjacentMines());
            }
        } else if (cell.isFlagged()) {
            displayChar = 'F';
        }
        screen.setCharacter(col + screen.getTerminalSize().getColumns()/2 - board.getWidth()/2, row + screen.getTerminalSize().getRows()/2 - board.getHeight()/2, new TextCharacter(displayChar));
    }

    @Override
    public void drawBoard() {
        for (int row = 0 ; row < board.getHeight(); row++) {
            for (int col = 0; col < board.getWidth(); col++) {
                drawCell(board.getCell(row, col), row, col);
            }
        }
    }
    @Override
    public void drawClock() {

    }
    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
