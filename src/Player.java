import java.util.ArrayList;
import java.util.UUID;

public class Player {
	private Ship patrolBoat = new PatrolBoat();
	private Ship destroyer = new Destroyer();
	private Ship submarine = new Submarine();
	private Ship battleship = new BattleshipShip();
	private Ship ac = new AircraftCarrier();
	private ArrayList<Ship> shipList = new ArrayList<Ship>();
	public UUID id = UUID.randomUUID();
	
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
