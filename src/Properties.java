import java.util.ArrayList;

/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public abstract class Properties {
	
	/**
	 * This method is finding the right property and doing the right operation(money and set operations) for this property
	 * 
	 * @param p player which is playing one 
	 * @param ps  player which is not playing one
	 * @param banker banker of this game
	 * @param position position of the playing player
	 * @param dice dice of this turn
	 * @param propertiesNumber property arraylist which includes the number of properties
	 * @param propertiesName property arraylist which includes the name(id) of properties
	 * @param propertiesCost property arraylist which includes the cost of properties
	 * @param game game object that we play right now
	 * 
	 */
	public abstract String propertyFunc(Players p,Players ps,Players banker,int position,int dice,ArrayList<Integer> propertiesNumber,ArrayList<String> propertiesName,ArrayList<Integer> propertiesCost,Game game);
}