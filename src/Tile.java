import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Tile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final int scaleStyle = Image.SCALE_SMOOTH;
	public static final int size = 32;
	public static final int scaledSize = 16;
	public static HashMap<String,ImageIcon> images = new HashMap<String,ImageIcon>();
	static {
		Image water = Toolkit.getDefaultToolkit().getImage("res/water.png");
		Image shipFront = Toolkit.getDefaultToolkit().getImage("res/shipFront1.png");
		Image shipBack = Toolkit.getDefaultToolkit().getImage("res/shipBack.png");
		//Graphics2D gr = (Graphics2D) shipBack.getGraphics();
		//gr.rotate(Math.toRadians(90));
		images.put("WATER", new ImageIcon(water));
		images.put("WATERs", new ImageIcon(water.getScaledInstance(scaledSize, scaledSize, scaleStyle)));
		images.put("SHIPFRONT", new ImageIcon(shipFront));
		images.put("SHIPFRONTs", new ImageIcon(shipFront.getScaledInstance(scaledSize, scaledSize, scaleStyle)));
		images.put("SHIPBACK", new ImageIcon(shipBack));
		images.put("SHIPBACKs", new ImageIcon(shipBack.getScaledInstance(scaledSize, scaledSize, scaleStyle)));

	}
}
