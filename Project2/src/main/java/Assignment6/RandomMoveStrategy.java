package Assignment6;

import java.util.Random;

/**
 * Computer strategy that makes random valid moves
 */
public class RandomMoveStrategy implements MoveStrategy {

    private final Random random;

    /**
     * Creates a new random move strategy
     * 
     * @param random - random num generator
     */
    public RandomMoveStrategy(Random random) {

        this.random = random;

    }

    /**
     * Generates a random valid move
     * 
     * @param board - the current board
     * @return array representing a valid move
     */
    public int[] generateMove(Board board) {

        int size = board.getSize();
        int row,col;

        do {

            row = random.nextInt(size);
            col = random.nextInt(size);

        } while (board.getCell(row, col) != '-');

        System.out.printf("Computer chooses: %d %d%n", row + 1, col + 1);
        return new int[]{row, col};
        
    }

}