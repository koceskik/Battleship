import java.io.Serializable;

public class Move implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public enum MoveType {
		YOUR_TURN, HIT, MISS, ATTACK
	}
	public static Move YOUR_TURN = new Move(MoveType.YOUR_TURN);
	public static Move HIT = new Move(MoveType.MISS);
	public static Move MISS = new Move(MoveType.MISS);
	
	public MoveType type;
	public int x;
	public int y;
	public Move(MoveType type) {
		this.type = type;
		x = -1;//for safety
		y = -1;//for safety
	}
	public Move(MoveType type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

}
