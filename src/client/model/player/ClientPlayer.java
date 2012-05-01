package client.model.player;

import org.w3c.dom.Element;
import shared.control.Parser;
import shared.model.constants.Constants;
import shared.model.player.Player;

/** ClientPlayer is the model of a player
* on the client end
*/
public class ClientPlayer extends Player{

	/** Constructor for the ClientPlayer
	* @param name the name of the player to create
	*/
	public ClientPlayer(String newName){
		super(newName);
	}
}
