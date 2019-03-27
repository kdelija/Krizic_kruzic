package view;

import java.util.EventObject;

/**
 * GameEvent sprema dvije varijble sa imenima igraca nakon svakog
 * aktiviranja ActionListenera na JButtunu Nova Igra
 * 
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 *
 */

public class GameEvent extends EventObject{
	
	private String plyOneName;
	private String plyTwoName;

	
	public GameEvent(Object source) {
		// TODO Auto-generated constructor stub
		
		super(source);
	}


	public String getPlyOneName() {
		return plyOneName;
	}


	public void setPlyOneName(String plyOneName) {
		this.plyOneName = plyOneName;
	}


	public String getPlyTwoName() {
		return plyTwoName;
	}


	public void setPlyTwoName(String plyTwoName) {
		this.plyTwoName = plyTwoName;
	}


}
