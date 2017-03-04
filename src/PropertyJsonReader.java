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
public class PropertyJsonReader {
	private ArrayList<Integer> landsNumber=new ArrayList<Integer>();
	/**
	 * This method is getter of land's number array list
	 * @return land's number array list
	 */
	public ArrayList<Integer> getLandsNumber() {return landsNumber;}
	/**
	 * This method is setter of land's number array list
	 */
	public void setLandsNumber(int i) {landsNumber.add(i);}

	private ArrayList<String> landsName=new ArrayList<String>();
	/**
	 * This method is getter of land's name array list
	 * @return land's name array list
	 */
	public ArrayList<String> getLandsName() {return landsName;}
	/**
	 * This method is setter of land's name array list
	 */
	public void setLandsName(String str) {landsName.add(str);}

	private ArrayList<Integer> landsCost=new ArrayList<Integer>();
	/**
	 * This method is getter of land's cost array list
	 * @return land's cost array list
	 */
	public ArrayList<Integer> getLandsCost() {return landsCost;}
	/**
	 * This method is setter of land's cost array list
	 */
	public void setLandsCost(int i) {landsCost.add(i);}

	private ArrayList<Integer> companiesNumber=new ArrayList<Integer>();
	/**
	 * This method is getter of company's number array list
	 * @return company's number array list
	 */
	public ArrayList<Integer> getCompaniesNumber() {return companiesNumber;}
	/**
	 * This method is setter of company's number array list
	 */
	public void setCompaniesNumber(int i) {companiesNumber.add(i);}

	private ArrayList<String> companiesName=new ArrayList<String>();
	/**
	 * This method is getter of company's name array list
	 * @return company's name array list
	 */
	public ArrayList<String> getCompaniesName() {return companiesName;}
	/**
	 * This method is setter of company's name array list
	 */
	public void setCompaniesName(String str) {companiesName.add(str);}

	private ArrayList<Integer> companiesCost=new ArrayList<Integer>();
	/**
	 * This method is getter of company's cost array list
	 * @return company's cost array list
	 */
	public ArrayList<Integer> getCompaniesCost() {return companiesCost;}
	/**
	 * This method is setter of company's cost array list
	 */
	public void setCompaniesCost(int i) {companiesCost.add(i);}

	private ArrayList<Integer> railRoadsNumber=new ArrayList<Integer>();
	/**
	 * This method is getter of rail road's number array list
	 * @return rail road's number array list
	 */
	public ArrayList<Integer> getRailRoadsNumber() {return railRoadsNumber;}
	/**
	 * This method is setter of rail road's number array list
	 */
	public void setRailRoadsNumber(int i) {railRoadsNumber.add(i);}

	private ArrayList<String> railRoadsName=new ArrayList<String>();
	/**
	 * This method is getter of rail road's name array list
	 * @return rail road's name array list
	 */
	public ArrayList<String> getRailRoadsName() {return railRoadsName;}
	/**
	 * This method is setter of rail road's name array list
	 */
	public void setRailRoadsName(String str) {railRoadsName.add(str);}

	private ArrayList<Integer> railRoadsCost=new ArrayList<Integer>();
	/**
	 * This method is getter of rail road's cost array list
	 * @return rail road's cost array list
	 */
	public ArrayList<Integer> getRailRoadsCost() {return railRoadsCost;}
	/**
	 * This method is setter of rail road's cost array list
	 */
	public void setRailRoadsCost(int i) {railRoadsCost.add(i);}
	
	/**
	 * 
	 * This method is filling the property array list in the game by reading the json file for properties.
	 * 
	 * @since 2016.04.12
	 * 
	 * @param path This method takes a file path as parameter
	 * 
	 * @throws IOException If the file doesn't exist or it can't be founded method throws a file exception to warn us	
	 * @throws FileNotFoundException If there is no such a file
	 * @throws ParseException If json object is not be able to be parsed. 
	 */
	public void propertyJsonReader(String path){
		JSONParser parser = new JSONParser();
		
		
		try{
			Object obj = parser.parse(new FileReader(path));
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray list1 = (JSONArray) jsonObject.get("1");
			JSONArray list2 = (JSONArray) jsonObject.get("2");
			JSONArray list3 = (JSONArray) jsonObject.get("3");
			
			for (int i = 0; i < list1.size(); ++i) {
			    JSONObject any1 = (JSONObject) list1.get(i);
			    String id1 = (String) any1.get("id");
			    String name1 = (String) any1.get("name");
			    String cost1 = (String) any1.get("cost");
			    landsNumber.add(Integer.parseInt(id1));
			    landsName.add(name1);
			    landsCost.add(Integer.parseInt(cost1));
			}
			
			for (int n = 0; n < list2.size(); ++n) {
			    JSONObject any2 = (JSONObject) list2.get(n);
			    String id2 = (String) any2.get("id");
			    String name2 = (String) any2.get("name");
			    String cost2 = (String) any2.get("cost");
			    railRoadsNumber.add(Integer.parseInt(id2));
			    railRoadsName.add(name2);
			    railRoadsCost.add(Integer.parseInt(cost2));
			}
			
			for (int k = 0; k < list3.size(); ++k) {
			    JSONObject any3 = (JSONObject) list3.get(k);
			    String id3 = (String) any3.get("id");
			    String name3 = (String) any3.get("name");
			    String cost3 = (String) any3.get("cost");
			    companiesNumber.add(Integer.parseInt(id3));
			    companiesName.add(name3);
			    companiesCost.add(Integer.parseInt(cost3));
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
