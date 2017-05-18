public class Player {

    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public boolean play(PowGame g, int column) {
        if( column >= g.getWidth() || column < 0){
            return false;
        }
        return true;
    }
}