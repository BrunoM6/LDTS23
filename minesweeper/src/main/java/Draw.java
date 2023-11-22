import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Draw {
    private  Board board;
    private  Screen screen;
    public Draw(Board board, Screen screen) {
        this.board = board;
        this.screen = screen;
    }
    private void drawCell(Cell cell, int row, int col) {
        char displayChar = 'O';
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

    public void drawBoard() {
        for (int row = 0; row < board.getHeight(); row++) {
            for (int col = 0; col < board.getWidth(); col++) {
                drawCell(board.getCell(row, col), row, col);
            }
        }
    }
}




