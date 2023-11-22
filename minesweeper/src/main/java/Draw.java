import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Draw {
    private final Board game;
    private final Screen screen;

    public Draw(Board game, Screen screen) {
        this.game = game;
        this.screen = screen;
    }
    public void drawGame() {
        for (int row = 0; row < game.getHeight(); row++) {
            for (int col = 0; col < game.getWidth(); col++) {
                drawCell(game.getCell(row, col), row, col);
            }
        }
    }

    private void drawCell(Cell cell, int row, int col) {
        char displayChar = ' ';
        if (cell.isRevealed()) {
            if (cell.isMine()) {
                displayChar = '*';
            } else {
                displayChar = (char) ('0' + cell.getAdjacentMines());
            }
        } else if (cell.isFlagged()) {
            displayChar = 'F';
        }
        screen.setCharacter(col, row, new TextCharacter(displayChar));
    }
}
