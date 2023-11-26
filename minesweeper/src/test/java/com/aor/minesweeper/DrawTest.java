package com.aor.minesweeper;

import com.aor.minesweeper.gui.Draw;
import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.Cell;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        // Arrange the object cell.
        Cell mockCell = Mockito.mock(Cell.class);

        // Create a mock Board (1x1) with one cell.
        when(mockBoard.getHeight()).thenReturn(1);
        when(mockBoard.getWidth()).thenReturn(1);
        when(mockBoard.getCell(0, 0)).thenReturn(mockCell);

        // Create a mock Cell that is revealed and has 0 adjacent mines.
        when(mockCell.isRevealed()).thenReturn(true);
        when(mockCell.isMine()).thenReturn(false);
        when(mockCell.getAdjacentMines()).thenReturn(5);

        // Create a new draw object with the mocks.
        Draw draw = new Draw(mockBoard, mockScreen);

        //Act by drawing the board.
        draw.drawBoard();

        // Assert if it was correctly drawn.
        verify(mockScreen).setCharacter(eq(0), eq(0), any(TextCharacter.class));
    }

    @Test
    public void testDrawCell() {
        // Arrange the object cell.
        Cell mockCell = Mockito.mock(Cell.class);

        // Mock cell, revealed with 0 adjacent mines.
        when(mockCell.isRevealed()).thenReturn(true);
        when(mockCell.isMine()).thenReturn(false);
        when(mockCell.getAdjacentMines()).thenReturn(3);

        // Create the object draw.
        Draw draw = new Draw(mockBoard, mockScreen);

        // Act by drawing the cell.
        draw.drawCell(mockCell, 1, 1);
        verify(mockScreen).setCharacter(1, 1, new TextCharacter('3'));
    }
}
