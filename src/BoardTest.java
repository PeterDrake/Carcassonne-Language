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
		int r = board.CENTER;
		int c = board.CENTER;
		
		board.scoreTile(r, c);
		assertEquals(board.getPlayerScore(playerUp), 0);
		
		board.placeFollower(r, c, playerUp, 4);
		board.scoreTile(r, c);
		assertEquals(board.getPlayerScore(playerUp), 1);
		
		c += 1;
		board.addTile(new Tile(r, c, new int[] { 0, 1, 0, 1, 1 }), r, c);
		// Confusing add tile
		board.placeFollower(r, c, playerUp, 4);
		board.scoreTile(r, c);
		assertEquals(board.getPlayerScore(1), 0);
		assertEquals(board.getPlayerScore(2), 0);
		assertEquals(board.getPlayerScore(3), 0);
		assertEquals(board.getPlayerScore(4), 0);
		assertEquals(board.getPlayerScore(playerUp), 2);
		
	}

	@Test
	public void testPlaceTile() {
		int newRow = 72;
		int newCol = 73;
		assertNull(board.getTile(newRow, newCol));
		board.addTile(new Tile(newRow,newCol, new int[] { 0, 1, 0, 1, 1 }), newRow, newCol);
		assertNotNull(board.getTile(newRow, newCol));
	}
}
