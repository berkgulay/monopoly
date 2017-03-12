import java.util.ArrayList;


/**
 * @author Berk Gulay berkgulay1997@gmail.com
 * 
 * @since 2016.04.12
 * 
 */
public class Game {
	
	Players player1=new Player1("Player 1",15000,1);
	Players player2=new Player2("Player 2",15000,1);
	Banker banker=new Banker("Banker",100000,0);
	Cards chances = new Chance();
	Cards communityChests = new CommunityChest();
	Lands lands = new Lands();
	RailRoads railRoads = new RailRoads();
	Companies companies = new Companies();
	ListJsonReader cards=new ListJsonReader();
	PropertyJsonReader properties=new PropertyJsonReader();
	Output output=new Output();
	
	private Boolean bankruptController=false;
	/**
	 * 
	 * This is the getter of bankrupt controller boolean value
	 * @return Bankrupt Controller for this game's end situation
	 */
	public Boolean getBankruptController() {return bankruptController;}
	/**
	 * This is the setter of bankrupt controller boolean value
	 */
	public void setBankruptController(Boolean bankruptController) {this.bankruptController = bankruptController;}
	
	/**
	 * 
	 * This method is checking the players position and directing him/her to the right function or doing some operations according to place and money
	 * 
	 * @since 2016.04.12
	 * 
	 * @param p This method takes an player which is playing at that turn
	 * @param dice This method takes an dice number as integer
	 * @param game This is the game object which we have been playing
	 */
	public void game(Players p,int dice,Game game){
		int initialPosition=p.getPosition();
		
		Players p1;
		Players p2;
		if(p.getName().equals("Player 1")){p1=p;p2=player2;}
		else{p1=player1;p2=p;}
		
		if(p.getPosition()==11){
			if(p.getCounter()==3){
				p.setCounter(0);;
				p.setPosition(11+dice);
				output.writeMethod((action(p,ps,dice,game)));//OTHER PART
			}
			else{
			p.setCounter(p.getCounter()+1);;
			output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" in jail "+"(count="+p.getCounter()+")");
			}
		}
		
		else{
			p.setPosition((p.getPosition()+dice)%40);
			if(p.getPosition()==0){p.setPosition(40);}
			
			if(p.getPosition()==11){
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" went to jail");
			}
			
			else if(properties.getLandsNumber().contains(p.getPosition())){
				if(initialPosition>p.getPosition()){
					p.setMoney(p.getMoney()+200);
					banker.setMoney(banker.getMoney()-200);
				}
				output.writeMethod(lands.propertyFunc(p, ps, banker, p.getPosition(), dice, properties.getLandsNumber(), properties.getLandsName(), properties.getLandsCost(),game));
			}
			
			else if(properties.getRailRoadsNumber().contains(p.getPosition())){
				if(initialPosition>p.getPosition()){
					p.setMoney(p.getMoney()+200);
					banker.setMoney(banker.getMoney()-200);
				}
				output.writeMethod(railRoads.propertyFunc(p, ps, banker, p.getPosition(), dice, properties.getRailRoadsNumber(), properties.getRailRoadsName(), properties.getRailRoadsCost(),game));
			}
			
			else if(properties.getCompaniesNumber().contains(p.getPosition())){
				if(initialPosition>p.getPosition()){
					p.setMoney(p.getMoney()+200);
					banker.setMoney(banker.getMoney()-200);
				}
				output.writeMethod(companies.propertyFunc(p, ps, banker, p.getPosition(), dice, properties.getCompaniesNumber(), properties.getCompaniesName(), properties.getCompaniesCost(),game));
			}
			
			else if(p.getPosition()==8 || p.getPosition()==23 || p.getPosition()==37){
				if(initialPosition>p.getPosition()){
					p.setMoney(p.getMoney()+200);
					banker.setMoney(banker.getMoney()-200);
				}
				chances.cardFunc(p,ps, banker,dice, cards.getChances(),output,game);
			}
			
			else if(p.getPosition()==3 || p.getPosition()==18 || p.getPosition()==34){
				if(initialPosition>p.getPosition()){
					p.setMoney(p.getMoney()+200);
					banker.setMoney(banker.getMoney()-200);
				}
				communityChests.cardFunc(p, ps, banker,dice, cards.getCommunityChests(),output,game);
			}
			
			else if(p.getPosition()==5 || p.getPosition()==39){
				if(initialPosition>p.getPosition()){
					p.setMoney(p.getMoney()+200);
					banker.setMoney(banker.getMoney()-200);
				}
				if(p.getMoney()<100){
					output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" goes bankrupt!");	
					setBankruptController(true);
				}
				else{
				p.setMoney(p.getMoney()-100);
				banker.setMoney(banker.getMoney()+100);
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" paid tax");
				}
			}
			
			else  if(p.getPosition()==21){
				if(initialPosition>p.getPosition()){
					p.setMoney(p.getMoney()+200);
					banker.setMoney(banker.getMoney()-200);
				}
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" is in Free Parking");
			}
			
			else if(p.getPosition()==1){
				if(initialPosition>p.getPosition()){
					p.setMoney(p.getMoney()+200);
					banker.setMoney(banker.getMoney()-200);
				}
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" is in Go Square");
			}
			
			else if(p.getPosition()==31){
				p.setPosition(11); //JAIL
				output.writeMethod(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" went to jail");
			}
		}
	}
	
	/**
	 * 
	 * This method is checking the players position after the jail part and directing him/her to the right function or doing some operations according to place and money 
	 * 
	 * @since 2016.04.12
	 * 
	 * @param p This method takes an player which is playing at that turn
	 * @param po This method takes an player which is not playing at that turn(enemy player)
	 * @param dice This method takes an dice number as integer
	 * @param game This is the game object which we have been playing
	 * 
	 * @return It returns an output string for write it in game function
	 */
	public String action(Players p,Players po,int dice,Game game){
		int initialPosition=p.getPosition();
		
		Players p1;
		Players p2;
		if(p.getName().equals("Player 1")){p1=p;p2=po;}
		else{p1=po;p2=p;}
		
		if(properties.getLandsNumber().contains(p.getPosition())){
			if(initialPosition>p.getPosition()){
				p.setMoney(p.getMoney()+200);
				banker.setMoney(banker.getMoney()-200);
			}
			return(lands.propertyFunc(p, po, banker, p.getPosition(), dice, properties.getLandsNumber(), properties.getLandsName(), properties.getLandsCost(),game));
		}
		
		else if(properties.getRailRoadsNumber().contains(p.getPosition())){
			if(initialPosition>p.getPosition()){
				p.setMoney(p.getMoney()+200);
				banker.setMoney(banker.getMoney()-200);
			}
			return(railRoads.propertyFunc(p, po, banker, p.getPosition(), dice, properties.getRailRoadsNumber(), properties.getRailRoadsName(), properties.getRailRoadsCost(),game));
		}
		
		else if(properties.getCompaniesNumber().contains(p.getPosition())){
			if(initialPosition>p.getPosition()){
				p.setMoney(p.getMoney()+200);
				banker.setMoney(banker.getMoney()-200);
			}
			return(companies.propertyFunc(p, po, banker, p.getPosition(), dice, properties.getCompaniesNumber(), properties.getCompaniesName(), properties.getCompaniesCost(),game));
		}
		
		else if(p.getPosition()==23){
			if(initialPosition>p.getPosition()){
				p.setMoney(p.getMoney()+200);
				banker.setMoney(banker.getMoney()-200);
			}
			chances.cardFunc(p,po, banker,dice, cards.getChances(),output,game);
		}
		
		else if(p.getPosition()==18){
			if(initialPosition>p.getPosition()){
				p.setMoney(p.getMoney()+200);
				banker.setMoney(banker.getMoney()-200);
			}
			communityChests.cardFunc(p, po, banker,dice, cards.getCommunityChests(),output,game);
		}
		
		
		else  if(p.getPosition()==21){
			if(initialPosition>p.getPosition()){
				p.setMoney(p.getMoney()+200);
				banker.setMoney(banker.getMoney()-200);
			}
			return(p.getName()+"\t"+dice+"\t"+p.getPosition()+"\t"+p1.getMoney()+"\t"+p2.getMoney()+"\t"+p.getName()+" is in Free Parking");
		}
		
		return "";
	}
	
	/**
	 * 
	 * This method is checking the players name and taking the right dice number for this player and directing the player to game function for operations
	 * 
	 * @since 2016.04.12
	 * 
	 * @param commandArray This method takes an array list that includes the command lines for this game
	 * @param game This is the game object which we have been playing
	 */
	public void play(ArrayList<String> commandArray,Game game){
		cards.listJsonReader("list.json");
		properties.propertyJsonReader("property.json");
		for (int i=0;i<commandArray.size();i++){
			if(bankruptController){}
			else{
				if (commandArray.get(i).split(";")[0].equals("Player 1")){
					game(player1,Integer.parseInt(commandArray.get(i).split(";")[1]),game);
				}
				
				else if(commandArray.get(i).split(";")[0].equals("Player 2")){
					game(player2,Integer.parseInt(commandArray.get(i).split(";")[1]),game);
				}
					
				else{
					String winner="";
					if (player1.getMoney()<player2.getMoney()){winner+="Winner " + player2.getName();}
					else if(player1.getMoney()>player2.getMoney()){winner+="Winner " + player1.getName();}
					else if(player1.getMoney()==player2.getMoney()){winner+=player1.getName()+" is draw with "+player2.getName();}
						
					output.writeMethod("--------------------------------------------------------------------------------------------------------------------------------");
					output.writeMethod(player1.show()); 
					output.writeMethod(player2.show()); 
					output.writeMethod(banker.show());
					output.writeMethod(winner);
					output.writeMethod("--------------------------------------------------------------------------------------------------------------------------------");
				}
			}
			
		}
		
		String winner="";
		if (player1.getMoney()<player2.getMoney()){winner+="Winner " + player2.getName();}
		else if(player1.getMoney()>player2.getMoney()){winner+="Winner " + player1.getName();}
		else if(player1.getMoney()==player2.getMoney()){winner+=player1.getName()+" is draw with "+player2.getName();}
		
		output.writeMethod("--------------------------------------------------------------------------------------------------------------------------------");
		output.writeMethod(player1.show()); 
		output.writeMethod(player2.show()); 
		output.writeMethod(banker.show());
		output.writeMethod(winner);
		
		
	}

}
