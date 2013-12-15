import java.io.Serializable;

public class Move implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public enum MoveType {
		YOUR_TURN, HIT, MISS, ATTACK, WIN, LOSE
	}
	public static Move YOUR_TURN = new Move(MoveType.YOUR_TURN);
	public static Move HIT = new Move(MoveType.HIT);
	public static Move MISS = new Move(MoveType.MISS);
	public static Move WIN = new Move(MoveType.WIN);
	public static Move LOSE = new Move(MoveType.LOSE);
	
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
