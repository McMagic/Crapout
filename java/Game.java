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
	private passLine passLineBet; //pass line bet (betID = 0)
	private DontPassLine dontPassLineBet; //dont pass line bet (betID = 1)
	

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
		
		if (point == 0){
			dontPassLineBet.setActive(true);
		}
		
		//Check point values to set whether or not a bet is active (based on type of bet) 
	}
	
	/*setPlayerBets method: sets the betAmount for 1 particular type of bet indicated by betID 
	 *						subtracts bet amount from player's overall balance (playerBal)
	 * 						Note: first argument (betAmt) is an array of bet values for that specific bet
	 */
	public void setPlayerBets(int[] betAmt, int betID) {
		setActiveBets();
		switch (betID){
			case 0: //Pass line bet 
				passLineBet.setBetAmount(betAmt[0]); 
				playerBal -= betAmt[0]; 
				break;
			
			case 1: //Don't pass line bet 
				dontPassLineBet.setBetAmount(betAmt[0]);
				playerBal -= betAmt[0];
				break;
		}
		
		/*
		//Setting passline bets
		passLineBet.setBetAmount(betAmt[0]); //put money into bet
		playerBal -= betAmt[0]; //Subtract bet amount from player's current balance 
		
		//Setting dontpassline bet 
		dontPassLineBet.setBetAmount(betAmt[1]); //put money into bet
		playerBal -= betAmt[1]; 
		*/
		
		
		//Get user input 
		//Set the bets 
		
		//Remember that certain bets can only be made at certain times in the game
	}
	
	public void printPlayerBets(){
		System.out.println("Current player's pass line bet amount: " + passLineBet.getBetAmount());
		System.out.println("Current player's don't pass line bet amount: " + dontPassLineBet.getBetAmount());
	}
	
	public void getPlayerBetsOutcome(int[] rollArray){
		passLineBet.checkBetOutcome(rollArray, button, point); 
		dontPassLineBet.checkBetOutcome(rollArray, button, point);

		/*if (passLineBet.getActive()){
			passLineBet.checkBetOutcome(rollArray, button, point);
		}
		else if (dontPassLineBet.getActive()){
			dontPassLineBet.checkBetOutcome(rollArray, button, point);
		}
		*/
	}
	
	public void getPlayerBetsPayOut(){
		int payout = 0; 
		
		//Update with payout from pass line bet 
		payout += passLineBet.getPayOut(); 
		System.out.println("Payout from passLine: " + passLineBet.getPayOut());

		
		//Update with payout from don't pass line bet 
		payout += dontPassLineBet.getPayOut(); 
		System.out.println("Payout from don't pass line bet: " + dontPassLineBet.getPayOut()); 
		
		//Increment payout for all other bets.... 
		playerBal += payout; 
		
	}
	/*
	public int[] getBetInput(int betID) {
		//Declare and init string variables that store user input
		String str = ""; 
		String amt = "";
		
		
		//Get user input and save input into betInput
		BufferedReader keyboard = 
			new BufferedReader(new InputStreamReader(System.in)); 
		
		
		
		switch (betID) {
			  case 0: //Pass Line Bet 
				//Declare myBets array
				int[] myBets = new int[1];
				
			  	while (true) {
					//Prompt user
					System.out.println("Would you like to make a Passline Bet? (y/n)");
					System.out.println("NOTE: Must have minimum Passline Bet of $5 in order to roll");
					System.out.println("Current amount on pass line: " + passLineBet.betAmount);
					
					//Read in Choice from user
					str = keyboard.readLine();
					
					
					//If user wants to make passline bet
					if (str.equals("y") ) {
						System.out.println("Please enter the amount for the Passline Bet: ");
						amt = keyboard.readLine();
						//Read value into array
						myBets[0] = Integer.parseInt(amt);
						
						return myBets;
					}
					//else if user does not want to make passline bet
					else if (str.equals("n") ) {
						myBets[0] = -1;
						
						return myBets;
					}
					//If y or n was not typed in 
					else {
						System.out.println("This is not a valid input. Please type in valid input.");
					}
				}
				break;
			  case 1: //Dont Pass Line Bet
				//Declare myBets array
				int[] myBets2 = new int[1];
				
				while (true) {
					//Prompt user
					System.out.println("Would you like to make a Don't Pass Line Bet? (y/n)");
					System.out.println("Current amount on Don't Pass Line Bet: " + dontPassLineBet.betAmount);
					
					//Read in Choice from user
					str = keyboard.readLine();
					
					//If user wants to make passline bet
					if (str.equals("y") ) {
						System.out.println("Please enter the amount for the Don't Pass Line Bet: ");
						amt = keyboard.readLine();
						//Read value into array
						myBets2[0] = Integer.parseInt(amt);
						
						return myBets2;
					}
					//else if user does not want to make passline bet
					else if (str.equals("n") ) {
						myBets2[0] = -1;
						
						return myBets2;
					}
					//If y or n was not typed in 
					else {
						System.out.println("This is not a valid input. Please type in valid input.");
					}
				}
				break;
				
			  default: //Default case do nothing
		} //End of switch block

	}
	*/
	public void playRound(){
		
		dice.roll(); //roll the dice 
		getPlayerBetsOutcome(dice.getRollArray());	//update the different bet objects (updates the payout and betAmount fields)
		getPlayerBetsPayOut();	//update the player balance with the pay out of the different bets (updates the player's balance with the payouts)
		
		
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
		//Reset point to 0 if 7 is rolled 
		else if ((point != 0) && (diceArray[0]+diceArray[1] == 7)){
			point = 0;
		}		
		//Reset point to 0 if point is rolled
		else if ((point != 0) && (diceArray[0]+diceArray[1] == point)){
			point = 0;
		}
	}	
	
    public static void main(String args[]) throws IOException {
	
		//Variable declarations
		String str = ""; 
		int[] myBets = new int[6]; //The size of this array will change as we implement more bets
		Game craps = new Game();
		int betInput = 0;
		
		//Get user input and save input into betInput
		BufferedReader keyboard = 
			new BufferedReader(new InputStreamReader(System.in)); 
		
		
		System.out.println ("Starting Current balance = " + craps.playerBal);
		System.out.println("Would you like to start? (y/n)");
		str = keyboard.readLine();
		if (str.equals("y")){
			while (!str.equals("") && !str.equals("n"))
			{
				/** Point HAS NOT been set **/ 
				if (craps.getPoint() == 0){
					//Populate pass line bet 
					System.out.println("Please enter the amount for the Pass Line bet: ");
					str = keyboard.readLine();
					betInput = Integer.parseInt(str); 
					myBets[0] = betInput; 
					craps.setPlayerBets(myBets, 0);
					
					//Populate don't pass line bet
					System.out.println("Please enter the amount for the Don't Pass Line Bet: ");
					str = keyboard.readLine(); 
					betInput = Integer.parseInt(str);
					myBets[0] = betInput;
					craps.setPlayerBets(myBets, 1);
				}			
				
				/** Point HAS been set **/ 
				else {
				/*
				
					//Prompt user for pass line bet
					myBets = craps.getBetInput(0);
					if (myBets[0] != -1){
						craps.setPlayerBets(myBets, 0);
					}
					
					
					//Prompt user for don't pass line bet 
					myBets = craps.getBetInput(1);
					if (myBets[0] != -1){
						craps.setPlayerBets(myBets, 1);
					}
					*/
					
				}
				
				System.out.println("********************** ROUND STARTS HERE ***************************");
				System.out.println("Player's bet amounts before round:");
				craps.printPlayerBets();
				System.out.println("");
				System.out.println("Player Balance before roll " + craps.getPlayerBal()); 
				craps.playRound(); 
				System.out.println("Player Balance after roll " + craps.getPlayerBal());
				System.out.println("Point: " + craps.getPoint()); 
				System.out.println("Player's bet amounts after round:");
				craps.printPlayerBets();
				System.out.println("");
				System.out.println("Do you want to roll again (any key to continue or enter/n to exit): ");
				str=keyboard.readLine();
			}
		}
    }
}			
			


