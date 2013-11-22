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
		char[] color = {'B','W'};
		char[] piece = {'P','N','B','R','Q','K'};
		for(char c1:color) {
			for(char c2:color) {
				for(char p:piece) {
					Image i = Toolkit.getDefaultToolkit().getImage("res/" + c1+c2+p + ".png");
					images.put("" + c1+c2+p, new ImageIcon(i));
					images.put("" + c1+c2+p+"s", new ImageIcon(i.getScaledInstance(scaledSize, scaledSize, scaleStyle)));
				}
			}
		}
		Image b = Toolkit.getDefaultToolkit().getImage("res/B.png");
		Image w = Toolkit.getDefaultToolkit().getImage("res/W.png");
		images.put("B", new ImageIcon(b));
		images.put("W", new ImageIcon(w));
		images.put("Bs", new ImageIcon(b.getScaledInstance(scaledSize, scaledSize, scaleStyle)));
		images.put("Ws", new ImageIcon(w.getScaledInstance(scaledSize, scaledSize, scaleStyle)));
	}
}
