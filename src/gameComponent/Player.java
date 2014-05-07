package gameComponent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import ships.AircraftCarrier;
import ships.BattleshipShip;
import ships.Destroyer;
import ships.PatrolBoat;
import ships.Ship;
import ships.Submarine;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Ship patrolBoat = new PatrolBoat();
	private Ship destroyer = new Destroyer();
	private Ship submarine = new Submarine();
	private Ship battleship = new BattleshipShip();
	private Ship ac = new AircraftCarrier();
	public ArrayList<Ship> shipList = new ArrayList<Ship>();
	public UUID id = UUID.randomUUID();
	public boolean shipsPlaced = false;
	
	public Player() {
		shipList.add(patrolBoat);
		shipList.add(destroyer);
		shipList.add(submarine);
		shipList.add(battleship);
		shipList.add(ac);
	}
	
	public boolean equals(Player p) {
		return this.id.equals(p.id);
	}
}
