
/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 * @see https://en.wikipedia.org/wiki/Javadoc#Technical_architecture
 */


public class Main {


	/**
	  * This is the main method(starting point) of this program
	  * 
	  * @author Berk Gulay <berkgulay1997@gmail.com>
	  * 
	  * @since 2016.03.17
	  * 
	  * @param args This is the parameter of main method and starter of this code blocks
	  */
	public static void main(String[] args) {

		TextFileReader fileReader = new TextFileReader();
		
		Game game= new Game();
		game.play(fileReader.readFile(args[0]),game);
		
	}

}
