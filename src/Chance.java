import java.util.ArrayList;

/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public class Chance extends Cards {

	@Override
	public void cardFunc(Players p,Players ps,Players banker,int dice,ArrayList<String> list,Output output,Game game) {
		Players p1;
		Players p2;
		if(p.getName().equals("Player 1")){p1=p;p2=ps;}
		else{p1=ps;p2=p;}
		
		if(list.get(0).equals("Advance to Go (Collect $200)")){
			p.setPosition(1);
			p.setMoney(p.getMoney()+200);
			banker.setMoney(banker.getMoney()-200);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Advance to Go (Collect $200)");		
		}
		else if(list.get(0).equals("Advance to Leicester Square")){
			p.setPosition(27);
			if(ps.getProperty().contains("Leicester Square")){
				if(p.getMoney()<780){
					game.setBankruptController(true);
					output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
				}
				else{
				p.setMoney(p.getMoney()-(780));
				ps.setMoney(ps.getMoney()+(780));
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Advance to Leicester Square, "+p.getName()+" paid rent for Leicester Square");
				}
			}
			else if(p.getProperty().contains("Leicester Square")){output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Advance to Leicester Square, "+p.getName()+" has Leicester Square");}
			else{
				if(p.getMoney()<2600){
					game.setBankruptController(true);
					output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
				}
				else{
				p.setProperty("Leicester Square");
				p.setMoney(p.getMoney()-2600);
				banker.setMoney(banker.getMoney()+2600);
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Advance to Leicester Square, "+p.getName()+ " bought Leicester Square");
				}
			}
		}
		else if(list.get(0).equals("Go back 3 spaces")){
			p.setPosition(p.getPosition()-3);
			if (p.getPosition()==5){
				if(p.getMoney()<100){
					game.setBankruptController(true);
					output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Go back 3 spaces, goes bankrupt!");	
					
				}
				else{
				p.setMoney(p.getMoney()-100);
				banker.setMoney(banker.getMoney()+100);
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Go back 3 spaces, paid tax");
				}
			}
			else if(p.getPosition()==20){
				if(ps.getProperty().contains("Vine Street")){
					if(p.getMoney()<800){
						game.setBankruptController(true);
						output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
					}
					else{
					p.setMoney(p.getMoney()-800);
					ps.setMoney(ps.getMoney()+800);
					output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Go back 3 spaces, paid rent for Vine Street");
					}
				}
				else if (p.getProperty().contains("Vine Street")){
					output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Go back 3 spaces, has Vine Street");
				}
				else{
					if(p.getMoney()<2000){
						game.setBankruptController(true);
						output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
					}
					else{
					p.setMoney(p.getMoney()-2000);
					banker.setMoney(banker.getMoney()+2000);
					output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Go back 3 spaces, bought Vine Street");
					}
				}
			}
			else if(p.getPosition()==34){
				game.communityChests.cardFunc(p, ps, banker, dice, game.cards.getCommunityChests(),output, game);
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Go back 3 spaces, draw CommunityChest card");
			}
			
		}
		else if(list.get(0).equals("Pay poor tax of $15")){
			if(p.getMoney()<15){
				game.setBankruptController(true);
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
			}
			else{
			p.setMoney(p.getMoney()-15);
			banker.setMoney(banker.getMoney()+15);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Pay poor tax of $15");
			}
		}
		else if(list.get(0).equals("Your building loan matures – collect $150")){
			p.setMoney(p.getMoney()+150);
			banker.setMoney(banker.getMoney()-150);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Your building loan matures , collect $150");

		}
		else{
			p.setMoney(p.getMoney()+100);
			banker.setMoney(banker.getMoney()-100);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw You have won a crossword competition , collect $100");
		}
		
		String firstCard=list.get(0);
		list.remove(0);
		list.add(firstCard);

	}

}
