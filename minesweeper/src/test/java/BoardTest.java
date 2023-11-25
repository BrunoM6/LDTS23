import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void BoardInitializationTest() {
        Board board = new Board(5, 5, 5);

        assertEquals(5, board.getWidth());
        assertEquals(5, board.getHeight());
    }

    @Test
    public void CellInitializationTest() {
        Board board = new Board(5, 5, 5);

        for (int row = 0; row < board.getHeight(); row++) {
            for (int col = 0; col < board.getWidth(); col++) {
                assertNotNull(board.getCell(row, col));
            }
        }
    }

    @Test
    public void MinePlacementTest() {
        int width = 5;
        int height = 5;
        int numMines = 5;

        Board board = new Board(width, height, numMines);

        int mineCount = 0;
        for (int row = 0; row < board.getHeight(); row++) {
            for (int col = 0; col < board.getWidth(); col++) {
                if (board.getCell(row, col).isMine()) {
                    mineCount++;
                }
            }
        }

        assertEquals(numMines, mineCount);
    }

    @Test
    public void testAdjacentMinesCount() {
        int width = 2;
        int height = 3;
        Cell[][] mockGrid = {
                {new Cell(false, 0), new Cell(true, 0)},
                {new Cell(true, 0), new Cell(false, 0)},
                {new Cell(false, 0), new Cell(true, 0)}
        };
        Board board = new Board(mockGrid,width,height);


        assertEquals(0, board.getCell(0,1).getAdjacentMines());
        assertEquals(3, board.getCell(1,1).getAdjacentMines());
        assertEquals(2, board.getCell(2,0).getAdjacentMines());
    }
}
