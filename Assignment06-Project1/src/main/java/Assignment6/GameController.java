package Assignment6;

import java.util.Scanner;

/**
 * Controls game flow and user interactions
 */
public class GameController {

    private final Scanner scanner;

    /**
     * Creates a new game controller
     */
    public GameController() {

        this.scanner = new Scanner(System.in);

    }

    /**
     * Runs the main game loop
     * 
     * @param game - the game to control
     */
    public void runGameLoop(Game game) {

        boolean playAgain = true;
        
        while (playAgain) {

            playSingleGame(game);
            playAgain = askForRestart();

            if (playAgain) {

                game.resetGame();

            }
        }
        
        System.out.println("Thanks for playing Tic-Tac-Toe!");
    }

    /**
     * Plays one complete game from start to finish
     * 
     * @param game - the game to control
     */
    private void playSingleGame(Game game) {

        displayGameStart(game.getPlayer1(), game.getPlayer2());
        
        while (true) {

            game.getBoard().display();
            playTurn(game);
            
            if (isGameOver(game.getBoard())) {

                game.getBoard().display();
                announceResult(game.getBoard(), game.getPlayer1(), game.getPlayer2());
                break;

            }
            
            game.switchTurn();

        }
    }

    /**
     * Handles one player's turn
     * 
     * @param game - the game to control
     */
    private void playTurn(Game game) {

        boolean validMove = false;
        while (!validMove) {

            int[] move = game.getCurrentPlayer().getMove(game.getBoard());
            validMove = game.getBoard().placeMark(move[0], move[1], 
                                                game.getCurrentPlayer().getSymbol());
            
            if (!validMove) {

                System.out.println("Invalid move! Try again.");

            }

        }
    }

    /**
     * Checks if game has ended
     * 
     * @param board - the game board
     * @return true if game is over, false otherwise
     */
    private boolean isGameOver(Board board) {

        return board.isGameOver();

    }

    /**
     * Announces the game result
     * 
     * @param board - the game board
     * @param player1 - the first player
     * @param player2 - the second player
     */
    private void announceResult(Board board, Player player1, Player player2) {

        char winner = board.getWinner();
        Player winnerPlayer;

        if (winner == 'X') {

            if (player1.getSymbol() == 'X') {

                winnerPlayer = player1;

            } else {

                winnerPlayer = player2;
            }
            System.out.println("🎉 " + winnerPlayer.getName() + " wins! 🎉");

        } else if (winner == 'O') {

            if (player1.getSymbol() == 'O') {

                winnerPlayer = player1;

            } else {

                winnerPlayer = player2;
            }

            System.out.println("🎉 " + winnerPlayer.getName() + " wins! 🎉");
        } else {

            System.out.println("Game ended in a draw!");

        }
    }

    /**
     * Displays game start info
     * 
     * @param player1 - the first player
     * @param player2 - the second player
     */
    private void displayGameStart(Player player1, Player player2) {

        System.out.println("\n===== Tic-Tac-Toe Game =====");
        System.out.println(player1 + " vs " + player2);

    }

    /**
     * Asks if player wants to play again
     */
    private boolean askForRestart() {

        System.out.print("\nWould you like to play again? (y/n):");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y") || response.equals("yes");

    }
}