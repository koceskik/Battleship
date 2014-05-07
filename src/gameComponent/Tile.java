package gameComponent;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Tile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final int scaleStyle = Image.SCALE_SMOOTH;
	public static final int size = 32;
	public static final int scaledSize = 16;
	public static HashMap<String,BufferedImage> images = new HashMap<String,BufferedImage>();
	static {
		BufferedImage water = null;
		BufferedImage shipFront = null;
		BufferedImage shipBack = null;
		BufferedImage shipBody = null;
		try {
			water = ImageIO.read(new File("res/water.png"));
			shipFront = ImageIO.read(new File("res/shipFront.png"));
			shipBack = ImageIO.read(new File("res/shipBack.png"));
			shipBody = ImageIO.read(new File("res/shipBody.png"));
		}
		catch(IOException ex) {/* Ignored */}
		images.put("WATER", water);
		images.put("SHIPFRONT", shipFront);
		images.put("SHIPBACK", shipBack);
		images.put("SHIPBODY", shipBody);
	}
}
