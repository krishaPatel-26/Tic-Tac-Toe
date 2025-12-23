package Assignment6;

import java.util.Scanner;

/**
 * Handles all user input validation separately
 */
public class InputHandler {

    private final Scanner scanner;

    /**
     * Creates a new input handler
     */
    public InputHandler() {

        this.scanner = new Scanner(System.in);

    }
    
    /**
     * Gets a valid move from the user
     * 
     * @param board - the current game board
     * @return array representing a valid move
     */
    public int[] getValidMove(Board board) {

        while (true) {
            
            try {

                System.out.print("Enter row and column (1-3, e.g., '1 2' for row 1, column 2):");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                if (isValidMove(row - 1, col - 1, board)) {

                    return new int[]{row - 1, col - 1};

                } else {

                    System.out.println("Invalid move! Cell occupied or out of bounds.");

                }

            } catch (Exception e) {

                System.out.println("Invalid input! Please enter two numbers between 1 and 3.");
                scanner.nextLine(); 

            }
        }
    }

    /**
     * Check is move is valid
     * 
     * @param row - the row position
     * @param col - the col position
     * @param board - the game board
     * @return true if move is valid, false otherwise
     */
    private boolean isValidMove(int row, int col, Board board) {
        return row >= 0 && row < board.getSize() && 
               col >= 0 && col < board.getSize() && 
               board.getCell(row, col) == '-';
    }

}