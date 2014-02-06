import javax.swing.*;

public class TilePlacementButton extends JButton{
	private int x;
	private int y;
	
	public TilePlacementButton(int x, int y){
		super("+");
		this.x = x;
		this.y = y;
	}
}
