import java.util.ArrayList;

/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public class Lands extends Properties {

	@Override
	public String propertyFunc(Players p, Players ps, Players banker, int position, int dice, ArrayList<Integer> landsNumber,
			ArrayList<String> landsName, ArrayList<Integer> landsCost,Game game) {
		Players p1;
		Players p2;
		if(p.getName().equals("Player 1")){p1=p;p2=ps;}
		else{p1=ps;p2=p;}
		
		int place=landsNumber.indexOf(position);
		int rent=0;
		if(ps.getProperty().contains(landsName.get(place))){
			
			if(landsCost.get(place)<=2000){rent=landsCost.get(place)*40/100;}
			else{
				if(landsCost.get(place)<=3000){rent=landsCost.get(place)*30/100;}
				else{
					if(landsCost.get(place)<=4000){rent=landsCost.get(place)*35/100;}
				}
			}
			if(p.getMoney()<rent){
				game.setBankruptController(true);
				return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
				
			}
			else{
			p.setMoney(p.getMoney()-rent);
			ps.setMoney(ps.getMoney()+rent);
			return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" paid rent for "+landsName.get(place));
			}
		}
		else{
			if(p.getProperty().contains(landsName.get(place))){
				return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" has "+landsName.get(place));
			}
			
			else{
				int price=landsCost.get(place);
				if(p.getMoney()<price){
					game.setBankruptController(true);
					return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
					
				}
				else{
					p.setMoney(p.getMoney()-price);
					banker.setMoney(banker.getMoney()+price);
					p.setProperty(landsName.get(place));
					return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" bought "+landsName.get(place));
				}
			}
		}
	
	}

}
