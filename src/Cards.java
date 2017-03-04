import java.util.ArrayList;

/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public abstract class Cards {
	
	/**
	 * This method is finding the right property and doing the right operation(money and set operations) for this property
	 * 
	 * @param p player which is playing one
	 * @param ps player which is the other one who is not playing one
	 * @param banker banker of the game
	 * @param dice dice number for this turn
	 * @param list card list for search the right object(card)
	 * @param output object for writing the text file
	 * @param game our game object just for this game
	 * 
	 */
	public abstract void cardFunc(Players p,Players ps,Players banker,int dice,ArrayList<String> list,Output output,Game game);
	
}
