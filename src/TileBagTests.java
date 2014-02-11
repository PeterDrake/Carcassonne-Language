import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TileBagTests {

	private TileBag bag;
	
	@Before
	public void setUp(){
		bag = new TileBag();
	}
	
	@Test
	public void testGetTile(){
		Tile tile = bag.getTile("00");
		assertEquals(tile.getID(), "00");
	}
	
	@Test
	public void testGetRandomTile(){
		
	}

}
