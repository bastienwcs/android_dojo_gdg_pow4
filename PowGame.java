import java.util.*;


public class PowGame {

    private int width;
    private int height;
    private char [][] gameTable;
    private int [] count;
    private HashMap<Character,Player> players;
    private char lastPlayedToken = 0;
    private Player winner;

    public PowGame(int width, int height) {
        this.height = height;
        this.width = width;
        this.gameTable = new char [width][height];
        this.count = new int [width];
        this.resetBoard();
        this.players = new HashMap<>();

        
    }

    private void resetBoard(){
        for(int i=0;i<this.width;i++){
            this.count[i]=0; 
            for(int j = 0; j<this.height;j++){
                this.gameTable[i][j]=0;
            }

        }
    }
    public void registerPlayer(Player p) {
        players.put(p.getSymbol(),p);
        

    }

    public Player getWinner() {
        return this.winner;
    }

    private void setWinner(char token){
        this.winner = players.get(token);
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public boolean playOnce (char token, int column) throws CheatException{
        if(isFull(column)){
            return false;
        }
        if (token == lastPlayedToken){
            throw new CheatException(this.players.get(token));
        }
        this.lastPlayedToken = token;
        gameTable[column][count[column]] = token;
        setWinner(checkVictory(column, token));
        count[column]++;
        return true;
    }

    private boolean isFull(int column){
        return count[column] >= this.height;
    }


    private char checkVictory(int column, char token){
        if (checkColumn(column, token) 
           || checkDiagLeft(column, token)
           || checkDiagRight(column, token)
           || checkLine(column, token)) {
               return token;
           }
           return 0;

    }
    private boolean checkColumn(int column, char token){
        for(int i = count[column]-1;i>=count[column]-3;i--){
            if(getSymbolAt(column, i)!=token){
                return false;
            }
        }
        System.out.println("checkColumn" + token);
        return true;
    }
    private boolean checkDiagRight(int column, char token){
        int x = column;
        int y = count[column];
        int counter = 0;
        char s;
        do{
            s = getSymbolAt(x++, y--);
            counter ++;
        }while(s == token);

        if (counter >= 4){
            System.out.println("checkDiagRight" + token);
            return true;
        }
        x = column - 1;
        y = count[column] + 1;
        
        do {
            s = getSymbolAt(x--, y++);
            counter++;
        }while(s == token);

        if(counter>=4){
            System.out.println("checkDiagRight" + token);
            return true;
        }
        return false;
    }

        private boolean checkDiagLeft(int column, char token){
        int x = column;
        int y = count[column];
        int counter = 0;
        char s;
        do{
            s = getSymbolAt(x++, y++);
            counter ++;
        }while(s == token);

        if (counter >= 4){
            System.out.println("checkDiagLeft" + token);
            return true;
        }
        x = column - 1;
        y = count[column] - 1;
        
        do {
            s = getSymbolAt(x--, y--);
            counter++;
        }while(s == token);
        if(counter >= 4){
            System.out.println("checkDiagLeft" + token);
            return true;
        }
        return false;
    }

    private boolean checkLine(int column, char token){
        int x = column;
        int y = count[column];
        int counter = 0;
        char s;
        do{
            s = getSymbolAt(x++, y);
            counter ++;
        }while(s == token);

        if (counter >= 4){
            System.out.println("checkLine" + token);
            return true;
        }
        x = column - 1;
        
        do {
            s = getSymbolAt(x--, y);
            counter++;
        }while(s == token);
        if (counter >= 4){
            System.out.println("checkLine" + token);
            return true;
        }
        return false;

    }

    private char getSymbolAt(int x, int y){
        if (x < 0 || x >= this.width || y < 0 || y >= this.height){
            return (char) -1;
        }
        return gameTable[x][y];
    }



}