import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
//
//import mouse.MouseComponent.MouseMotionHandler;
//import FollowerPlacement.ImageComponent;
//import FollowerPlacement.MouseHandler;

public class MeepleComponent extends JComponent {

	private Image imageFollower;
	private boolean meeple; 
	private int meepleX;
	private int meepleY; 

	public MeepleComponent() {
		imageFollower = new ImageIcon("MEEPLE.png").getImage();
		addMouseListener(new MouseHandler());
	}

	public void paintComponent(Graphics g) {
		System.out.println("here");
		if (meeple) {
			g.drawImage(imageFollower, meepleX,
			meepleY, null);
			
			
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
//			// add a new square if the cursor isn't inside a square
//			current = find(event.getPoint());
//			if (current == null)
				add(event.getPoint());
		}

//		public void mouseClicked(MouseEvent event) {
//			// remove the current square if double clicked
//			event.getPoint();
//		}
	}

	

}
