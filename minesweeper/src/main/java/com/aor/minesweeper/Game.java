package com.aor.minesweeper;

import com.aor.minesweeper.gui.Draw;
import com.aor.minesweeper.model.game.board.Board;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
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

public class Game {
    private final Screen screen;
    private final Board board;
    
    public Game() throws IOException, URISyntaxException, FontFormatException {
        int col, row, mines;
        col = 40;
        row = 40;
        mines = 10;
        board = new Board(15,15,mines);
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(col, row, fontConfig);
        screen = createScreen(terminal);
    }
    private Screen createScreen(Terminal terminal) throws IOException{
        final Screen screen1;
        screen1 = new TerminalScreen(terminal);
        screen1.startScreen();
        screen1.doResizeIfNecessary();
        return screen1;
    }
    private Terminal createTerminal(int col,int row ,AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(col, row);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
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
    private void draw() throws IOException {
        screen.clear();
        Draw draw = new Draw(board,screen);
        draw.drawBoard();
        screen.refresh();
    }
    public void run() throws IOException {
        boolean run = true;
        while(run){
            draw();
            KeyStroke key = screen.readInput();
            if(key.getKeyType() == KeyType.EOF)run = false;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
