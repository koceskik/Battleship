import java.io.Serializable;

public abstract class Ship implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int size;
	int x;
	int y;
	int hits = 0;//a binary hit system: 00101 is hit twice in the 3rd and 5th locations
	boolean isVert;

	public Ship(int size) {
		this.size = size;
	}

	public boolean setShip(int x, int y, boolean isVert) {
		if(x < 0 || y < 0 || x > 9 || y > 9) {
			return false;
		}
		int dir;
		if(isVert) {
			dir = y;
		}
		else {
			dir = x;
		}
		if(dir + size > 9) {
			return false;
		}
		else {
			this.x = x;
			this.y = y;
			this.isVert = isVert;
			return true;
		}
	}
	
	public boolean isSunk() {
		return hits == Math.pow(2, size)-1;
	}
}
