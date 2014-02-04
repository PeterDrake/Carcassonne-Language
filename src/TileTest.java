import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TileTest {
	
	private Tile tile;
	
	@Before
	public void setUp() {
		tile = new Tile(72,72);
	}

	@Test
	public void testGetSide() {
		assertEquals(tile.getSide(0), 0);
		assertEquals(tile.getSide(1), 1);
		assertEquals(tile.getSide(2), 0);
		assertEquals(tile.getSide(3), 1);
	}
	
	@Test
	public void testHasRoad() {
		assertTrue(tile.hasRoad());
	}

}
