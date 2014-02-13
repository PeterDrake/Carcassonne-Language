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
	public void testScoreTile() {
		int playerUp = 0;
		int r = board.CENTER;
		int c = board.CENTER;
		
		board.scoreTile(r, c);
		assertEquals(0, board.getPlayerScore(playerUp));
		
//		board.placeFollower(r, c, playerUp, 4);
//		board.scoreTile(r, c);
//		assertEquals(1, board.getPlayerScore(playerUp));
		
		c += 1;
		board.addTile(new Tile(r, c, new int[] { 0, 1, 0, 1, 1 }, false), r, c);
		// Confusing add tile
		board.placeFollower(r, c, playerUp, 4);
		board.scoreTile(r, c);
		assertEquals(0, board.getPlayerScore(1));
		assertEquals(0, board.getPlayerScore(2));
		assertEquals(0, board.getPlayerScore(3));
		assertEquals(0, board.getPlayerScore(4));
		assertEquals(2, board.getPlayerScore(playerUp));
		

		c += 1;
		board.addTile(new Tile(r, c, new int[] { 1, 0, 0, 1, 1 }, false), r, c);
		board.scoreTile(r, c);
		assertEquals(5, board.getPlayerScore(playerUp));
	}
	
	@Test
	public void testDivyScore() {
		int playerUp = 0;
		assertEquals(0, board.getPlayerScore(1));
		assertEquals(0, board.getPlayerScore(2));
		assertEquals(0, board.getPlayerScore(3));
		assertEquals(0, board.getPlayerScore(4));
		assertEquals(0, board.getPlayerScore(playerUp));
		
		ScoreTracker currentScore = new ScoreTracker();
		currentScore.score = 5;
		currentScore.followers[0] = 1;
		currentScore.followers[1] = 1;
		board.divyScore(currentScore);
		
		assertEquals(5, board.getPlayerScore(1));
		assertEquals(0, board.getPlayerScore(2));
		assertEquals(0, board.getPlayerScore(3));
		assertEquals(0, board.getPlayerScore(4));
		assertEquals(5, board.getPlayerScore(playerUp));
	}

	@Test
	public void testPlaceTile() {
		int newRow = 72;
		int newCol = 73;
		assertNull(board.getTile(newRow, newCol));
		board.addTile(new Tile(newRow,newCol, new int[] { 0, 1, 0, 1, 1 }, false), newRow, newCol);
		assertNotNull(board.getTile(newRow, newCol));
	}
}
