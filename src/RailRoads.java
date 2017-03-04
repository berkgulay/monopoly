import java.util.ArrayList;

/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public class RailRoads extends Properties {
	
	/**
	 * 
	 * This method gives us an integer number for calculating the rent of railways
	 * <p>
	 * 
	 * @since 2016.04.12
	 * 
	 * @param ps This method takes an enemy player
	 * 
	 * @return It returns number of the enemy's rail roads for rent calculation
	 * 
	 */
	public int railRoadCounter(Players ps){
		int numberOfRailRoads=0;
		String[] railRoadNamesArray={"Kings Cross Station","Marylebone Station","Fenchurch St Station","Liverpool Street Station"};
		for(int i=0;i<railRoadNamesArray.length;i++){
			if(ps.getProperty().contains(railRoadNamesArray[i])){numberOfRailRoads++;}
		}
		
		return numberOfRailRoads;
	}

	
	@Override
	public String propertyFunc(Players p, Players ps, Players banker, int position, int dice,
			ArrayList<Integer> railRoadsNumber, ArrayList<String> railRoadsName, ArrayList<Integer> railRoadsCost,Game game) {
		Players p1;
		Players p2;
		if(p.getName().equals("Player 1")){p1=p;p2=ps;}
		else{p1=ps;p2=p;}
		
		int place=railRoadsNumber.indexOf(position);
		
		if(ps.getProperty().contains(railRoadsName.get(place))){
			int rent=railRoadCounter(ps)*25;
			if(p.getMoney()<rent){
				game.setBankruptController(true);
				return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
				
			}
			else{
			p.setMoney(p.getMoney()-rent);
			ps.setMoney(ps.getMoney()+rent);
			return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" paid rent for "+railRoadsName.get(place));
			}
		}
		else{
			if(p.getProperty().contains(railRoadsName.get(place))){
				return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" has "+railRoadsName.get(place));
			}
			
			else{
				int price=railRoadsCost.get(place);
				if(p.getMoney()<price){
					game.setBankruptController(true);
					return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
					
				}
				else{
				p.setMoney(p.getMoney()-price);
				banker.setMoney(banker.getMoney()+price);
				p.setProperty(railRoadsName.get(place));
				return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" bought "+railRoadsName.get(place));
				}
			}

		}
		
		
	}




}
