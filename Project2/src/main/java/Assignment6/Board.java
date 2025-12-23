package Assignment6;

/**
 * Represents a Tic-Tac-Toe game board
 * Manages the game grid, displays, and checks for wins
 */
public class Board {

    private static final int DEFAULT_SIZE = 3;
    private char[][] grid;
    private final int size;

    /**
     * Creates a new 3x3 Tic-Tac-Toe board
     */
    public Board() {

        this(DEFAULT_SIZE);
        
    }

    /**
     * Creates a new board with custom size
     * 
     * @param size - the size of the board (num of rows and cols)
     */
    public Board(int size) {

        this.size = size;
        this.grid = new char[size][size];
        initializeBoard();

    }

    /**
     * Fill board with empty cells
     */
    private void initializeBoard() {

        for(int r = 0; r < size; r++) {

            for(int c = 0; c < size; c++) {

                grid[r][c] = '-';

            }
        }
    }

    /**
     * Displays the current board in the console
     */
    public void display() {

        System.out.println("Board:");

        for(int r = 0; r < size; r++) {

            for(int c = 0; c < size; c++) {

                System.out.print(grid[r][c] + " ");

            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Places a symbol on the board if the cell is empty
     * 
     * @param row - the row position
     * @param col - the col position
     * @param symbol - the player's symbol ('X' or 'O')
     * @return true if move was successful, false if invalid
     */
    public boolean placeMark(int row, int col, char symbol) {

        if (!isValidPosition(row, col) || !isEmptyCell(row, col)) {
            return false;
        }
        grid[row][col] = symbol;
        return true;
        
    }

    /**
     * Checks if the board is completely filled (no empty cells)
     * 
     * @return true if all cells are occupied, false otherwise
     */
    public boolean isFull() {

        for( int r = 0; r < size; r++) {

            for (int c = 0; c < size; c++) {

                if (grid[r][c] == '-') {

                    return false;

                }
            }
        }
        return true;
    }

    /**
     * Checks if the specified player has won the game
     * 
     * @param symbol - the player's symbol to check for win
     * @return true if the player has three in a row, false otherwise
     */
    public boolean checkWin(char symbol) {

        return checkRows(symbol) || checkCols(symbol) || checkDiagonals(symbol);
    }

    /**
     * Check all rows for win
     * 
     * @param symbol - the player's symbol
     */
    private boolean checkRows(char symbol) {

                for (int r = 0; r < size; r++) {
            
            if (grid[r][0] == symbol && grid[r][1] == symbol && grid[r][2] == symbol) {
                
                return true;

            }

        }
        return false;
    }

   
    private boolean checkCols(char symbol) {

        for (int c = 0; c < size; c++) {
            
            if (grid[0][c] == symbol && grid[1][c] == symbol && grid[2][c] == symbol) {
                
                return true;

            }
            
        }
        return false;

    }

    /**
     * Check diagonals in both ways
     * 
     * @param symbol - the player's symbol
     */
    private boolean checkDiagonals(char symbol) {
     
        return (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
               (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol);

    }

    /**
     * Checks if the game has ended
     * 
     * @return true if game has ended, false otherwise
     */
    public boolean isGameOver() {
        
        return checkWin('X') || checkWin('O') || isFull();

    }

    /**
     * Gets the winner of the game
     * 
     * @return 'X' if X won, 'O' if O won, '-' if no winner (draw)
     */
    public char getWinner() {

        if (checkWin('X')) {

            return 'X';

        }

        if (checkWin('O')) {

            return 'O';
            
        }
        return '-';
    }

    /**
     * Check if position is within board boundaries
     * 
     * @param row - the row position
     * @param col - the col position
     * @return true if position is valid, false otherwise
     */
    private boolean isValidPosition(int row, int col) {

        return row >= 0 && row < size && col >=0 && col < size;

    }

    /**
     * Check if cell is empty
     * 
     * @param row - the row position
     * @param col - the col position
     * @return true if cell is empty, false otherwise
     */
    private boolean isEmptyCell(int row, int col) {

        return grid[row][col] == '-';

    }

    /**
     * Gets the symbol at the specified position
     * 
     * @param row - the row position
     * @param col - the col position
     * @return the character at the specified position, or '?' for invalid positions
     */
    public char getCell(int row, int col) {

        if (!isValidPosition(row, col)) {

            return '?';

        }
        return grid[row][col];
    }

    /**
     * Gets the size of the board
     * 
     * @return the size of the board
     */
    public int getSize() {
        return size;
    }
    
}
