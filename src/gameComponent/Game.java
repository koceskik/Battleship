package gameComponent;
import gameComponent.Move.MoveType;

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
	
	public Move.MoveType applyMove(Move m) {
		return Move.MoveType.MISS;
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
	
	public boolean isAllPlayersReady() {//ie all players have placed ships
		boolean ready = true;
		for(Player p : players) {
			ready = ready && p.shipsPlaced;
		}
		return ready;
	}
	
	public boolean hasWinner() {
		//TODO: actually calculate when the Game has a winner
		return false;
	}
}