package Assignment6;

import java.util.Random;
import java.util.Scanner;

/**
 * Main class to launch the Tic-Tac-Toe game with different player types
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;
        
        while (keepPlaying) {

            System.out.println("=== Tic-Tac-Toe Game ===");
            System.out.println("Select game mode:");
            System.out.println("1. Human vs Human");
            System.out.println("2. Human vs Computer (Random)");
            System.out.println("3. Human vs Computer (Smart)");
            System.out.println("4. Computer (Random) vs Computer (Smart)");
            System.out.println("5. Computer (Smart) vs Computer (Smart)");
            System.out.print("Enter choice (1-5):");
        
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            Player player1, player2;
            Random random = new Random();
            
            switch (choice) {
                case 1:
                    player1 = new HumanPlayer('X', "Human Player 1");
                    player2 = new HumanPlayer('O', "Human Player 2");
                    break;
                case 2:
                    player1 = new HumanPlayer('X', "Human Player");
                    player2 = new ComputerPlayer('O', "Computer (Random)", new RandomMoveStrategy(random));
                    break;
                case 3:
                    player1 = new HumanPlayer('X', "Human Player");
                    player2 = new ComputerPlayer('O', "Computer (Smart)", new SmartMoveStrategy(random, 'O'));
                    break;
                case 4:
                    player1 = new ComputerPlayer('X', "Computer (Random)", new RandomMoveStrategy(random));
                    player2 = new ComputerPlayer('O', "Computer (Smart)", new SmartMoveStrategy(random, 'O'));
                    break;
                case 5:
                    player1 = new ComputerPlayer('X', "Smart Computer 1", new SmartMoveStrategy(random, 'X'));
                    player2 = new ComputerPlayer('O', "Smart Computer 2", new SmartMoveStrategy(random, 'O'));
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Human vs Human.");
                    player1 = new HumanPlayer('X', "Human Player 1");
                    player2 = new HumanPlayer('O', "Human Player 2");
            }
    
    
            Game game = new Game(player1, player2);
            game.start();
            
            System.out.print("\nWould you like to return to main menu? (y/n):");

            String ans = scanner.nextLine().trim().toLowerCase();
            keepPlaying = ans.equals("y") || ans.equals("yes");

        }

        System.out.println("Goodbye!!!");
        scanner.close();

    }
}