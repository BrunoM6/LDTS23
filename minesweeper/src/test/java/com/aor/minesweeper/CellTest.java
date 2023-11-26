package com.aor.minesweeper;

import com.aor.minesweeper.model.game.elements.Cell;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testDefaultCellInitialization() {
        Cell cell = new Cell();

        assertFalse(cell.isMine());
        assertFalse(cell.isRevealed());
        assertEquals(0, cell.getAdjacentMines());
        assertFalse(cell.isFlagged());
    }

    @Test
    public void testCustomCellInitialization() {
        Cell cell = new Cell(true, 3);

        assertTrue(cell.isMine());
        assertFalse(cell.isRevealed());
        assertEquals(3, cell.getAdjacentMines());
        assertFalse(cell.isFlagged());
    }

    @Test
    public void testSetMine() {
        Cell cell = new Cell();

        assertFalse(cell.isMine());
        cell.setMine(true);
        assertTrue(cell.isMine());
    }

    @Test
    public void testSetRevealed() {
        Cell cell = new Cell();

        assertFalse(cell.isRevealed());
        cell.setRevealed(true);
        assertTrue(cell.isRevealed());
    }

    @Test
    public void testSetAdjacentMines() {
        Cell cell = new Cell();

        assertEquals(0, cell.getAdjacentMines());
        cell.setAdjacentMines(5);
        assertEquals(5, cell.getAdjacentMines());
    }

    @Test
    public void testSetFlagged() {
        Cell cell = new Cell();

        assertFalse(cell.isFlagged());
        cell.setFlagged(true);
        assertTrue(cell.isFlagged());
    }
}
