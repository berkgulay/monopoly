import java.util.*;

/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public abstract class Players {
	
	private String name;
	/**
	 * This method is getter of player name
	 * @return name of player
	 */
	public String getName() {return name;}
	
	private int money;
	/**
	 * This method is getter of player money
	 * @return money of player
	 */
	public int getMoney() {return money;}
	/**
	 * This method is setter of player money
	 */
	public void setMoney(int money) {this.money = money;}
	
	private int position;
	/**
	 * This method is getter of player position
	 * @return position of player
	 */
	public int getPosition() {return position;}
	/**
	 * This method is setter of player position
	 */
	public void setPosition(int position) {this.position = position;}
	
	private int counter=0;
	/**
	 * This method is getter of player counter
	 * @return jail counter for player
	 */
	public int getCounter() {return counter;}
	/**
	 * This method is setter of player counter
	 */
	public void setCounter(int counter) {this.counter = counter;}
	
	private ArrayList<String> property=new ArrayList<String>();
	/**
	 * This method is getter of player's properties
	 * @return property array list for player which he/she had
	 */
	public ArrayList<String> getProperty() {return property;}
	/**
	 * This method is setter of player's properties
	 */
	public void setProperty(String str) {property.add(str);}
	
	/**
	 * This method is constractor of player and initializing Players
	 * 
	 * @param name name of this player
	 * @param money money of this player
	 * @param position position of this player
	 */
	public Players(String name, int money, int position) {
		this.name = name;
		this.money = money;
		this.position = position;
	}
	
	/**
	 * This method shows player's feature and situation 
	 */
	public abstract String show();
	
	
	
}
