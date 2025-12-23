package Assignment6;

/**
 * Represents a human player that gets moves from user input
 */
public class HumanPlayer extends Player {

    private final InputHandler inputHandler;

    /**
     * Constructs a new human player
     * 
     * @param symbol - the player's symbol ('X' or 'O')
     * @param name - the player's name
     */
    public HumanPlayer(char symbol, String name) {

        super(symbol, name);
        this.inputHandler = new InputHandler();

    }

    /**
     * Gets move from human player via console input
     * 
     * @param board - the current game board
     * @return an array representing the chosen move
     */
    @Override
    public int[] getMove(Board board) {
        
        displayTurnInfo();
        return inputHandler.getValidMove(board);
    
    }

    /**
     * Display computer's turn info
     */
    private void displayTurnInfo() {

        System.out.printf("%s's turn (%c)%n", getName(), getSymbol());

    }
}