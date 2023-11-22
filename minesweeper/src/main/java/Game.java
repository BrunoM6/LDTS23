import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Board board;
    public Game() throws IOException {
        int col, row, mines;
        col = 40;
        row = 40;
        mines = 10;
        TerminalSize terminalSize = new TerminalSize(col, row);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();
        screen.doResizeIfNecessary();
        board = new Board(col,row,mines);
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
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
