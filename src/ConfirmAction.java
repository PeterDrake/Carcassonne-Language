import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class ConfirmAction implements ActionListener {

	private GameWindow window;
	
	public ConfirmAction(GameWindow window){
		this.window = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		window.getAndDisplayNextTile();		
	}
	
}
