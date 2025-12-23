package Assignment6;

import java.util.Scanner;

/**
 * Extended game for N×N grid with custom win condition
 * Reuses the original Game class through composition
 */
public class ExtendedGame {

    private final int boardSize;
    private final int winCondition;
    private final Game game;
    private final Scanner scanner;

    public ExtendedGame(int boardSize, int winCondition, Player player1, Player player2) {

        this.boardSize = boardSize;
        this.winCondition = winCondition;
        this.scanner = new Scanner(System.in);

        ExtendedBoard extendedBoard = new ExtendedBoard(boardSize, winCondition);

        this.game = createGameWithCustomBoard(player1,player2,extendedBoard);

    }

    private Game createGameWithCustomBoard(Player player1, Player player2, ExtendedBoard board) {

        try {
            
            Game game = new Game(player1, player2);

            java.lang.reflect.Field boardField = Game.class.getDeclaredField("board");

            boardField.setAccessible(true);
            boardField.set(game,board);

            return game;

        } catch (Exception e) {

            System.err.println("Error creating extended game: " + e.getMessage());
            return new Game(player1, player2);
        }
    }

    public void start() {

        System.out.printf("=== Tic-Tac-Toe (%dx%d board, %d in a row to win) ===%n", 
                     boardSize, boardSize, winCondition);
        game.start();
        scanner.close();

    }

    public Game getGame() {

        return game;
        
    }

}