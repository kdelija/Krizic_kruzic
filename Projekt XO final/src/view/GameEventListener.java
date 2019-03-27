package view;

import java.util.EventListener;

/**
 * Sucelje koje osluškuje dogadaje u klasi GameEvent
 *  
 * @author kdellija
 * @version 1.0
 * @since rujan, 2018
 */

public interface GameEventListener extends EventListener{
	
	public void gameEventOccured(GameEvent gme);
}
