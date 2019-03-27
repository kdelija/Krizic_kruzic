package model;

/**
 * Klasa sadrži podatke potrebne za instanciranje objekta Player
 * 
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 *
 */

public class Player {
	
	private int id;
	private static int counter = 1;
	private String name;
	private int numOfWins = 0;
	
	/**
	 * Konstruktor instancira objekt tipa Player sa imenom name. 
	 * Svaka instanca Playera dobiva jedinstveni id koji se inkrementira
	 * @param name ime igraca
	 */
	public Player(String name) {
		// TODO Auto-generated constructor stub
		
		this.id = counter;
		this.name = name;
		
		counter++;
	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumOfWins() {
		return numOfWins;
	}


	public void setNumOfWins(int numOfWins) {
		this.numOfWins += numOfWins;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
