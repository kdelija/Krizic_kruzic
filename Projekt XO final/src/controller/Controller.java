package controller;

import java.util.ArrayList;

import model.Database;
import model.Player;
import view.NewPlayerEvent;



/**
 * Controller komunicira s bazom podataka Database koja predstavlja skup
 * objekata tipa Player. 
 *  
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 * 
 */
public class Controller {
	
	private Database database;
	private Player player;
	
	
	
	public Controller() {
		// TODO Auto-generated constructor stub
		
		database = new Database();
	}
	
	/**
	 * Metoda kojom se dodaje novokreirani Player u bazu podataka
	 * @param npe je objekt klase NewPlayerEvent
	 */
	public void addPlayer(NewPlayerEvent npe) {
		
		
		player = new Player(npe.getName());
		database.addPlayers(player);
	}
	
	public ArrayList<Player> getDatabase() {
		
		return database.getAllPlayers();
	}
	
	/**
	 * Metoda dohvaca  velicinu baze podataka
	 * @return int predstavlja broj igraca u bazi podataka
	 */
	public int databaseSize() {
		
		return database.numOfPlayers();
	}

	
	
	
}
