import java.util.ArrayList;

public class Game {
	public ArrayList<Player> players = new ArrayList<Player>();
	public int turn = 0;
	
	public Game() {
		players.add(new Player());
		players.add(new Player());
	}
	
	public void applyMove(Move m) {
		
	}

}
