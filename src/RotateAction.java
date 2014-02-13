import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

import javax.swing.ImageIcon;

public class RotateAction implements ActionListener{
	private BufferedImage currentTileImage;
	private GameWindow window;
	private TileImage tile;
	
	public RotateAction(GameWindow window){
		this.window = window;
	}
	
	public void setTile(TileImage tile){
		this.tile = tile;
		if(tile == null){ 
			currentTileImage = null;
			return; 
			}
		
		Image img = tile.getImage();
		currentTileImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		currentTileImage.getGraphics().drawImage(img, 0, 0, null);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (currentTileImage == null)
			return;
		AffineTransform transform = AffineTransform.getRotateInstance(
				Math.toRadians(90), currentTileImage.getWidth() / 2,
				currentTileImage.getHeight() / 2);
		AffineTransformOp op = new AffineTransformOp(transform,
				AffineTransformOp.TYPE_BICUBIC);
		filter(op);
	}
	
	
	/**
	 * Apply a filter and repaint.
	 * 
	 * @param op
	 *            the image operation to apply
	 */
	private void filter(BufferedImageOp op) {
		if (currentTileImage == null)
			return;
		currentTileImage = op.filter(currentTileImage, null);
		tile.setImage(currentTileImage);
		 window.repaint();
	}
}
