import java.util.*;

public class ConnectFour {
	
	private int[][] grid;
    private int width;
    private int height;
	private int previousPlayer;

    public ConnectFour() {
        width = 7;
        height = 6;
    	grid = new int[height][width];
    	previousPlayer = 0;
    }

    /**
    * @return int player if he wins, else 0
    * @throws Exception if same player plays twice
    * @throws Exception if the grid can't contains another token
    */
    public int play(int player, int column) throws Exception {
        if (previousPlayer == player) {
            throw new Exception("Players cheats : " + String.valueOf(player));
        }
        previousPlayer = player;
        // row, from bottom to top
        for (int row = height - 1; row >= 0; row--) {
            if (grid[row][column] == 0) {
                grid[row][column] = player;
                return playerWins(player, row, column);
            }
        }
        throw new Exception("Column overflow : " + String.valueOf(column));
    }

    private int playerWins(int player, int row, int column) {
        int maxLength = 0;
        int currentLength = 0;
        // row
        for (int c = 0; c < width; c++) {
            if (grid[row][c] == player) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            }
        }
        currentLength = 0;
        // column
        for (int r = height - 1; r >= 0; r--) {
            if (grid[r][column] == player) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            }
        }
        // diagonal bottom left to top right
        currentLength = 0;
        int rowBottomLeft = row;
        int columnBottomLeft = column;
        while (rowBottomLeft < height - 1 && columnBottomLeft > 0) {
            rowBottomLeft++;
            columnBottomLeft--;
        }
        for (int r = rowBottomLeft, c = columnBottomLeft; r >= 0 && c < width; r--, c++) {
            if (grid[r][c] == player) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            }
        }
        // diagonal bottom right to top left
        currentLength = 0;
        int rowBottomRight = row;
        int columnBottomRight = column;
        while (rowBottomRight < height - 1 && columnBottomRight < width) {
            rowBottomRight++;
            columnBottomRight++;
        }
        for (int r = rowBottomRight, c = columnBottomRight; r >= 0 && c >= 0; r--, c--) {
            if (grid[r][c] == player) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            }
        }
        return maxLength >= 4 ? player : 0;
    }
}