package client.model.deck;

import org.w3c.dom.Element;
import shared.control.Parser;
import client.model.list.ClientCardList;
import client.model.list.ClientVisibleCardList;
import client.model.list.ClientNonVisibleCardList;
import shared.model.player.PlayerType;

/** A ClientDeck is a list of all of a player's card
 * including their hand, grave, active cards, and the remaing stack of cards to draw from
 */
public class ClientDeck{
	ClientCardList stack;
	ClientCardList hand;
	ClientCardList active;
	ClientCardList grave;

	/** Constructor for the deck, makes an 
	 * empty deck with the given number of cards
	 * @param numCards how many cards deck cardlist should start with
	 * @param pType what type of player this is (me or them)
	 * @return the new ClientDeck
	 */
	public ClientDeck(int numCards, PlayerType pType){
		stack = new ClientNonVisibleCardList(0);
		active = new ClientVisibleCardList(0);
		grave = new ClientVisibleCardList(0);
		if(pType==PlayerType.me){
			hand = new ClientVisibleCardList(0);
		}
		else{
			hand = new ClientNonVisibleCardList(0);
		}
	}

	/** serializes the deck into an xml string
	 * @return the xml string
	 */
	public String xmlOutput(){
		String xml = "";
		xml += "<stack>";
		xml += stack.xmlOutput();
		xml += "</stack>";
		xml += "<hand>";
		xml += hand.xmlOutput();
		xml += "</hand>";
		xml += "<active>";
		xml += active.xmlOutput();
		xml += "</active>";
		xml += "<grave>";
		xml += grave.xmlOutput();
		xml += "</grave>";
		return xml;
	}

	/** reads in a dom element and populates the deck
	 * @param parser the parser used to parse the element
	 * @param ele the element to populate off of
	 */
	public void xmlInput(Parser parser, Element ele){
		stack.xmlInput(parser, parser.eleParseElement(ele,"stack"));
		hand.xmlInput(parser, parser.eleParseElement(ele,"hand"));
		active.xmlInput(parser, parser.eleParseElement(ele,"active"));
		grave.xmlInput(parser, parser.eleParseElement(ele,"grave"));
	}
}