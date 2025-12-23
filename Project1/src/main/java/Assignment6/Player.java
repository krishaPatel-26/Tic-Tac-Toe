package Assignment6;

/**
 * Abstract base class representing a player in the Tic-Tac-Toe game.
 * Can be extended to create different player types
 */
public abstract class Player implements PlayerType {
    
    protected final char symbol;
    protected final String name;

    /**
     * Constructs a new player with the specified symbol and name
     * 
     * @param symbol - the player's marker symbol ('X' or 'O')
     * @param name - the player's display name
     */
    public Player(char symbol, String name) {
        
        this.symbol = symbol;
        this.name = name;

    }

    /**
     * Gets the player's Symbol
     * 
     * @return the character representing the player's marker ('X' or 'O')
     */
    @Override
    public char getSymbol() {
        return symbol;
    }

    /**
     * Gets the player's name
     * 
     * @return the player's display name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the player's next move
     * 
     * @param board - the current game board
     * @return an array representing the chosen move
     */
    @Override
    public abstract int[] getMove(Board board);

    /**
     * Provides a string representation of the player
     * 
     * @return String in format "Name (Symbol)"
     */
    @Override
    public String toString() {
        return name + " (" + symbol + ")"; 
    }
}
