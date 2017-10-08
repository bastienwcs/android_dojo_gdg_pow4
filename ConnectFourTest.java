import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class ConnectFourTest  {

    @Test
    public void testNoWinner() throws Exception {
        ConnectFour game = new ConnectFour();
        assertEquals(0, game.play(1, 0));
        assertEquals(0, game.play(2, 0));
    }

    @Test(expected=Exception.class)
    public void testPlayerCheats() throws Exception {
        ConnectFour game = new ConnectFour();
        assertEquals(0, game.play(1, 0));
        game.play(1, 1); // Exception should be thrown
    }

    @Test(expected=Exception.class)
    public void testOverflow() throws Exception {
        ConnectFour game = new ConnectFour();
        assertEquals(0, game.play(1, 0));
        assertEquals(0, game.play(2, 0));
        assertEquals(0, game.play(1, 0));
        assertEquals(0, game.play(2, 0));
        assertEquals(0, game.play(1, 0));
        assertEquals(0, game.play(2, 0));
        game.play(1, 0); // Exception should be thrown
    }

    @Test
    public void testColumn() throws Exception {
        ConnectFour game = new ConnectFour();
        assertEquals(0, game.play(1, 0));
        assertEquals(0, game.play(2, 1));
        assertEquals(0, game.play(1, 0));
        assertEquals(0, game.play(2, 1));
        assertEquals(0, game.play(1, 0));
        assertEquals(0, game.play(2, 1));
        assertEquals(1, game.play(1, 0));
    }

    @Test
    public void testRow() throws Exception {
        ConnectFour game = new ConnectFour();
        assertEquals(0, game.play(1, 0));
        assertEquals(0, game.play(2, 1));
        assertEquals(0, game.play(1, 0));
        assertEquals(0, game.play(2, 2));
        assertEquals(0, game.play(1, 0));
        assertEquals(0, game.play(2, 3));
        assertEquals(0, game.play(1, 1));
        assertEquals(2, game.play(2, 4));
    }

    @Test
    public void testDiagonalBottomLeftToTopRight() throws Exception {
        ConnectFour game = new ConnectFour();
        assertEquals(0, game.play(1, 0));
        assertEquals(0, game.play(2, 1));
        assertEquals(0, game.play(1, 1));
        assertEquals(0, game.play(2, 2));
        assertEquals(0, game.play(1, 2));
        assertEquals(0, game.play(2, 3));
        assertEquals(0, game.play(1, 2));
        assertEquals(0, game.play(2, 3));
        assertEquals(0, game.play(1, 3));
        assertEquals(0, game.play(2, 0));
        assertEquals(1, game.play(1, 3));
    }

    @Test
    public void testDiagonalBottomRightToTopLeft() throws Exception {
        ConnectFour game = new ConnectFour();
        assertEquals(0, game.play(2, 4));
        assertEquals(0, game.play(1, 3));
        assertEquals(0, game.play(2, 3));
        assertEquals(0, game.play(1, 2));
        assertEquals(0, game.play(2, 2));
        assertEquals(0, game.play(1, 1));
        assertEquals(0, game.play(2, 2));
        assertEquals(0, game.play(1, 1));
        assertEquals(0, game.play(2, 1));
        assertEquals(0, game.play(1, 4));
        assertEquals(2, game.play(2, 1));
    }
}