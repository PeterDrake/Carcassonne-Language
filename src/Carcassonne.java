import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

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
	public GameWindow() {
		add(new MeepleComponent());
		pack();
		add(new ImageComponent());
		pack();
	}
}

class ImageComponent extends JComponent {

	private static final int DEFAULT_WIDTH = 150;
	private static final int DEFAULT_HEIGHT = 150;
	private Image image;
	private Image imageFollower; 
	
	
	
	ImageComponent() {
		image = new ImageIcon("00.jpg").getImage();
		imageFollower = new ImageIcon("MEEPLE.png").getImage();
		
	}

	public void paintComponent(Graphics g) {
		if (image == null) {
			return;
		}
		g.drawImage(image, (DEFAULT_WIDTH - image.getWidth(this)) / 2,
				(DEFAULT_HEIGHT - image.getHeight(this)) / 2, null);
	}

	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}




