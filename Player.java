public class Player {
    private String name; 
    private int numOfPieces = 0; 

    public Player(String name) {
        this.name = name; 
    }

    public void addPieces(int num) {
        numOfPieces += num; 
    }

    public int getPieces() {
        return this.numOfPieces; 
    }

    public String getName() {
        return this.name; 
    }
}
