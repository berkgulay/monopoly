/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public class Banker extends Players {
	
	/**
	 * This method is constractor of banker and for initializing player2
	 * 
	 * @param name name of banker
	 * @param money money of banker
	 * @param position position of banker
	 */
	public Banker(String name, int money, int position) {
		super(name, money, position);
	}

	
	@Override
	public String show() {
		String outputString1="Banker"+"\t"+getMoney();
		
		return outputString1;
	}


}
