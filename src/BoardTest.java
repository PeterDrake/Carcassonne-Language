import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BoardTest {
	
	private Board board;
	
	
	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void testScoreRoads() {
		int playerUp = 0;
		int x = board.CENTER;
		int y = board.CENTER;
		
		board.scoreRoads(x, y);
		assertEquals(board.getPlayerScore(playerUp), 0);
		
		board.placeFollower(x, y, playerUp, 1);
		board.scoreRoads(x, y);
		assertEquals(board.getPlayerScore(playerUp), 2);
		
		y += 1;
		board.addTile(new Tile(x, y), x, y);
		// Confusing add tile
		board.placeFollower(x, y, playerUp, 1);
		board.scoreRoads(x, y);
		assertEquals(board.getPlayerScore(1), 0);
		assertEquals(board.getPlayerScore(2), 0);
		assertEquals(board.getPlayerScore(3), 0);
		assertEquals(board.getPlayerScore(4), 0);
		assertEquals(board.getPlayerScore(playerUp), 2);
	}

	@Test
	public void testPlaceTile() {
		int newX = 72;
		int newY = 73;
		assertNull(board.getTile(newX, newY));
		board.addTile(new Tile(newX,newY), newX, newY);
		assertNotNull(board.getTile(newX, newY));
	}
}
