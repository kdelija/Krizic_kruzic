package view;

import java.util.EventObject;

/**
 * NewPlayerEvent prima podatke (String name) od NewPlayerFrame-a
 * kako bi ih mogli dohvatiti u MainFrameu
 * 
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 */

public class NewPlayerEvent extends EventObject{
	
	private String name;
	
	public NewPlayerEvent(Object source) {
		// TODO Auto-generated constructor stub
		
		super(source);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
