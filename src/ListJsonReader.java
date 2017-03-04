import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public class ListJsonReader {
	private ArrayList<String> communityChests=new ArrayList<String>();
	/**
	 * This method is getter of communitychest cards array list
	 * @return Community Chest cards Array List
	 */
	public ArrayList<String> getCommunityChests() {return communityChests;}
	/**
	 * This method is setter of communitychest cards array list
	 */
	public void setCommunityChests(String str) {communityChests.add(str);}
	
	private ArrayList<String> chances=new ArrayList<String>();
	/**
	 * This method is getter of chance cards array list
	 * @return Chance cards Array List
	 */
	public ArrayList<String> getChances() {return chances;}
	/**
	 * This method is setter of chance cards array list
	 */
	public void setChances(String str) {chances.add(str);}
	
	
	/**
	 * 
	 * This method is filling the card array list in the game by reading the json file for cards.
	 * 
	 * @since 2016.04.12
	 * 
	 * @param path This method takes a file path as parameter
	 * 
	 * @throws IOException If the file doesn't exist or it can't be founded method throws a file exception to warn us	
	 * @throws FileNotFoundException If there is no such a file
	 * @throws ParseException If json object is not be able to be parsed. 
	 */
	public void listJsonReader(String path){
		JSONParser parser = new JSONParser();
		
		try{
			Object obj = parser.parse(new FileReader(path));
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray chanceList = (JSONArray) jsonObject.get("chanceList");
			JSONArray communityChestList = (JSONArray) jsonObject.get("communityChestList");
			
			 
			 
			 
			 for (int i = 0; i < chanceList.size(); i++) {
				    JSONObject any = (JSONObject) chanceList.get(i);
				    String chanceItem = (String) any.get("item");
				    chances.add(chanceItem);
				}
			 
			 for (int n = 0; n < communityChestList.size(); n++) {
				    JSONObject any2 = (JSONObject) communityChestList.get(n);
				    String communityChestItem = (String) any2.get("item");
				    communityChests.add(communityChestItem);
				}
			 
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
