import java.util.ArrayList;

/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public class CommunityChest extends Cards {

	@Override
	public void cardFunc(Players p,Players ps ,Players banker,int dice, ArrayList<String> list,Output output,Game game) {
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
		else if(list.get(0).equals("Bank error in your favor – collect $75")){
			p.setMoney(p.getMoney()+75);
			banker.setMoney(banker.getMoney()-75);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Bank error in your favor , collect $75");
		}
		else if(list.get(0).equals("Doctor's fees – Pay $50")){
			if(p.getMoney()<50){
				game.setBankruptController(true);
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
			}
			else{
			p.setMoney(p.getMoney()-50);
			banker.setMoney(banker.getMoney()+50);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Doctor's fees , Pay $50");
			}
		}
		else if(list.get(0).equals("It is your birthday Collect $10 from each player")){
			p.setMoney(p.getMoney()+10);
			ps.setMoney(ps.getMoney()-10);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw It is your birthday Collect $10 from each player");

		}
		else if(list.get(0).equals("Grand Opera Night – collect $50 from every player for opening night seats")){
			p.setMoney(p.getMoney()+50);
			ps.setMoney(ps.getMoney()-50);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Grand Opera Night , collect $50 from every player for opening night seats");

		}
		else if(list.get(0).equals("Income Tax refund – collect $20")){
			p.setMoney(p.getMoney()+20);
			banker.setMoney(banker.getMoney()-20);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Income Tax refund , collect $20");

		}
		else if(list.get(0).equals("Life Insurance Matures – collect $100")){
			p.setMoney(p.getMoney()+100);
			banker.setMoney(banker.getMoney()-100);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Life Insurance Matures , collect $100");

		}
		else if(list.get(0).equals("Pay Hospital Fees of $100")){
			if(p.getMoney()<100){
				game.setBankruptController(true);
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
			}
			else{
			p.setMoney(p.getMoney()-100);
			banker.setMoney(banker.getMoney()+100);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" Pay Hospital Fees of $100");
			}
		}
		else if(list.get(0).equals("Pay School Fees of $50")){
			if(p.getMoney()<50){
				game.setBankruptController(true);
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
			}
			else{
			p.setMoney(p.getMoney()-50);
			banker.setMoney(banker.getMoney()+50);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw Pay School Fees of $50");
			}
		}
		else if(list.get(0).equals("You inherit $100")){
			p.setMoney(p.getMoney()+100);
			banker.setMoney(banker.getMoney()-100);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw You inherit $100");

		}
		else{
			p.setMoney(p.getMoney()+50);
			banker.setMoney(banker.getMoney()-50);
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" draw From sale of stock you get $50");

		}
		
		String firstCard=list.get(0);
		list.remove(0);
		list.add(firstCard);
	
	}

}
