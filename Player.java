public class Player {
    private string name; 
    private int numOfPieces = 0; 

    public Player(string name) {
        this.name = name; 
    }

    public void addPieces(int num) {
        numOfPieces += num; 
    }

    public int getPieces() {
        return this.numOfPieces; 
    }

    public string getName() {
        return this.name; 
    }
}
