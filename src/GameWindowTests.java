import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GameWindowTests {
	private GameWindow newGame;
	
	@Before
	public void setUp(){
		newGame = new GameWindow();
		
		
	}
	
	@Test
	public void testGetButton() {
		assertFalse(newGame.activeButtons.isEmpty());
		assertNotNull(newGame.getButton(71,72));
	}

}
