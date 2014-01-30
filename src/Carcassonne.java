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
	public GameWindow() {
		add(new ImageComponent());
		pack();
	}
}

class ImageComponent extends JComponent {

	private static final int DEFAULT_WIDTH = 150;
	private static final int DEFAULT_HEIGHT = 150;
	private Image image;

	ImageComponent() {
		image = new ImageIcon("00.jpg").getImage();
	}
	
	public void paintComponent(Graphics g){
		if (image == null){
			return;
		}
		g.drawImage(image, (DEFAULT_WIDTH - image.getWidth(this)) / 2, (DEFAULT_HEIGHT - image.getHeight(this)) / 2, null);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}