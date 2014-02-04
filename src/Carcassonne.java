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
