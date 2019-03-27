package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Baza podataka koja sadrzi listu tipa Player
 * 
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 *
 */

public class Database {
	
private ArrayList<Player> playerList;
	
	
	public Database() {
		
		playerList = new ArrayList<>();
	}
	
	
	/**
	 * Metoda za dodavanje igraca u ArrayListu
	 * @param ply prima objekt klase Player
	 */
	public void addPlayers(Player ply) {
		
		playerList.add(ply);
	}
	
	public ArrayList<Player> getAllPlayers() {
		return playerList;
	}
	
	
	/**
	 * Metoda vraca broj igraca u Listi
	 * @return
	 */
	public int numOfPlayers() {
		
		return playerList.size();
	}

}
