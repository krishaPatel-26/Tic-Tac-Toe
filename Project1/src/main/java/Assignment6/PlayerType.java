package Assignment6;

/**
 * Defines the contract for all player types
 * Any class that implements this can play Tic-Tac-Toe
 */
public interface PlayerType {

    int[] getMove(Board board);
    char getSymbol();
    String getName();

}