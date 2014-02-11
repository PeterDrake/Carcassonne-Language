import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GameWindow extends JFrame {

	private static final int CENTER = 72;

	private JPanel buttonPanel;
	public TileImage currentTile;
	public RotateAction rotateAction;
	public JButton rotateButton;
	
	private GridBagLayout layout;
	boolean tileLocations[][];
	public ArrayList<TilePlacementButton> activeButtons;
	private ArrayList<TileImage> placedTiles;

	public GameWindow() {
		tileLocations = new boolean[144][144];
		activeButtons = new ArrayList<TilePlacementButton>();
		placedTiles = new ArrayList<TileImage>();
		
		buttonPanel = new JPanel();
		rotateButton = new JButton("Rotate");
		buttonPanel.add(rotateButton);
		add(buttonPanel);
		rotateAction = new RotateAction(this);
		rotateButton.addActionListener(rotateAction);
		
		layout = new GridBagLayout();
		setLayout(layout);

		TileImage initialTile = new TileImage(
				new ImageIcon("04.jpg").getImage(), CENTER, CENTER);
		add(initialTile, new GBC(CENTER, CENTER));
		placedTiles.add(initialTile);
		tileLocations[CENTER][CENTER] = true;


		generateButtons(CENTER, CENTER);
		pack();
	}

	public void generateButtons(int x, int y) {
		if (!tileLocations[x - 1][y] && getButton(x-1, y) == null) {
			TilePlacementButton button = new TilePlacementButton(x - 1, y);
			activeButtons.add(button);
			add(button, new GBC(x - 1, y));
			button.addActionListener(new AddTileAction(x - 1, y));
		}
		if (!tileLocations[x][y - 1] && getButton(x, y-1) == null) {
			TilePlacementButton button = new TilePlacementButton(x, y - 1);
			activeButtons.add(button);
			add(button, new GBC(x, y - 1));
			button.addActionListener(new AddTileAction(x, y - 1));
		}
		if (!tileLocations[x + 1][y] && getButton(x+1, y) == null) {
			TilePlacementButton button = new TilePlacementButton(x + 1, y);
			activeButtons.add(button);
			add(button, new GBC(x + 1, y));
			button.addActionListener(new AddTileAction(x + 1, y));
		}
		if (!tileLocations[x][y + 1] && getButton(x, y+1) == null) {
			TilePlacementButton button = new TilePlacementButton(x, y + 1);
			activeButtons.add(button);
			add(button, new GBC(x, y + 1));
			button.addActionListener(new AddTileAction(x, y + 1));
		}
		pack();
	}

	public TilePlacementButton getButton(int x, int y) {
		for (TilePlacementButton button : activeButtons) {
			System.out.println(x + "," + y);
			System.out
					.println("button: " + button.getGridX() + "," + button.getGridY());
			if ((button.getGridX() == x) && (button.getGridY() == y)) {
				return button;
			}
		}
		return null;
	}

	public void placeTile(int x, int y) {
		activeButtons.remove(getButton(x, y));
		getContentPane().removeAll();
		
		for (TileImage tile : placedTiles) {
			System.out.println("Adding tile at " + tile.getGridX()+ ", " + tile.getGridY());
			add(tile, new GBC(tile.getGridX(), tile.getGridY()));
		}
		for (TilePlacementButton button : activeButtons) {
			add(button, new GBC(button.getGridX(), button.getGridY()));
		}
		add(buttonPanel);

		TileImage newTile = new TileImage(new ImageIcon("04.jpg").getImage(),
				x, y);
		System.out.println("Adding new tile");
		add(newTile, new GBC(x, y));
		placedTiles.add(newTile);
		rotateAction.setTile(newTile);
		System.out.println("Generating buttons");
		generateButtons(x, y);
		pack();
		revalidate();
		repaint();
		tileLocations[x][y] = true;

	}

	private class AddTileAction implements ActionListener {

		int x;
		int y;

		public AddTileAction(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Placing a tile at " + x + ", " + y);
			placeTile(x, y);
		}

	}
}