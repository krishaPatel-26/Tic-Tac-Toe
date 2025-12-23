package Assignment6;

import java.util.Scanner;

/**
 * Main class for extended N×N Tic-Tac-Toe game
 */
public class ExtendedMain {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Tic-Tac-Toe Game ===");

        int boardSize = getValidInput(scanner, "Enter board size (3,20): ", 3, 20);

        int winCondition = getValidInput(scanner, String.format("Enter win condition (3-%d): ", boardSize), 3, boardSize);

        System.out.println("Select game mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer (Random)");
        System.out.println("3. Human vs Computer (Smart)");
        System.out.println("4. Computer vs Computer");
        System.out.print("Enter choice (1-4):");

        int choice = scanner.nextInt();
        scanner.nextLine();

        Player player1, player2;

        switch (choice) {

            case 1:

                player1 = new HumanPlayer('X', "Human Player 1");
                player2 = new HumanPlayer('O', "Human Player 2");
                break;

            case 2:

                player1 = new HumanPlayer('X', "Human Player");
                player2 = new ComputerPlayer('O', "Computer (Random)", 
                                            new RandomMoveStrategy(new java.util.Random()));
                break;

            case 3:

                player1 = new HumanPlayer('X', "Human Player");
                player2 = new ComputerPlayer('O', "Computer (Smart)", 
                                            new SmartMoveStrategy(new java.util.Random(), 'O'));
                break;
                
            case 4:

                player1 = new ComputerPlayer('X', "Computer 1", 
                                            new RandomMoveStrategy(new java.util.Random()));
                player2 = new ComputerPlayer('O', "Computer 2", 
                                            new RandomMoveStrategy(new java.util.Random()));
                break;

            default:

                System.out.println("Invalid choice. Defaulting to Human vs Human.");
                player1 = new HumanPlayer('X', "Human Player 1");
                player2 = new HumanPlayer('O', "Human Player 2");

        }

        ExtendedGame extendedGame = new ExtendedGame(boardSize, winCondition, player1, player2);
        extendedGame.start();

        scanner.close();

    }

    private static int getValidInput(Scanner scanner, String prompt, int min, int max) {

        int value;
        while (true) { 
            
            System.out.print(prompt);
            try {
                
                value = scanner.nextInt();
                if (value>= min && value <= max) {

                    scanner.nextLine();
                    return value;

                } else {

                    System.out.printf("Please enter a number between %d and %d.%n", min, max);

                }
            } catch (Exception e) {

                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}