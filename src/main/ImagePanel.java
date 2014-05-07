package main;
import gameComponent.Tile;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private BufferedImage image;
	private int scaledSize = Tile.scaledSize;
	private int scaleStyle = Tile.scaleStyle;
	private int rotate = 0;

	public ImagePanel(BufferedImage image, int scaledSize, int scaleStyle) {
		setImage(image);
		setSize(scaledSize);
		setScaleStyle(scaleStyle);
	}
	
	public ImagePanel(BufferedImage image) {
		setImage(image);
	}
	
	public ImagePanel(BufferedImage image, int scaledSize, int scaleStyle, int rotate) {
		setImage(image);
		setSize(scaledSize);
		setScaleStyle(scaleStyle);
		setRotation(rotate);
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void setSize(int scaledSize) {
		this.scaledSize = scaledSize;
	}
	
	public void setScaleStyle(int scaleStyle) {
		this.scaleStyle = scaleStyle;
	}
	
	public void setRotation(int rotate) {
		this.rotate = rotate;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(rotate*Math.toRadians(90), scaledSize/2, scaledSize/2);
		g.drawImage(image.getScaledInstance(scaledSize, scaledSize, scaleStyle), 0, 0, null);
		//g2d.rotate(Math.toRadians(90), image.getWidth()/2, image.getHeight()/2);
		//g.drawImage(image, 0, 0, null);
	}

}