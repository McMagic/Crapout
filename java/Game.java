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
	private int dontComePoint; //point set for Don't Come bets
	private passLine passLineBet; //pass line bet (betID = 0)
	private DontPassLine dontPassLineBet; //dont pass line bet (betID = 1)
	private placeBet placeBets; //Place bets (betID = 2)
	private DontCome dontComeBet; //Dont come bet (betID = 3)
	private Hardway hardwayBet; //Hardway bet (betID = 4)
	private Proposition propBets; //Proposition (betID = 5)



	//Default constructor 
	public Game() {
        this.button = true;
        this.playerBal = 1000;
        this.dice = new Dice();
        this.point = 0;
		this.dontComePoint = 0;
        
        //Create instances of each bet class
		passLineBet = new passLine(0);
		dontPassLineBet = new DontPassLine(0);
		placeBets = new placeBet();
		dontComeBet = new DontCome(0);
		hardwayBet = new Hardway();
		propBets = new Proposition();
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
	public int getDontComePoint(){
		return dontComePoint;
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
	public void setDontComePoint(int newPoint){
		dontComePoint = newPoint;
	}

	public void setActiveBets(){
		//Check for pass line bet 
		if (point == 0) {
			passLineBet.setActive(true); 
		}
		
		if (point == 0){
			dontPassLineBet.setActive(true);
		}
		
		//Check too see if place bets are active
		//NOTE: Place bets can only be made when the point is set
		if (point != 0) {
			placeBets.setActive(true);
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
				passLineBet.setBetAmount(betAmt); 
				playerBal -= betAmt[0]; 
				break;
			
			case 1: //Don't pass line bet 
				dontPassLineBet.setBetAmount(betAmt);
				playerBal -= betAmt[0];
				break;
				
			case 2: //Make place Bets
				placeBets.setBetAmount(betAmt);
				playerBal -= betAmt[0] + betAmt[1] + betAmt[2] + betAmt[3] + betAmt[4] + betAmt[5];
				break;
			case 3: //Make Don't Come Bet 
				dontComeBet.setBetAmount(betAmt); 
				playerBal -= betAmt[0];
				break;
			case 4: //Hardway Bet 
				hardwayBet.setBetAmount(betAmt); 
				playerBal -= betAmt[0] + betAmt[1] + betAmt[2] + betAmt[3];
				break;
			case 5: //Proposition Bets 
				propBets.setBetAmount(betAmt); 
				playerBal -= betAmt[0] + betAmt[1] + betAmt[2] + betAmt[3] + betAmt[4] +betAmt[5];
				break;
		}
		
		
		//Remember that certain bets can only be made at certain times in the game
	}
	
	public void printPlayerBets() {
		//Pass Line 
		System.out.println("Current player's pass line bet amount: $" + passLineBet.getBetAmount());
		//Dont Pass Line
		System.out.println("Current player's don't pass line bet amount: $" + dontPassLineBet.getBetAmount());
		
		
		
		//Place Bets
		System.out.println("Current player's place bet amounts:");
		System.out.println("----Money on 4: $" + placeBets.getMoneyOnFour() );
		System.out.println("----Money on 5: $" + placeBets.getMoneyOnFive() );
		System.out.println("----Money on 6: $" + placeBets.getMoneyOnSix() );
		System.out.println("----Money on 8: $" + placeBets.getMoneyOnEight() );
		System.out.println("----Money on 9: $" + placeBets.getMoneyOnNine() );
		System.out.println("----Money on 10: $" + placeBets.getMoneyOnTen() );

		//Don't come bet 
		System.out.println("Current player's don't come bet amount: $" +dontComeBet.getBetAmount());
		
		
		//Hardway Bet
		System.out.println("Current player's hardway bet amounts:");
		System.out.println("----Money on Hard 4: $" + hardwayBet.getMoneyOnFour() );
		System.out.println("----Money on Hard 6: $" + hardwayBet.getMoneyOnSix() );
		System.out.println("----Money on Hard 8: $" + hardwayBet.getMoneyOnEight() );
		System.out.println("----Money on Hard 10: $" + hardwayBet.getMoneyOnTen() );
		
		
		//Proposition Bets
		System.out.println("Current player's proposition bet amounts:");
		System.out.println("----Money on Any 7: $" + propBets.getAnySevenMoney() );
		System.out.println("----Money on Any Craps: $" + propBets.getAnyCrapsMoney() );
		System.out.println("----Money on Craps Two: $" + propBets.getCrapsTwoMoney() );
		System.out.println("----Money on Craps Three: $" + propBets.getCrapsThreeMoney() );
		System.out.println("----Money on Craps Twelve: $" + propBets.getCrapsTwelveMoney() );
		System.out.println("----Money on Yo Eleven: $" + propBets.getYoElevenMoney() );

		
	}
	
	public void getPlayerBetsOutcome(int[] rollArray){
		passLineBet.checkBetOutcome(rollArray, button, point); 
		dontPassLineBet.checkBetOutcome(rollArray, button, point);
		placeBets.checkBetOutcome(rollArray, button, point);
		dontComeBet.checkBetOutcome(rollArray, button, dontComePoint);
		hardwayBet.checkBetOutcome(rollArray, button, point);
		propBets.checkBetOutcome(rollArray, button, point);
	}
	
	public void getPlayerBetsPayOut(){
		int payout = 0; 
		
		//Update with payout from pass line bet 
		payout += passLineBet.getPayOut(); 
		System.out.println("Payout from passLine: " + passLineBet.getPayOut());

		
		//Update with payout from don't pass line bet 
		payout += dontPassLineBet.getPayOut(); 
		System.out.println("Payout from don't pass line bet: " + dontPassLineBet.getPayOut()); 
		
		//Update with payout from place bet 
		payout += placeBets.getPayOut(); 
		System.out.println("Payout from place bets: " + placeBets.getPayOut()); 
		
		//Update with payout from dontComeBet
		payout += dontComeBet.getPayOut(); 
		System.out.println("Payout from dont come bet: " + dontComeBet.getPayOut());
		
		//Update with payout from hardway bet
		payout += hardwayBet.getPayOut(); 
		System.out.println("Payout from hardway bet: " + hardwayBet.getPayOut());

		//Update with payout from proposition bets
		payout += propBets.getPayOut(); 
		System.out.println("Payout from proposition bets: " + propBets.getPayOut());
		
		
		//Increment payout for all other bets.... 
		playerBal += payout; 
		
	}
	
	//getBetInput: Used to read in bet input amounts from user, store them in an array, and return that array
	public int[] getBetInput(int betID) throws IOException{
		//Declare and init string variables that store user input
		String str = ""; 
		String amt = "";
		int betInput;
		
		
		//Get user input and save input into betInput
		BufferedReader keyboard = 
			new BufferedReader(new InputStreamReader(System.in)); 
		
		int[] myBets = new int[6]; //The size of this array will change as we implement more bets
		//Init. Array values to 0
		for (int x=0; x< myBets.length; x++) {
         	myBets[x] = 0;
		}
		
		
		
		if (betID == 0) //Pass Line Bet
		{
			//Populate pass line bet 
			System.out.println("Please enter the amount for the Pass Line bet: ");
			str = keyboard.readLine();
			betInput = Integer.parseInt(str); 
			myBets[0] = betInput; 
			return myBets;
		} //End of Pass Line Bet
		else if (betID == 1) //Don't Pass Line Bet
		{
			//Populate don't pass line bet
			System.out.println("Please enter the amount for the Don't Pass Line Bet: ");
			str = keyboard.readLine(); 
			betInput = Integer.parseInt(str);
			myBets[0] = betInput;
			return myBets;
		} //End of Don't Pass Line Bet
		else if (betID == 2) //Place Bets
		{
			//Reset str back to NULL string
			str = "";
			
			while (!str.equals("n")) //While the user is still making Place bets
			{				
				//Prompt user for input
				System.out.println("Make any Place Bets you like");
				System.out.println("To make a Place Bet, type the # you want to bet on followed by the amount to bet on it.");
				System.out.println("For example: To bet $100 on 4, I would type 4 100. I also use this command to add to an existing place bet.");
				System.out.println("For example: To remove $100 on 4, I would type 4 -100.");
				System.out.println("To stop making Place Bets, type n and hit enter.");
				//Read in user input
				str = keyboard.readLine(); 
				String result[] = str.split("\\s");
				
				if (result[0].equals("4")) //If the Place bet is for the number 4
				{ 
					betInput = Integer.parseInt(result[1]);
					myBets[0] = myBets[0] + betInput; 
				}
				else if (result[0].equals("5")) //If the Place bet is for the number 5
				{
					betInput = Integer.parseInt(result[1]);
					myBets[1] = myBets[1] + betInput; 
				}
				else if (result[0].equals("6")) //If the Place bet is for the number 6
				{
					betInput = Integer.parseInt(result[1]);
					myBets[2] = myBets[2] + betInput; 
				}
				else if (result[0].equals("8")) //If the Place bet is for the number 8
				{
					betInput = Integer.parseInt(result[1]);
					myBets[3] = myBets[3] + betInput; 
				}
				else if (result[0].equals("9")) //If the Place bet is for the number 9
				{
					betInput = Integer.parseInt(result[1]);
					myBets[4] = myBets[4] + betInput; 
				}
				else if (result[0].equals("10")) //If the Place bet is for the number 10
				{
					betInput = Integer.parseInt(result[1]);
					myBets[5] = myBets[5] + betInput; 
				}
			
			} //End of while loop
			
			return myBets;
			
		} //End of place Bets
		else if (betID == 3){	//don't come bet 
		
			//Populate don't come bet
			System.out.println("Please enter the amount for the Don't Come Bet: ");
			str = keyboard.readLine(); 
			betInput = Integer.parseInt(str);
			myBets[0] = betInput;
			dontComeBet.setState(1); //activate the dontComeBet
			return myBets;
		}
		else if (betID == 4){	//Hardway Bets
		
			//Reset str back to NULL string
			str = "";
			
			while (!str.equals("n")) //While the user is still making Hardway bets
			{				
				//Prompt user for input
				System.out.println("Make any Hardway Bets you like");
				System.out.println("To make a Hardway Bet, type the # you want to bet on followed by the amount to bet on it.");
				System.out.println("For example: To bet $100 on Hard 4, I would type 4 100. I also use this command to add to an existing hardway bet.");
				System.out.println("For example: To remove $100 on Hard 4, I would type 4 -100.");
				System.out.println("To stop making Hardway Bets, type n and hit enter.");
				//Read in user input
				str = keyboard.readLine(); 
				String result[] = str.split("\\s");
				
				if (result[0].equals("4")) //If the hardway bet is for 4
				{ 
					betInput = Integer.parseInt(result[1]);
					myBets[0] = myBets[0] + betInput; 
				}
				else if (result[0].equals("6")) //If the hardway bet is for 6
				{
					betInput = Integer.parseInt(result[1]);
					myBets[1] = myBets[1] + betInput; 
				}
				else if (result[0].equals("8")) //If the hardway bet is for 8
				{
					betInput = Integer.parseInt(result[1]);
					myBets[2] = myBets[2] + betInput; 
				}
				else if (result[0].equals("10")) //If the hardway bet is for 10
				{
					betInput = Integer.parseInt(result[1]);
					myBets[3] = myBets[3] + betInput; 
				}
			
			} //End of while loop
			
			return myBets;
		}
		else if (betID == 5){	//Proposition Bets
			
			//Reset str back to NULL string
			str = "";
			
			while (!str.equals("n")) //While the user is still making Hardway bets
			{				
				//Prompt user for input
				System.out.println("Make any Proposition Bets you like");
				System.out.println("To make a Proposition Bet, type the # you want to bet on followed by the amount to bet on it.");
				System.out.println("# of Bet Key (this key tells you what # corresponds to what type of proposition bet:");
				System.out.println("7----Any Seven:");
				System.out.println("1----Any Craps:");
				System.out.println("2----Craps Two");
				System.out.println("3----Craps Three");
				System.out.println("12---Craps Twelve");
				System.out.println("11---Yo Eleven");
				System.out.println("For example: To bet $100 on Any Craps, I would type 1 100. I also use this command to add to an existing bet.");
				System.out.println("For example: To remove $100 on Any Craps, I would type 1 -100.");
				System.out.println("To stop making Proposition Bets, type n and hit enter.");
				//Read in user input
				str = keyboard.readLine(); 
				String result[] = str.split("\\s");
				
				if (result[0].equals("7")) //Any Seven
				{ 
					betInput = Integer.parseInt(result[1]);
					myBets[0] = myBets[0] + betInput; 
				}
				else if (result[0].equals("1")) //Any Craps
				{
					betInput = Integer.parseInt(result[1]);
					myBets[1] = myBets[1] + betInput; 
				}
				else if (result[0].equals("2")) //Craps Two
				{
					betInput = Integer.parseInt(result[1]);
					myBets[2] = myBets[2] + betInput; 
				}
				else if (result[0].equals("3")) //Craps Three
				{
					betInput = Integer.parseInt(result[1]);
					myBets[3] = myBets[3] + betInput; 
				}
				else if (result[0].equals("12")) //Craps Twelve
				{
					betInput = Integer.parseInt(result[1]);
					myBets[4] = myBets[4] + betInput; 
				}
				else if (result[0].equals("11")) //Yo Eleven
				{
					betInput = Integer.parseInt(result[1]);
					myBets[5] = myBets[5] + betInput; 
				}
				
			} //End of while loop
			
			return myBets;
		}
		
		
		return myBets; //Default return statement
	}
	
	
	
	
	public void playRound(){
		
		dice.roll(); //roll the dice 
		getPlayerBetsOutcome(dice.getRollArray());	//update the different bet objects (updates the payout and betAmount fields)
		getPlayerBetsPayOut();	//update the player balance with the pay out of the different bets (updates the player's balance with the payouts)
		
		
		//Testing 
		int[] diceArray = dice.getRollArray();
		System.out.println("Die 1 = " + diceArray[0]);
		System.out.println("Die 2 = " + diceArray[1]);
		int diceVal = diceArray[0] + diceArray[1];
		
		if (point == 0) { //Set point if valid roll 
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
		
		//Setting the don't come point 
		if ((dontComePoint == 0) && (dontComeBet.getState() == 1)){
			if (diceVal  != 2 && diceVal != 3 && diceVal != 7 && diceVal != 12){
				System.out.println("Setting don't come point"); 
				dontComePoint = diceVal;
				dontComeBet.setState(2);
			}
		}
		//Reset dont come point to 0 if 7 is rolled
		else if ((dontComePoint != 0) && (dontComeBet.getState() == 2) && (diceVal == 7)){
			dontComePoint = 0;
			dontComeBet.setState(0);
		}
		//Reset dont come point to 0 if dont come point is rolled
		else if ((dontComePoint != 0) && (dontComeBet.getState() == 2) && (diceVal == dontComePoint)){
			dontComePoint = 0;
			dontComeBet.setState(0);
		}
	}	
	
    public static void main(String args[]) throws IOException {
	
		//Variable declarations
		String str = ""; 
		Game craps = new Game();
		int betInput = 0;
		int[] myBets = new int[6];
		
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
					//Set Pass Line bet
					myBets = craps.getBetInput(0);
					craps.setPlayerBets(myBets, 0);
					
					//Set Dont Pass line bet
					myBets = craps.getBetInput(1);
					craps.setPlayerBets(myBets, 1);
					
				}			
				/** Point HAS been set **/ 
				else {
					//Set the place bet 
					myBets = craps.getBetInput(2);
					craps.setPlayerBets(myBets, 2);
					
					//Set the don't come bet 
					if (craps.dontComeBet.getState() == 0){
						myBets = craps.getBetInput(3); 
						craps.setPlayerBets(myBets, 3);
					}
					
					
				}
				
				/** The following bets can be made at anytime, regardless of whether the point is set or not **/
				
				//Set the Hardway bet (bet can be made at anytime)
				myBets = craps.getBetInput(4);
				craps.setPlayerBets(myBets, 4);
				
				//Set the Proposition Bets (can be made at anytime)
				myBets = craps.getBetInput(5);
				craps.setPlayerBets(myBets, 5);

				
				
				
				
				
				
				
				/*********OUTPUT*************/
				
				System.out.println(); //Prints an empty line for readability purposes
				System.out.println("********************** ROUND STARTS HERE ***************************");
				System.out.println("Player's bet amounts before round:");
				craps.printPlayerBets();
				System.out.println(); //Prints an empty line for readability purposes
				System.out.println("Player Balance before roll " + craps.getPlayerBal()); 
				System.out.println("********************** ROUND PLAYED ***************************");
				craps.playRound();
				System.out.println("Player Balance after roll " + craps.getPlayerBal());
				System.out.println("Point: " + craps.getPoint()); 
				System.out.println("Player's bet amounts after round:");
				craps.printPlayerBets();
				System.out.println("");
				System.out.println("Do you want to roll again (any key to continue or enter/n to exit): ");
				str=keyboard.readLine();
				System.out.println(); //Prints an empty line for readability purposes
			}
		}
    }
}			
			


