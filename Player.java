public class Player {

    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }
    public char getSymbol(){
        return this.symbol;
    }

    public boolean play(PowGame g, int column) throws CheatException {
        if( column >= g.getWidth() || column < 0){
            return false;
        }

        return g.playOnce(this.symbol, column);
    }

    public String toString() {
        return String.format("player: %c", this.symbol);
    }
}