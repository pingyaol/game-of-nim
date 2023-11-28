import java.util.Random; 

public class Board {
    private int totalPieces; 

    public createPieces() {
        totalPieces = (int) ((Math.random() * (41)) + 10); 
    }

    public void removePieces() {
        // computer removes pieces and subtracts from the total 
    }

    public int getPieces() {
        return totalPieces; 
    }
}
