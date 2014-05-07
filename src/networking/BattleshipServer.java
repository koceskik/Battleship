package networking;
import gameComponent.Game;
import gameComponent.Move;
import gameComponent.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;

public class BattleshipServer extends Server implements ServerCallback {
	private final int PLAYER_TOTAL = 2;
	private final int port = 5533;
	
	private Game g = null;
	
	public static void main(String[] args) {
		new BattleshipServer().start();
	}

	public BattleshipServer() {
		super();
		g = new Game();

		setupServerSocket();
	}
	@Override
	public void run() {
		//get clients, setup ClientHandlers
		while(playerList.size() < PLAYER_TOTAL) {
			try {
				Socket s = server.accept();
				ServerSideConnection ssc = new ServerSideConnection(s);
				playerList.add(ssc);
				System.out.println("Accepted client socket");
			}
			catch(IOException ex) {
				System.out.println("Failed to accept client OR create I/O streams");
				System.exit(1);
			}
		}
		Collections.shuffle(playerList);
		for(int i = 0;i<PLAYER_TOTAL;i++) {
			ServerSideConnection ssc = playerList.get(i);
			ssc.send(g.players.get(i));
		}
	}


	@Override
	public void applyMove(Move m) {
		Move.MoveType moveResultType = g.applyMove(m);//handles legal checks
		Move moveResult = new Move(moveResultType);//TODO: change this to use the static Moves
	}

	@Override
	public void applyPlayer(Player p) {
		g.updatePlayer(p);
		if(g.isAllPlayersReady()) {
			playerList.get(0).send(Move.YOUR_TURN);
		}
	}

}
