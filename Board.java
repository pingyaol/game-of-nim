import java.lang.Math;
import java.util.Scanner;

public class Board {
    private static int totalPieces = ((int) (Math.random() * 40))+11;
    private static int highestGuess;
    private static Player player1;
    private static Player player2;
    public static Player currentPlayer;
    private static Scanner in = new Scanner (System.in);

    public static void createPieces() {
        totalPieces = (int) ((Math.random() * (41)) + 10); 
        System.out.println("Current number of pieces: " + totalPieces);
    }

    public static void removePieces(int x) {
        totalPieces -=x;
    }

    public static int getPieces() {
        return totalPieces; 
    }
    public static int getmaxhighestGuess() {
        return highestGuess; 
    }
    public static void sethighestGuess() {
        highestGuess = (int) (totalPieces / 2);
        if (totalPieces == 1) {
            highestGuess = 1;
        }
    }  
    public static void switchTurn () {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    
    }
    public static void play (){
        Scanner in = new Scanner (System.in);
        sethighestGuess();
        System.out.println ("There are " + totalPieces+ " pieces to start with");
        currentPlayer = player1;
        boolean play = true; 

        // repeat these actions till the pile reaches 0 
        while (totalPieces > 0 && play) {
            System.out.println(currentPlayer.getName()+ " enter in how many pieces you want to take, the max number of pieces you can take is " + getmaxhighestGuess());
            int guess = in.nextInt();
            totalPieces -= guess;
            System.out.println ("There are " + totalPieces + " pieces left");
            if (totalPieces == 0) {
            System.out.println(currentPlayer.getName() + " has lost");
            switchTurn();
            System.out.println(currentPlayer.getName() + " has won!!");
            }
            sethighestGuess();
            switchTurn();

            if (totalPieces == 0) {
                System.out.println("Would you like to play again? (yes/no)"); 
                String choice = in.next(); 
                if (choice.equals("yes")) {
                    createPieces(); 
                    sethighestGuess();
                    play(); 
                } else {
                    play = false; 
                    System.out.println("Thank you for playing! Bye! ");
                }
            }
        }
        
    }

    public static void setPlayers () {
        System.out.println("Player 1, enter your name!");
        player1 = new Player(in.nextLine());
        System.out.println("Player 2, enter your name!");
        player2 = new Player(in.nextLine());
    }
}
