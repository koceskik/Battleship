import java.util.ArrayList;
import java.util.UUID;

public class Game {
	public ArrayList<Player> players = new ArrayList<Player>();
	public int turn = 0;
	public UUID turnToken;
	
	public Game() {
		players.add(new Player());
		players.add(new Player());
	}
	
	public void applyMove(Move m) {
		
	}

	public void updatePlayer(Player p) {
		for(int i = 0;i<players.size();i++) {
			if(players.get(i).equals(p)) {
				if(players.get(i).shipsPlaced == false) {
					players.set(i, p);
				}
			}
		}
	}
}