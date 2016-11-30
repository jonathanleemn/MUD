package entities;

public class QuestGiver extends NPC {

	public QuestGiver(){
		setDescription("An upstanding looking townsfolk");
	}
	
	public void giveQuest(){
		System.out.println("Good day, Adventurer! I require your assistance.");
		System.out.println("Would you kindly return my lost goblet to me?");
		System.out.println("It's shiny, and silver. I'll reward you accordlingly!");
	}
	
	public void repeatScript(){
		System.out.println("Have you found my goblet yet?");
	}
	
	public void finishQuest(){
		System.out.println("You found it! Oh thank you, thank you, thank you!");
		System.out.println("Now I can finally drink my tea!");
		
	}
}
