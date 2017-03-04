import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 */



public class TextFileReader {
	
	private ArrayList<String> command=new ArrayList<String>();
	
	/**
	 * 
	 * This method gives us an string array list that includes the lines of a file which we give as a parameter.
	 * <p>
	 * This is method for reading a file and return its lines in an array list.It returns a String array list and this array list includes
	 * these lines in String format.So we can use a text file and its lines.Method gives us a chance for reading lines and keep them
	 * in memory for manupulating and using them in some way.
	 * 
	 * @since 2016.04.12
	 * 
	 * @param path This method takes a file path as parameter
	 * 
	 * @return It returns a String array list(command) which has got lines of a file
	 * 
	 * @throws IOException If the file doesn't exist or it can't be founded method throws a file exception to warn us	
	 */
	public ArrayList<String> readFile(String path){
		try{
			
			for (String line : Files.readAllLines(Paths.get(path))) {
				command.add(line);
			}
		
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		return command;
		
	}

		
	
}
