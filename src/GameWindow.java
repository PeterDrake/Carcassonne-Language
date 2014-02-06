import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

class GameWindow extends JFrame {

	private static final int CENTER = 72;
	private GridBagLayout layout;
	boolean tileLocations[][];

	public GameWindow() {
		tileLocations = new boolean[144][144];
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);

		
		add(new TileImage(new ImageIcon("04.jpg").getImage()), new GBC(CENTER,
				CENTER));
		tileLocations[CENTER][CENTER] = true;
		
		generateButtons(CENTER, CENTER);
		


		pack();
	}
	
	public void generateButtons(int x, int y){
		if (!tileLocations[x-1][y]){
			TilePlacementButton button = new TilePlacementButton(x-1, y);
			add(button, new GBC(x-1, y));
			button.addActionListener(new AddTileAction(x-1, y));
		}
		if (!tileLocations[x][y-1]){
			add(new TilePlacementButton(x, y-1), new GBC(x, y-1));
		}
		if (!tileLocations[x+1][y]){
			add(new TilePlacementButton(x+1, y), new GBC(x+1, y));
		}
		if (!tileLocations[x][y+1]){
			add(new TilePlacementButton(x, y+1), new GBC(x, y+1));
		}
	}
	
	public void placeTile(int x, int y){
		System.out.println("place tile");
		add(new TileImage(new ImageIcon("04.jpg").getImage()), new GBC(x,
				y));
		tileLocations[x][y] = true;
		generateButtons(x, y);
		
	}
	
	private class AddTileAction implements ActionListener{
		
		int x;
		int y;
		
		public AddTileAction(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			placeTile(x, y);
		}

	}
}