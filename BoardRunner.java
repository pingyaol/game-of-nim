import java.util.Random; 
import java.util.Scanner;

public class BoardRunner {
    private boolean hasEnded; 
    private int totalPieces; 

    public BoardRunner() {
        Board board = new Board(); 
        Player player1 = new Player("player 1"); 
        totalPieces = board.getPieces(); 
    }

    public void findWinner() {
        hasEnded = false; 
        Scanner input = new Scanner(System.in);

        while (true) {
            // finish play function 
            System.out.println("Welcome to the Game of Nim! "); 
            Syste.out.println("How many game pieces would you like to take? "); 
            int guess = input.nextLine(); 

            player1.addPieces(guess); 
        }
    }

}
