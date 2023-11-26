package com.aor.minesweeper.model.game.elements;
public class Cell {
    private boolean isMine;
    private boolean isFlagged;
    private boolean isRevealed;
    private int adjacentMines;
    public Cell() {
        this.isMine = false;
        this.isRevealed = false;
        this.adjacentMines = 0;
        this.isFlagged = false;
    }
    public Cell(boolean isMine, int adjacentMines) {
        this.isMine = isMine;
        this.isRevealed = false;
        this.adjacentMines = adjacentMines;
    }
    public boolean isMine() {
        return isMine;
    }
    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }
    public boolean isRevealed() {
        return isRevealed;
    }
    public void setRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }
    public int getAdjacentMines() {
        return adjacentMines;
    }
    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }
    public boolean isFlagged() {
        return this.isFlagged;
    }
    public void setFlagged(boolean flag) {
        this.isFlagged = flag;
    }
}