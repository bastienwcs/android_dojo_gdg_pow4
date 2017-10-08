import java.util.*;

public class ConnectFour {
	
	private int[][] grid;
    private int width;
    private int height;

    public ConnectFour() {
        width = 7;
        height = 6;
    	grid = new int[height][width];
    }

    /**
    * @return int player if he wins, else 0
    * @throws Exception if same player plays twice
    * @throws Exception if the grid can't contains another token
    */
    public int play(int player, int column) throws Exception {

    }
}