import java.awt.*;

import javax.swing.*;

public class TileImage extends JComponent{

	private Image image;
	
	public TileImage(Image image){
		this.image = image;
	}
	
	public void paintComponent(Graphics g)
	{
		if (image == null){
			return;
		}
		
		g.drawImage(image, 0, 0, null);
	}

	public Dimension getPreferredSize(){
		return new Dimension(image.getWidth(null), image.getHeight(null));
	}
	
}
