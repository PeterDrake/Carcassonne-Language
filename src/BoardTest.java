import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BoardTest {
	
	public final int SIZE = 144;
	private Board board;
	
	
	@Before
	public void setUp() {
		board = new Board(SIZE);
	}

	@Test
	public void testScoreRoads() {
		assertEquals(board.getTile(72,72), 1);
		int newX = 72;
		int newY = 73;
		board.addTile(new Tile(newX,newY), newX, newY);
		assertEquals(board.getTile(newX , newY), 2);
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
