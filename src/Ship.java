import java.io.Serializable;

public abstract class Ship implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int x;
	int y;
	int hitsLeft;
	boolean[] hits;
	boolean isVert;

	public Ship(int size) {
		hitsLeft = size;
		hits = new boolean[size];
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
		if(dir + hitsLeft > 9) {
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
		return hitsLeft == 0;
	}
	
	public boolean hit(int a, int b) {//isHit() and modifies hits[]
		int dir;
		if(isVert) {
			if(x != a) return false;
			dir = y;
		}
		else {
			if(y != b) return false;
			dir = x;
		}
		if(dir <= b && b < dir+hits.length) {
			if(hits[b-dir] == false) {
				hitsLeft--;
				return true;
			}
		}
		return false;
	}
}
