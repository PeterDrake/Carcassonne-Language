import java.awt.*;
import javax.swing.*;

public class Carcassonne {

	public static void main(String[] args) {
		System.out.println("Welcome to Carcassonne!");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GameWindow window = new GameWindow();
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setVisible(true);
			}
		});
	}
}

class GameWindow extends JFrame {
	
	private static final int CENTER = 72;
	
	public GameWindow() {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		add(new TileImage(new ImageIcon("04.jpg").getImage()), new GBC(CENTER, CENTER));
		pack();
	}
	
}
