/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public class Player2 extends Players {

	/** 
	 * @param name name of player2
	 * @param money money of player2
	 * @param position position of player2
	 * 
	 * This method is constractor of player2 and for initializing player2
	 */
	public Player2(String name, int money, int position) {
		super(name, money, position);
	}

	
	@Override
	public String show() {
		String have=" ";
		for(int i=0;i<getProperty().size();i++){
			have+=getProperty().get(i)+",";
		}
		String outputString="Player 2"+"\t"+getMoney()+"\t"+"have:"+have;
		
		return outputString;
	}


}
