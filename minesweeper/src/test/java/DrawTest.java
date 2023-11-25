import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawTest {

    private Board mockBoard;
    private Screen mockScreen;

    @BeforeEach
    public void setUp() {
        // Mock the Board and Screen
        mockBoard = Mockito.mock(Board.class);
        mockScreen = Mockito.mock(Screen.class);
    }

    @Test
    public void testDrawBoard() {

    }

    @Test
    public void testDrawCell() {
        Cell mockCell = Mockito.mock(Cell.class);
        Mockito.when(mockCell.isRevealed()).thenReturn(true);
        Mockito.when(mockCell.isMine()).thenReturn(false);
        Mockito.when(mockCell.getAdjacentMines()).thenReturn(3);
        Draw draw = new Draw(mockBoard, mockScreen);
        draw.drawCell(mockCell, 1, 1);
        Mockito.verify(mockScreen).setCharacter(1, 1, new TextCharacter('3'));
    }
}
