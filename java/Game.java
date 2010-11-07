/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Oct 21, 2010
 * Time: 12:54:16 PM
 * To change this template use File | Settings | File Templates.
 */
 
import java.io.*; 
import java.util.*; 
 
public class Game {
    private boolean button; //indicator of whether or not a point is set 
    private int playerBal; //current balance of the player 
    private Dice dice; //dice
    private int point; //point 
	private passLine passLineBet; //pass line bet
	private DontPassLine dontPassLineBet; 
	

	//Default constructor 
	public Game() {
        this.button = true;
        this.playerBal = 1000;
        this.dice = new Dice();
        this.point = 0;
		passLineBet = new passLine(0);
		dontPassLineBet = new DontPassLine(0);
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
		
		//Setting passline bets
		passLineBet.setBetAmount(betAmt[0]); //put money into bet
		playerBal -= betAmt[0]; //Subtract bet amount from player's current balance 
		
		//Setting dontpassline bet 
		dontPassLineBet.setBetAmount(betAmt[1]); //put money into bet
		playerBal -= betAmt[1]; 
		
		
		//Get user input 
		//Set the bets 
		
		//Remember that certain bets can only be made at certain times in the game
	}
	
	public void printPlayerBets(){
		System.out.println("Current player's pass line bet amount: " + passLineBet.getBetAmount());
		System.out.println("Current player's don't pass line bet amount: " + dontPassLineBet.getBetAmount());
	}
	
	public void getPlayerBetsOutcome(int[] rollArray){
		if (passLineBet.getActive()){
			passLineBet.checkBetOutcome(rollArray, button, point);
		}
	}
	
	public void getPlayerBetsPayOut(){
		int payout = 0; 
		payout += passLineBet.getPayOut(); 
		System.out.println("Payout from passLine: " + passLineBet.getPayOut());
		//Increment payout for all other bets.... 
		playerBal += payout; 
	}
	
	public void playRound(){
		
		dice.roll(); 	//roll the dice 
		getPlayerBetsOutcome(dice.getRollArray());	//update the different bet objects 
		getPlayerBetsPayOut();	//update the player balance with the pay out of the different bets 
		
		
		//Testing 
		int[] diceArray = dice.getRollArray();
		System.out.println("Die 1 = " + diceArray[0]);
		System.out.println("Die 2 = " + diceArray[1]);
		
		if (point == 0) { //Set point if valid roll 
			int diceVal = diceArray[0] + diceArray[1];
			//If dice roll is valid, set the point 
			if (diceVal != 7 && diceVal != 11 && diceVal !=2 && diceVal != 3 && diceVal != 12){
				System.out.println("Setting point");
				point = diceVal; 
			}
		}
		

	}	
    public static void main(String args[]) throws IOException {
	
		//Variable declarations
		String str = ""; 
		int[] myBets = new int[2]; //The size of this array will change as we implement more bets
		Game craps = new Game();
		int betInput = 0;
		
		//Get user input and save input into betInput
		BufferedReader keyboard = 
			new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.println ("Current balance = " + craps.playerBal);
		System.out.println("Please enter the amount for the Passline Bet: "); 
		str = keyboard.readLine();
		
		while (!str.equals(""))
		{
			if (!str.equals("0")){
				betInput = Integer.parseInt(str);
			
				/** Populate myBets array **/
				//Populate with pass line bet
				myBets[0] = betInput; 
			}
			
			
			//Populate with dont pass line bet 
			System.out.println("Please enter amount for Dont Pass Line bet: "); 
			str = keyboard.readLine();
			if (!str.equals("0")){
				betInput = Integer.parseInt(str); 
				myBets[1] = betInput;
			}
			
			//Populate the different bet objects
			craps.setPlayerBets(myBets);
			System.out.println("********************** ROUND STARTS HERE ***************************");
			System.out.println("Bet input for pass line bet: " + myBets[0]);
			System.out.println("Bet input for don't pass line bet: " + myBets[1]);
			System.out.println("Player Balance before roll " + craps.getPlayerBal()); 
			craps.playRound(); 
			System.out.println("Player Balance after roll " + craps.getPlayerBal());
			System.out.println("Point: " + craps.getPoint()); 
			craps.printPlayerBets();
			System.out.println("Please enter amount for the Passline bet (Press enter to exit): ");
			str=keyboard.readLine();
		}
    }
}
