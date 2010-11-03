/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Oct 21, 2010
 * Time: 12:54:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    private boolean button; //indicator of whether or not a point is set 
    private int playerBal; //current balance of the player 
    private Dice dice; //dice
    private int point; //point 
	private passLine passLineBet; //pass line bet

	//Default constructor 
	public Game() {
        this.button = true;
        this.playerBal = 1000;
        this.dice = new Dice();
        this.point = 0;
		passLineBet = new passLine(0);
    }
	
	//Getters 
	public boolean getButton(){
		return button;
	}
	public int getPlayerBal(){
		return playerBal;
	}
	public Dice getDice(){
		return dice;
	}
    public int getPoint() {
        return point;
    }
	
	
	//Setters 
	public void setButton(boolean newButton) {
        button = newButton;
    }
	public void setPlayerBal(int newPlayerBal) {
        playerBal = newPlayerBal;
    }
    public void setPoint(int newPoint) {
        point = newPoint;
    }

	public void setActiveBets(){
		//Check for pass line bet 
		if (point == 0) {
			passLineBet.setActive(true); 
		}
		
		//Check point values to set whether or not a bet is active (based on type of bet) 
	}
	public void setPlayerBets(int[] betAmt) {
		setActiveBets();
		passLineBet.setBetAmount(betAmt[0]); //put money into bet
		playerBal -= betAmt[0]; //Subtract bet amount from player's current balance 
		//Get user input 
		//Set the bets 
		
		//Remember that certain bets can only be made at certain times in the game
	}
	
	public void getPlayerBetsOutcome(int[] rollArray){
		if (passLineBet.getActive()){
			passLineBet.checkBetOutcome(rollArray, button, point);
		}
	}
	
	public void getPlayerBetsPayOut(){
		int payout = 0; 
		payout += passLineBet.getPayOut(); 
		System.out.println("\npayout from passLine " + passLineBet.getPayOut());
		//Increment payout for all other bets.... 
		playerBal += payout; 
	}
	
	public void playRound(){
		
		dice.roll(); 	//roll the dice 
		getPlayerBetsOutcome(dice.getRollArray());	//update the different bet objects 
		getPlayerBetsPayOut();	//update the player balance with the pay out of the different bets 
		if (point == 0) { //Set point 
			int[] diceArray = dice.getRollArray();
			System.out.print("Die 1 = " + diceArray[0]);
			System.out.print("\nDie 2 = " + diceArray[1]);
			int diceVal = diceArray[0] + diceArray[1];
			//If dice roll is valid, set the point 
			if (diceVal != 7 || diceVal != 11 || diceVal !=2 || diceVal != 3 || diceVal != 12){
				point = diceVal; 
			}
		}
		

	}	
    public static void main(String args[]){
		int[] myBets = new int[] {10};
		//while (toPlay)
		//{
			Game craps = new Game(); 
			System.out.println("\nPlayer Balance start " + craps.getPlayerBal()); 
			craps.setPlayerBets(myBets); //populate the different bet objects
			craps.playRound(); 
			System.out.println("\nPlayer Balance end " + craps.getPlayerBal());
			System.out.println("Point " + craps.getPoint()); 
		//}
		
		
		//While user wants to play craps, ask user if they want to continue playing craps
		/*
        //Start of Game
        craps.dice.roll();
        craps.processRole();
		*/

    }
}
