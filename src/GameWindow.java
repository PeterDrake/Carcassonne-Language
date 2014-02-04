import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

class GameWindow extends JFrame {

	private static final int CENTER = 72;

	public GameWindow() {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);

		
		add(new TileImage(new ImageIcon("04.jpg").getImage()), new GBC(CENTER,
				CENTER));

		add(new TileImage(new ImageIcon("EmptyTile.png").getImage()), new GBC(
				CENTER, CENTER - 1));
		add(new TileImage(new ImageIcon("EmptyTile.png").getImage()), new GBC(
				CENTER + 1, CENTER));
		add(new TileImage(new ImageIcon("EmptyTile.png").getImage()), new GBC(
				CENTER - 1, CENTER));
		add(new TileImage(new ImageIcon("EmptyTile.png").getImage()), new GBC(
				CENTER, CENTER + 1));


		pack();
	}
}