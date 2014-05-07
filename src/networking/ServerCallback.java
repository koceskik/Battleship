package networking;

import gameComponent.Move;
import gameComponent.Player;

public interface ServerCallback {
	public void removeServerSideConnection(ServerSideConnection ssc);
	public void applyMove(Move m);
	public void applyPlayer(Player p);
}
