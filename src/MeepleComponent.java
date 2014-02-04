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
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;


public class MeepleComponent extends JComponent {

	private Image imageFollower;
	private boolean meeple;
	private int meepleX;
	private int meepleY;
	private static final int DEFAULT_WIDTH = 150;
	private static final int DEFAULT_HEIGHT = 150;
	private Image resizedFollower;
	private int resizeNumber = 28;
	
	public MeepleComponent() {
		imageFollower = new ImageIcon("MEEPLE.png").getImage();
		resizedFollower = imageFollower.getScaledInstance(resizeNumber, resizeNumber,Image.SCALE_DEFAULT);
		addMouseListener(new MouseHandler());
	}

	public void paintComponent(Graphics g) {

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
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

}
