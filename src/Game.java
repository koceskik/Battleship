import java.util.ArrayList;
import java.util.UUID;

public class Game {
	public ArrayList<Player> players = new ArrayList<Player>();
	public ArrayList<Boolean> updatedPlayers = new ArrayList<Boolean>();
	public int turn = 0;
	public UUID turnToken = UUID.randomUUID();
	
	public Game() {
		players.add(new Player());
		players.add(new Player());
		updatedPlayers.add(false);
		updatedPlayers.add(false);
	}
	
	public void applyMove(Move m) {
		
	}

	public void updatePlayer(Player p) {
		for(int i = 0;i<players.size();i++) {
			if(players.get(i).equals(p)) {
				if(updatedPlayers.get(i) == false) {
					players.set(i, p);
					updatedPlayers.set(i, true);
				}
			}
		}
	}
}