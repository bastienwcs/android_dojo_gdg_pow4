import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class PowTest  {

    @Test
    public void testNoGame() throws Exception {
        PowGame game = new PowGame(8, 8);
        Player p1 = new Player('*');
        Player p2 = new Player('#');
        game.registerPlayer(p1);
        game.registerPlayer(p2);
        assertEquals(null, game.getWinner());
    }

    @Test
    public void testNoWinner() throws Exception {
        PowGame game = new PowGame(8, 8);
        Player p1 = new Player('*');
        Player p2 = new Player('#');
        game.registerPlayer(p1);
        game.registerPlayer(p2);

        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 1));
        assertTrue(p1.play(game, 2));
        assertTrue(p2.play(game, 3));
        assertTrue(p1.play(game, 2));
        assertTrue(p2.play(game, 2));

        assertNull(game.getWinner());
    }

    @Test(expected=CheatException.class)
    public void testPlayerCheats() throws Exception {
        PowGame game = new PowGame(8, 8);
        Player p1 = new Player('*');
        Player p2 = new Player('#');
        game.registerPlayer(p1);
        game.registerPlayer(p2);

        assertTrue(p1.play(game, 0));
        p1.play(game, 2); // CheatException should be thrown
    }

    @Test
    public void testOverflow() throws Exception {
        PowGame game = new PowGame(8, 8);
        Player p1 = new Player('*');
        Player p2 = new Player('#');
        game.registerPlayer(p1);
        game.registerPlayer(p2);

        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 0));
        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 0));
        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 0));
        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 0));
        assertFalse(p1.play(game, 0));
    }

    @Test
    public void testWinner() throws Exception {
        PowGame game = new PowGame(8, 8);
        Player p1 = new Player('*');
        Player p2 = new Player('#');
        game.registerPlayer(p1);
        game.registerPlayer(p2);

        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 1));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 2));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 3));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 4));
        assertTrue(p2.play(game, 0));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 1));
        assertTrue(p2.play(game, 1));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 5));
        assertTrue(p2.play(game, 2));
        assertEquals(p2, game.getWinner());
    }

    @Test
    public void testWinnerOneColumn() throws Exception {
        PowGame game = new PowGame(8, 8);
        Player p1 = new Player('*');
        Player p2 = new Player('#');
        game.registerPlayer(p1);
        game.registerPlayer(p2);

        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 1));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 1));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 1));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 0));
        assertEquals(p1, game.getWinner());
    }

    @Test
    public void testWinnerOneColumn2() throws Exception {
        PowGame game = new PowGame(8, 8);
        Player p1 = new Player('*');
        Player p2 = new Player('#');
        game.registerPlayer(p1);
        game.registerPlayer(p2);

        assertTrue(p1.play(game, 1));
        assertTrue(p2.play(game, 0));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 1));
        assertTrue(p2.play(game, 2));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 1));
        assertTrue(p2.play(game, 3));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 1));
        assertEquals(p1, game.getWinner());
    }

    @Test(timeout=200)
    public void testPerformance() throws Exception {
        PowGame game = new PowGame(1000, 1000);
        Player p1 = new Player('*');
        Player p2 = new Player('#');
        game.registerPlayer(p1);
        game.registerPlayer(p2);

        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 1));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 2));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 0));
        assertTrue(p2.play(game, 3));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 4));
        assertTrue(p2.play(game, 0));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 1));
        assertTrue(p2.play(game, 1));
        assertNull(game.getWinner());
        assertTrue(p1.play(game, 5));
        assertTrue(p2.play(game, 4));
        assertNull(game.getWinner());
    }
}