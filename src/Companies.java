import java.util.ArrayList;

/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public class Companies extends Properties {

	@Override
	public String propertyFunc(Players p, Players ps, Players banker, int position, int dice,
			ArrayList<Integer> companiesNumber, ArrayList<String> companiesName, ArrayList<Integer> companiesCost,Game game) {
		Players p1;
		Players p2;
		if(p.getName().equals("Player 1")){p1=p;p2=ps;}
		else{p1=ps;p2=p;}
		
		int place=companiesNumber.indexOf(position);
		
		if(ps.getProperty().contains(companiesName.get(place))){
			int rent=dice*4;
			if(p.getMoney()<rent){
				game.setBankruptController(true);
				return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
			}
			else{
			p.setMoney(p.getMoney()-rent);
			ps.setMoney(ps.getMoney()+rent);
			return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" paid rent for "+companiesName.get(place));
			}
		}
		else{
			if(p.getProperty().contains(companiesName.get(place))){
				return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" has "+companiesName.get(place));
			}
			
			else{
				int price=companiesCost.get(place);
				if(p.getMoney()<price){
					game.setBankruptController(true);
					return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
				}
				else{
					p.setMoney(p.getMoney()-price);
					banker.setMoney(banker.getMoney()+price);
					p.setProperty(companiesName.get(place));
					return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" bought "+companiesName.get(place));
				}
			}
		}
	}

}
