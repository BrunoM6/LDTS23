public class Board {
    private Cell[][] grid;
    private final int width;
    private final int height;
    private final int numMines;

    public Board(int width, int height, int numMines) {
        this.width = width;
        this.height = height;
        this.numMines = numMines;
        this.grid = new Cell[height][width];
        initializeBoard();
        placeMines();
        calculateAdjacentMines();
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    private void initializeBoard() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = new Cell(); // Initialize with default Cell
            }
        }
    }

    private void placeMines() {
        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int row = (int) (Math.random() * height);
            int col = (int) (Math.random() * width);

            if (!grid[row][col].isMine()) {
                grid[row][col].setMine(true);
                minesPlaced++;
            }
        }
    }

    private void calculateAdjacentMines() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (!grid[row][col].isMine()) {
                    int count = countAdjacentMines(row, col);
                    grid[row][col].setAdjacentMines(count);
                }
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isWithinGrid(row + i, col + j) && grid[row + i][col + j].isMine()) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isWithinGrid(int row, int col) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }
    public Cell getCell(int row, int col) {
        return grid[row][col];
    }
}