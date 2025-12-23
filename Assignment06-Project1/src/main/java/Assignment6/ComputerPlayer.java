
package Assignment6;

/**
 * Represents a computer player that makes random moves
 */
public class ComputerPlayer extends Player {

    private final MoveStrategy moveStrategy;

    /**
     * Constructs a new computer player
     * 
     * @param symbol - the player's symbol ('X' or 'O')
     * @param name - the computer's name
     */
    public ComputerPlayer(char symbol, String name, MoveStrategy strategy) {

        super(symbol, name);
        this.moveStrategy = strategy;

    }

    /**
     * Generates a random valid move on the board
     * 
     * @param board - the current game board
     * @return an array representing the chosen move
     */
    @Override
    public int[] getMove(Board board) {

        displayTurnInfo();
        return moveStrategy.generateMove(board);

    }

    /**
     * Display computer's turn info
     */
    private void displayTurnInfo() {

        System.out.printf("%s's turn (%c)%n", getName(), getSymbol());
        System.out.println("Computer is thinking...");

    }
}