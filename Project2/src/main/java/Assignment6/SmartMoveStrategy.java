package Assignment6;

import java.util.Random;

/**
 * Smart computer strategy that uses multiple tactics
 * 1. Win if possible
 * 2. Block opponent if they can win
 * 3. Take center if available
 * 4. Take corners if available
 * 5. Otherwise make random move
 */
public class SmartMoveStrategy implements MoveStrategy {

    private final Random random;
    private final char computerSymbol;
    private final char opponentSymbol;

    public SmartMoveStrategy(Random random, char computerSymbol) {

        this.random = random;
        this.computerSymbol = computerSymbol;
        if (computerSymbol == 'X') {

            this.opponentSymbol = 'O';

        } else {

            this.opponentSymbol = 'X';

        }

    }

    @Override
    public int[] generateMove(Board board) {
        
        // 1. Check for winning move
        int[] winningMove = findWinningMove(board, computerSymbol);
        if (winningMove != null) {

            System.out.println("Smart move: Winning!");
            return winningMove;

        }
        
        // 2. Check for blocking move
        int[] blockingMove = findWinningMove(board, opponentSymbol);
        if (blockingMove != null) {

            System.out.println("Smart move: Blocking!");
            return blockingMove;

        }
        
        // 3. Take center if available
        if (board.getCell(1, 1) == '-') {

            System.out.println("Smart move: Taking center!");
            return new int[]{1, 1};
            
        }
        
        // 4. Take corners if available
        int[] cornerMove = takeCorner(board);
        if (cornerMove != null) {

            System.out.println("Smart move: Taking corner!");
            return cornerMove;

        }
        
        // 5. Otherwise make random move
        System.out.println("Smart move: Random choice");
        return makeRandomMove(board);

    }

    private int[] findWinningMove(Board board, char symbol) {
        int size = board.getSize();
        
        // Check all rows, columns, and diagonals for two in a row
        for (int i = 0; i < size; i++) {

            // Check rows
            int[] rowMove = checkLine(board, symbol, i, 0, 0, 1);
            if (rowMove != null) {

                return rowMove;

            }
            
            // Check columns
            int[] colMove = checkLine(board, symbol, 0, i, 1, 0);
            if (colMove != null) {
                
                return colMove;

            }
        }
        
        // Check diagonals
        int[] diag1 = checkLine(board, symbol, 0, 0, 1, 1);
        if (diag1 != null) {
            
            return diag1;

        }
        
        int[] diag2 = checkLine(board, symbol, 0, 2, 1, -1);
        if (diag2 != null) {
            
            return diag2;

        }
        return null;
        
    }

    private int[] checkLine(Board board, char symbol, int startRow, int startCol, int rowStep, int colStep) {

        int count = 0;
        int emptyRow = -1, emptyCol = -1;
        
        for (int i = 0; i < 3; i++) {

            int row = startRow + i * rowStep;
            int col = startCol + i * colStep;
            char cell = board.getCell(row, col);
            
            if (cell == symbol) {

                count++;

            } else if (cell == '-') {

                emptyRow = row;
                emptyCol = col;

            } else {
                
                return null;

            }
        }
        
        if (count == 2 && emptyRow != -1) {

            return new int[]{emptyRow, emptyCol};

        }
        
        return null;
    }

    private int[] takeCorner(Board board) {

        int[][] corners = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};

        for (int[] corner : corners) {

            if (board.getCell(corner[0], corner[1]) == '-') {

                return corner;

            }

        }
        
        return null;
    }

    private int[] makeRandomMove(Board board) {

        int size = board.getSize();
        int row, col;
        
        do {

            row = random.nextInt(size);
            col = random.nextInt(size);
            
        } while (board.getCell(row, col) != '-');
        
        return new int[]{row, col};
    }
}