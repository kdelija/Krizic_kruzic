package view;

/**
 * Sucelje koje osluškuje dogadaje u klasi ButtonsEvent
 *  
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 */

import java.util.EventListener;

public interface ButtonsEventListener extends EventListener{
	
	public void buttonsEventOcured(ButtonsEvent bue);

}
