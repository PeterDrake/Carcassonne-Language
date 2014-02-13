import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TileTest {
	
	private Tile tile;
	
	@Before
	public void setUp() {
		tile = new Tile(72,72, new int[] { 0, 1, 0, 1, 1 }, false);
	}

	@Test
	public void testGetSide() {
		assertEquals(tile.getSideType(0), 0);
		assertEquals(tile.getSideType(1), 1);
		assertEquals(tile.getSideType(2), 0);
		assertEquals(tile.getSideType(3), 1);
	}
	
	@Test
	public void testHasRoad() {
		assertTrue(tile.hasRoad());
	}
	
	@Test
	public void testSetFollower() {
		assertNull(tile.getFollower());
		tile.setFollower(0, 1, 4);
		assertEquals(tile.getFollower().getPlayer(), 0);
		assertEquals(tile.getFollower().getLocationType(), 1);
		assertEquals(tile.getFollower().getLocation(), 4);
	}


}
