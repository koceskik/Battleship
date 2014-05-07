package networking;

import gameComponent.Game;
import gameComponent.Player;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import main.CardPane;
import main.GameHolder;
import main.UICallback;

public class ClientSideConnection extends Connection {
	private volatile ArrayList<GameHolder> gh = new ArrayList<GameHolder>();
	private volatile Player p = null;
	
	private ArrayList<UICallback> subscribedUI = new ArrayList<UICallback>();
	public void subscribe(UICallback e) {
		subscribedUI.add(e);
	}
	public void unsubscribe(UICallback e) {
		subscribedUI.remove(e);
	}

	public ClientSideConnection(Socket s) {
		super(s);
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Object o = ois.readObject();
				if(o instanceof Game) {
					Game g = (Game) o;
					//TODO: do I create the GameHolder and Player here then send immediately?
					//or create UICallback where the official Game and Player info are stored (in main.Battleship)
				}
			}
		}
		catch(ClassNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {/*e.printStackTrace();*/}
		finally {
			close();
		}
	}

	//UICallback methods: TODO: are any of these necessary
	private void addGameHolder(GameHolder gameHolder) {
		for(UICallback uic : subscribedUI) {
			uic.addGameHolder(gameHolder);
		}
	}
	
	private void pack() {
		for(UICallback uic : subscribedUI) {
			uic.pack();
		}
	}
	private void setCardPane(CardPane cp) {
		for(UICallback uic : subscribedUI) {
			uic.setCardPane(cp);
		}
	}
}
