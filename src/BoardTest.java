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
	public void testScoreTileGameOver() {
		board.gameOver();
		
		int playerUp = 0;
		int r = board.CENTER;
		int c = board.CENTER;
		
		board.scoreTile(r, c);
		assertEquals(0, board.getPlayerScore(playerUp));
		
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
		
		r += 1;
		board.addTile(new Tile(r, c, new int[] { 0, 1, 0, 1, 1 }, false), r, c);
		board.scoreTile(r, c);
		assertEquals(5, board.getPlayerScore(playerUp));
		
		r -= 2;
		board.addTile(new Tile(r, c, new int[] { 1, 1, 1, 1, 0 }, true), r, c);
		board.scoreTile(r, c);
		assertEquals(9, board.getPlayerScore(playerUp));
		
		r -= 1;
		board.addTile(new Tile(r, c, new int[] { 1, 1, 1, 1, 0 }, true), r, c);
		board.scoreTile(r, c);
		assertEquals(9, board.getPlayerScore(playerUp));
		
		r = board.CENTER;
		c = board.CENTER - 1;
		board.addTile(new Tile(r, c, new int[] { 0, 1, 1, 1, 0 }, true), r, c);
		board.scoreTile(r, c);
		assertEquals(14, board.getPlayerScore(playerUp));
	}
	
	@Test
	public void testScoreTileGameOn() {		
		int playerUp = 0;
		int r = board.CENTER;
		int c = board.CENTER;
		
		board.scoreTile(r, c);
		assertEquals(0, board.getPlayerScore(playerUp));
		
		c += 1;
		board.addTile(new Tile(r, c, new int[] { 0, 1, 0, 1, 1 }, false), r, c);
		// Confusing add tile
		board.placeFollower(r, c, playerUp, 4);
		board.scoreTile(r, c);
		assertEquals(0, board.getPlayerScore(1));
		assertEquals(0, board.getPlayerScore(2));
		assertEquals(0, board.getPlayerScore(3));
		assertEquals(0, board.getPlayerScore(4));
		assertEquals(0, board.getPlayerScore(playerUp));
		

		c += 1;
		board.addTile(new Tile(r, c, new int[] { 1, 0, 0, 1, 1 }, false), r, c);
		board.scoreTile(r, c);
		assertEquals(0, board.getPlayerScore(playerUp));
		
		r += 1;
		board.addTile(new Tile(r, c, new int[] { 0, 1, 0, 1, 1 }, false), r, c);
		board.scoreTile(r, c);
		assertEquals(0, board.getPlayerScore(playerUp));
		
		r -= 2;
		board.addTile(new Tile(r, c, new int[] { 1, 1, 1, 1, 0 }, true), r, c);
		board.scoreTile(r, c);
		assertEquals(0, board.getPlayerScore(playerUp));
		
		r -= 1;
		board.addTile(new Tile(r, c, new int[] { 1, 1, 1, 1, 0 }, true), r, c);
		board.scoreTile(r, c);
		assertEquals(0, board.getPlayerScore(playerUp));
		
		r = board.CENTER;
		c = board.CENTER - 1;
		board.addTile(new Tile(r, c, new int[] { 0, 1, 1, 1, 0 }, true), r, c);
		board.scoreTile(r, c);
		assertEquals(5, board.getPlayerScore(playerUp));
	}
	
	@Test
	public void testGetNeighbor() {
		int r = board.CENTER;
		int c = board.CENTER;
		
		
		c += 1;
		board.addTile(new Tile(r, c, new int[] { 0, 1, 0, 1, 1 }, false), r, c);
		board.placeFollower(r, c, 0, 4);

		c += 1;
		board.addTile(new Tile(r, c, new int[] { 1, 0, 0, 1, 1 }, false), r, c);
		
		r -= 1;
		board.addTile(new Tile(r, c, new int[] { 1, 1, 1, 1, 0 }, true), r, c);
		
		r -= 1;
		board.addTile(new Tile(r, c, new int[] { 1, 1, 1, 1, 0 }, true), r, c);
		
		r = board.CENTER;
		c = board.CENTER - 1;
		board.addTile(new Tile(r, c, new int[] { 0, 1, 1, 1, 0 }, true), r, c);
		
		assertNotNull(board.getNeighbor(0, board.getTile(72, 74)));
		assertNull(board.getNeighbor(1, board.getTile(72, 74)));
		assertNull(board.getNeighbor(2, board.getTile(72, 74)));
		assertNotNull(board.getNeighbor(3, board.getTile(72, 74)));
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
