import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public class Output {
	
	/**
	 * This method is creator of the output file
	 */
	public void Output(){
		try{PrintWriter write = new PrintWriter("output.txt", "UTF-8");}
		catch (IOException e) {}
	}
	
	
	/**
	 * This method is adding (writing) new lines in the output text file which has been created before
	 * 
	 * @param line the line as string that we want to add the text file
	 */
	public void writeMethod(String line){
		
		
		try{
				FileWriter out = new FileWriter("output.txt", true);
			    BufferedWriter bufferedwriter = new BufferedWriter(out);
			
			    
				bufferedwriter.write(line);
				bufferedwriter.newLine();
				bufferedwriter.close();
			   
			} 
		
		catch (IOException e) {
		}
		
	}

}
