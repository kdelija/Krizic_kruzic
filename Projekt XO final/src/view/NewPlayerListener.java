package view;

import java.util.EventListener;

/**
 * Sucelje koje osluškuje dogadaje u klasi NewPlayerEvent
 *  
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 */

public interface NewPlayerListener extends EventListener{
	
	public void newPlayerEventOcured (NewPlayerEvent npe);
}
