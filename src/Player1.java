/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public class Player1 extends Players {

	/**
	 * This method is constractor of player2 and for initializing player2
	 * 
	 * @param name name of player1
	 * @param money money of player1
	 * @param position position of player1
	 */
	public Player1(String name, int money, int position) {
		super(name, money, position);
	}



	@Override
	public String show() {
		String have=" ";
		for(int i=0;i<getProperty().size();i++){
			have+=getProperty().get(i)+",";
		}
		String outputString="Player 1"+"\t"+getMoney()+"\t"+"have:"+have;
		
		return outputString;
	}


}
