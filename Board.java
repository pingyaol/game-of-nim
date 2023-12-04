import java.lang.Math;
import java.util.Scanner;

public class Board {
    private static int totalPieces = ((int) (Math.random() * 40))+11;
    private static int highestGuess;
    private static Player player1;
    private static Player player2;
    public static Player currentPlayer;
    public static Player firstPlayer;
    public static Player secondPlayer;
    private static Scanner in = new Scanner (System.in);

    // methods to manage the functionality 
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
    public static boolean isHigher(String guess) {
        if (Integer.valueOf(guess) > highestGuess) {
            System.out.println("Sorry, your guess was over half the amount in the pile, please try again ");
            return true; 
        }
        return false; 
    }

    static boolean isNumber(String input1)
    {
        try {
            // checking valid integer using parseInt() method 
            // returns true to escape while loop 
            Integer.parseInt(input1);
                return true; 
        }
        catch (NumberFormatException e) {
            // repeats while loop 
            System.out.println(input1 + " is not a valid integer number, please enter another value "); 
            return false; 
        }
    }

    public static void play (){
        Scanner in = new Scanner (System.in);
        sethighestGuess();
        System.out.println ("There are " + totalPieces+ " pieces to start with");

        // starts the game with a random player 
        int whichPlayer = ((int) (Math.random() * 2))+1;
        if (whichPlayer == 1) {
            firstPlayer = player1;
            secondPlayer = player2; 
            currentPlayer = firstPlayer; 
        } else {
            firstPlayer = player2; 
            secondPlayer = player1; 
            currentPlayer = firstPlayer; 
        }
        
        // variable to manage replays 
        boolean play = true; 

        // repeat these actions till the pile reaches 0 
        while (totalPieces > 0 && play) {
            System.out.println(currentPlayer.getName()+ " enter in how many pieces you want to take, the max number of pieces you can take is " + getmaxhighestGuess());
            if (currentPlayer == player1) {
                String guess = in.nextLine();
                while (!isNumber(guess) || isHigher(guess)) {
                    guess = in.nextLine();
                }
                totalPieces -= Integer.valueOf(guess);
            } else if (currentPlayer == player2) {
                String guess = Integer.toString((int) (Math.random() * highestGuess) + 1); 
                System.out.println("Computer took " + guess + " pieces "); 
                while (!isNumber(guess) || isHigher(guess)) {
                    guess = in.nextLine();
                }
                totalPieces -= Integer.valueOf(guess);
            }
            
            System.out.println ("There are " + totalPieces + " pieces left");
            System.out.println();
            System.out.println();


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
        System.out.println("Player 2 will be the computer");
        player2 = new Player("computer");
    }
}
