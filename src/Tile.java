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
		Image shipFront = Toolkit.getDefaultToolkit().getImage("res/shipFront.png");
		Image shipBack = Toolkit.getDefaultToolkit().getImage("res/shipBack.png");
		Image shipBody = Toolkit.getDefaultToolkit().getImage("res/shipBody.png");
		images.put("WATER", new ImageIcon(water));
		images.put("WATERs", new ImageIcon(water.getScaledInstance(scaledSize, scaledSize, scaleStyle)));
		images.put("SHIPFRONT", new ImageIcon(shipFront));
		images.put("SHIPFRONTs", new ImageIcon(shipFront.getScaledInstance(scaledSize, scaledSize, scaleStyle)));
		images.put("SHIPBACK", new ImageIcon(shipBack));
		images.put("SHIPBACKs", new ImageIcon(shipBack.getScaledInstance(scaledSize, scaledSize, scaleStyle)));
		images.put("SHIPBODY", new ImageIcon(shipBody));
		images.put("SHIPBODYs", new ImageIcon(shipBody.getScaledInstance(scaledSize, scaledSize, scaleStyle)));

	}
}
