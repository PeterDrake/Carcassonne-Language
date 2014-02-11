import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GameWindow extends JFrame {

	private static final int CENTER = 72;
	private JPanel buttonPanel;
	public TileImage currentTile;

	public GameWindow() {
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		currentTile = new TileImage(new ImageIcon("04.jpg").getImage());
		
		add(currentTile, new GBC(CENTER,
				CENTER));

		add(new TileImage(new ImageIcon("EmptyTile.png").getImage()), new GBC(
				CENTER, CENTER - 1));
		add(new TileImage(new ImageIcon("EmptyTile.png").getImage()), new GBC(
				CENTER + 1, CENTER));
		add(new TileImage(new ImageIcon("EmptyTile.png").getImage()), new GBC(
				CENTER - 1, CENTER));
		add(new TileImage(new ImageIcon("EmptyTile.png").getImage()), new GBC(
				CENTER, CENTER + 1));

		buttonPanel = new JPanel();
		JButton rotateButton = new JButton("Rotate");
		buttonPanel.add(rotateButton);
		add(buttonPanel);
		RotateAction rotateAction = new RotateAction(this, currentTile);
		rotateButton.addActionListener(rotateAction);
		
//		public TileImage getCurrentTile(){
//			return currentTile;
//		}

		pack();
	}
}