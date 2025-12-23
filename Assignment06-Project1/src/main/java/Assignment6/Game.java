package Assignment6;

/**
 * Manages the main Tic-Tac-Toe game logic and flow
 */
public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private final GameController gameController;

    /**
     * Constructs a new Tic-Tac-Toe game
     * 
     * @param player1 - first player
     * @param player2 - second player
     */
    public Game(Player player1, Player player2) {

        this.player1 = player1;
        this.player2 = player2;
        this.gameController = new GameController();
        initializeGame();

    }

    /**
     * Initializes a new game with fresh board
     */
    private void initializeGame() {

        board = new Board();
        currentPlayer = player1;

    }

    /**
     * Starts the main game loop 
     */
    public void start() {

        gameController.runGameLoop(this);

    }

    /**
     * Resets the game for a new round
     */
    public void resetGame() {

        initializeGame();

    }

    /**
     * Switches turn between players
     */
    public void switchTurn() {

        if (currentPlayer == player1) {

            currentPlayer = player2;

        } else {

            currentPlayer = player1;

        }
        
    }

    /**
     * Gets the player who currently has the turn
     * 
     * @return the current Player object whose turn it is
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Gets the game board for external access
     * 
     * @return the Board object representing the game state
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Gets Player 1 info
     * 
     * @return the first Player object
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Gets Player 2 info
     * 
     * @return the second Player object
     */
    public Player getPlayer2() {
        return player2;
    }   
}
