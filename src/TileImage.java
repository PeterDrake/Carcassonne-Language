import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.*;

public class TileImage extends JComponent{

	private Image image;
	private Image imageFollower;
	private boolean meeple;
	private int meepleX;
	private int meepleY;
	private Image resizedFollower;
	private int resizeNumber = 28;
	
	
	
	public TileImage(Image image){
		this.image = image;
		imageFollower = new ImageIcon("MEEPLE.png").getImage();
		resizedFollower = imageFollower.getScaledInstance(resizeNumber, resizeNumber,Image.SCALE_DEFAULT);
		addMouseListener(new MouseHandler());
	}
	
	public void paintComponent(Graphics g)
	{
		if (image == null){
			return;
		}
		
		g.drawImage(image, 0, 0, null);
		
		if (meeple) {
			g.drawImage(resizedFollower, meepleX - (resizeNumber/2), meepleY - (resizeNumber/2), null);

		}
	}
	
	public void add(Point2D p) {
		double x = p.getX();
		double y = p.getY();

		meeple = true;
		meepleX = (int) x;
		meepleY = (int) y;

		repaint();
	}

	private class MouseHandler extends MouseAdapter {
		public void mousePressed(MouseEvent event) {
			add(event.getPoint());
		}
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(image.getWidth(null), image.getHeight(null));
	}
	
	public Image getImage(){
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
