package view;

import java.util.EventObject;

/**
 * ButtonsEvent sprema ime pobjednika 
 * 
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 *
 */

public class ButtonsEvent extends EventObject{
	
	private String winnerName;
	
	public ButtonsEvent(Object source) {
		// TODO Auto-generated constructor stub
		
		super(source);
	}

	public String getWinnerName() {
		return winnerName;
	}

	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}
	
	

}
