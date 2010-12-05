/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Oct 21, 2010
 * Time: 12:54:16 PM
 * To change this template use File | Settings | File Templates.
 */

package net.rallyedu.Crapout;

public class Game {
    private static boolean button = true;       //indicator of whether or not a point is set
    private static int playerBal = 1000;        //current balance of the player
    private static Dice dice = new Dice();      //dice
    private static int point = 0;               //point
	private static PassLine passLineBet = new PassLine(0); //pass line bet (betID = 0)
	private static DontPassLine dontPassLineBet = new DontPassLine(0); //dont pass line bet (betID = 1)
	private static PlaceBet placeBets = new PlaceBet(); //Place bets (betID = 2)
	private static DontCome dontComeBet = new DontCome(0); //Dont come bet (betID = 3)
	private static Hardway hardwayBet = new Hardway(); //Hardway bet (betID = 4)
	private static Proposition propBets = new Proposition(); //Proposition (betID = 5)
	private static Come comeBet = new Come(0); //Come bet (betID = 6)
	private static Field fieldBet = new Field(0); //Field (betID = 7)


	//Default constructor
    /*
	public Game() {

    }
	  */
	//Getters 
	public static boolean getButton(){
		return button;
	}
	public static int getPlayerBal(){
		return playerBal;
	}
	public static Dice getDice(){
		return dice;
	}
    public static int getPoint() {
        return point;
    }

    public static int getComePoint(){
        return comeBet.getComePoint();
    }
    public static int getDontComePoint(){
        return dontComeBet.getDontComePoint();
    }


    public static int getPlaceBet(int betID){
        	switch (betID){
			case 0:
				return placeBets.getMoneyOnFour();
			case 1:
				return placeBets.getMoneyOnFive();
			case 2:
				return placeBets.getMoneyOnSix();
			case 3:
				return placeBets.getMoneyOnEight();
			case 4:
				return placeBets.getMoneyOnNine();
			case 5:
				return placeBets.getMoneyOnTen();
		}
		return 0;
	}
	
    public static int getPropBet(int betID){
        	switch (betID){
			case 0:
				return propBets.getAnySevenMoney();
			case 1:
				return propBets.getAnyCrapsMoney();
			case 2:
				return propBets.getCrapsTwoMoney();
			case 3:
				return propBets.getCrapsThreeMoney();
			case 4:
				return propBets.getYoElevenMoney();
			case 5:
				return propBets.getCrapsTwelveMoney();
		}
		return 0;
	}
	
    public static int getHardBet(int betID){
        	switch (betID){
			case 0:
				return hardwayBet.getMoneyOnFour();
			case 1:
				return hardwayBet.getMoneyOnSix();
			case 2:
				return hardwayBet.getMoneyOnEight();
			case 3:
				return hardwayBet.getMoneyOnTen();
		}
		return 0;
	}
	
    public static int getBet(int betID){
        	switch (betID){
			case 0: //Pass line bet
				return passLineBet.getBetAmount();

			case 1: //Don't pass line bet
				return dontPassLineBet.getBetAmount();

			case 2: //Make place Bets
				return placeBets.getBetAmount();

			case 3: //Make Don't Come Bet
				return dontComeBet.getBetAmount();

			case 4: //Hardway Bet
				return hardwayBet.getBetAmount();

			case 5: //Proposition Bets
				return propBets.getBetAmount();

			case 6: //Come bet
				return comeBet.getBetAmount();

			case 7: //Field Bet
				return fieldBet.getBetAmount();
			
            }
        return 0;
    }


    public static int getDiceVal(int index){
        int[] diceVal;
        diceVal = dice.getRollArray();
        return diceVal[index];
    }

	
	//Setters 
	public static void setButton(boolean newButton) {
        button = newButton;
    }
	public static void setPlayerBal(int newPlayerBal) {
        playerBal = newPlayerBal;
    }
    public static void setPoint(int newPoint) {
        point = newPoint;
    }



	public static void setActiveBets(){
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
	public static void setPlayerBets(int[] betAmt, int betID) {
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
			case 6: //Come bet
				comeBet.setBetAmount(betAmt);
				playerBal -= betAmt[0];
				break;
			case 7: //Field Bet
				fieldBet.setBetAmount(betAmt);
				playerBal -= betAmt[0];
				break;
		}


		//Remember that certain bets can only be made at certain times in the game
	}
	
	public static void printPlayerBets() {
        //Print current point
        System.out.println("POINT: " + point);
        //Print current come point
        System.out.println("COME POINT: " + comeBet.getComePoint());
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

		//Come bet
		System.out.println("");
		System.out.println("Come bet amount: $" + comeBet.getBetAmount());
		//Don't come bet 
		System.out.println("Current player's don't come bet amount: $" +dontComeBet.getBetAmount());
		System.out.println("");
		
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

		//Field Bet
	 	System.out.println("Current player's Field bet amount: $" + fieldBet.getBetAmount());


	}
	
	public static void getPlayerBetsOutcome(int[] rollArray){
		passLineBet.checkBetOutcome(rollArray, button, point); 
		dontPassLineBet.checkBetOutcome(rollArray, button, point);
		placeBets.checkBetOutcome(rollArray, button, point);
		dontComeBet.checkBetOutcome(rollArray, button,point);
		hardwayBet.checkBetOutcome(rollArray, button, point);
		propBets.checkBetOutcome(rollArray, button, point);
		comeBet.checkBetOutcome(rollArray, button, point);
		fieldBet.checkBetOutcome(rollArray, button, point);
	}
	
	public static void getPlayerBetsPayOut(){
		int payout = 0; 
		//Debug
		System.out.println("");
		//Update with payout from pass line bet 
		payout += passLineBet.getPayOut(); 
		System.out.println("Payout from PassLine: " + passLineBet.getPayOut());

		
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
		
		//Update with payout from come bet 
		payout += comeBet.getPayOut(); 
		System.out.println("Payout from come bet: " + comeBet.getPayOut()); 
			
		//Update with payout from fieldBet
		payout += fieldBet.getPayOut(); 
		System.out.println("Payout from Field bet: " + fieldBet.getPayOut());
		
		//Increment payout for all other bets.... 
		playerBal += payout; 
		
		//Debug
		System.out.println("");
		
	}

    public static String getBetAmtString(int betID){
        String output="";
        if ( betID == 0){

            output += "Pass line: " + passLineBet.getBetAmount();
        }
        if (betID == 1){

            output += "Don't Pass line: " + dontPassLineBet.getBetAmount();
        }
        if (betID == 2){

            output += "Place: " + placeBets.getBetAmount();
        }
        if (betID == 3){

            output += "Don't Come: " + dontComeBet.getBetAmount();
        }
        if (betID == 4){

            output += "Hardway: " + hardwayBet.getBetAmount();
        }
        if (betID == 5){

            output += "Proposition: " + propBets.getBetAmount();
        }
        if (betID == 6){

            output += "Come: " + comeBet.getBetAmount();
        }
        if (betID == 7){

            output += "Field: " + fieldBet.getBetAmount();
        }
        return output;
    }

    public static String getBetPayoutString(int betID){
        String output="";
        if (passLineBet.getPayOut() != 0 && betID == 0){

            output += "Pass line: " + passLineBet.getPayOut();
        }
        if (dontPassLineBet.getPayOut() != 0 && betID == 1){

            output += "Don't Pass line: " + dontPassLineBet.getPayOut();
        }
        if (placeBets.getPayOut() != 0 && betID == 2){

            output += "Place: " + placeBets.getPayOut();
        }
        if (dontComeBet.getPayOut() != 0 && betID == 3){

            output += "Don't Come: " + dontComeBet.getPayOut();
        }
        if (hardwayBet.getPayOut() != 0 && betID == 4){

            output += "Hardway: " + hardwayBet.getPayOut();
        }
        if (propBets.getPayOut() != 0 && betID == 5){

            output += "Proposition: " + propBets.getPayOut();
        }
        if (comeBet.getPayOut() != 0 && betID == 6){

            output += "Come: " + comeBet.getPayOut();
        }
        if (fieldBet.getPayOut() != 0 && betID == 7){

            output += "Field: " + fieldBet.getPayOut();
        }
        return output;
    }

    public static String getCrapStatus(){
        int[] diceArray = dice.getRollArray();
        int diceSum = diceArray[0] + diceArray[1];
        String msg="";
        if (point != 0){  //If point is set
            if (diceSum == 7){
                msg += "SEVEN OUT!!";
            }
        }
        else { //Point hasn't been set
            if (diceSum == 2 || diceSum == 3 || diceSum ==12){
                msg +="CRAP OUT!! You're POOR now";
            }
        }
        return msg;
    }

/* Not using anymore
	//getBetInput: Used to read in bet input amounts from user, store them in an array, and return that array
	public static int[] getBetInput(int betID) throws IOException{
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
		
		if (betID == 0){ //Pass Line Bet
			//Populate pass line bet 
			System.out.println("Please enter the amount for the Pass Line bet: ");
			str = keyboard.readLine();
			betInput = Integer.parseInt(str); 
			myBets[0] = betInput; 
			return myBets;
		} //End of Pass Line Bet
		else if (betID == 1){ //Don't Pass Line Bet
			//Populate don't pass line bet
			System.out.println("Please enter the amount for the Don't Pass Line Bet: ");
			str = keyboard.readLine(); 
			betInput = Integer.parseInt(str);
			myBets[0] = betInput;
			return myBets;
		} //End of Don't Pass Line Bet
		else if (betID == 2){ //Place Bets
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
			if (betInput > 0){
				myBets[0] = betInput;
				dontComeBet.setState(1); //activate the dontComeBet
			}
			else{
				dontComeBet.setState(0);
			}
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
		else if (betID == 6){ 	//Come bet
			//Populate come bet
			System.out.println("Please enter amount for the Come Bet: "); 
			str = keyboard.readLine();
			betInput = Integer.parseInt(str); 
			if (betInput > 0){
				myBets[0] = betInput;
			}

			return myBets; 
		} else if (betID == 7) { //Field bet
			//Populate Field bet
			System.out.println("Please enter the amount for the Field Bet: ");
			str = keyboard.readLine(); 
			betInput = Integer.parseInt(str);
			myBets[0] = betInput;
			return myBets;
		}
		
		
		return myBets; //Default return statement
	}
	    */

	public static void playRound(){
		
		dice.roll(); //roll the dice 
		getPlayerBetsOutcome(dice.getRollArray());	//update the different bet objects (updates the payout and betAmount fields)
		getPlayerBetsPayOut();	//update the player balance with the pay out of the different bets (updates the player's balance with the payouts)
		
		
		//Testing 
		int[] diceArray = dice.getRollArray();
		System.out.println("***Dice Roll ***");
		System.out.println("Die 1 = " + diceArray[0]);
		System.out.println("Die 2 = " + diceArray[1]);
		System.out.println("");
		
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


        //Setting come point if comeBet is placed
        if (point != 0 && (comeBet.getComePoint() == 0) && (comeBet.getBetAmount() > 0)){
            //If dice roll is valid, set the come point
            if (diceVal  != 2 && diceVal != 3 && diceVal != 7 && diceVal != 12 && diceVal !=11){
                comeBet.setComePoint(diceVal);
            }
            //If dice roll is not valid, set come point to 0
            else{
                comeBet.setComePoint(0);
            }
        }

        //Setting don't come point if dontComeBet is placed
        if (point != 0 && (dontComeBet.getDontComePoint() == 0) && (dontComeBet.getBetAmount() > 0)){
            //If dice roll is valid, set the come point
            if (diceVal  != 2 && diceVal != 3 && diceVal != 7 && diceVal != 12 && diceVal !=11){
                dontComeBet.setDontComePoint(diceVal);
            }
            //If dice roll is not valid, set come point to 0
            else{
                dontComeBet.setDontComePoint(0);
            }
        }


        /*

		//Setting the don't come point 
		if ((dontComePoint == 0) && (dontComeBet.getState() == 1)){
			if (diceVal  != 2 && diceVal != 3 && diceVal != 7 && diceVal != 12 && diceVal !=11){ 
				dontComePoint = diceVal;
				System.out.println("Setting don't come point: " + dontComePoint);
				dontComeBet.setState(2);
			}
		}
		//Reset dont come point to 0 if 7 is rolled
		else if ((dontComePoint != 0) && (dontComeBet.getState() == 2) && (diceVal == 7)){
			dontComePoint = 0;
			System.out.println("Re-Setting don't come point: " + dontComePoint);
			dontComeBet.setState(0);
		}
		//Reset dont come point to 0 if dont come point is rolled
		else if ((dontComePoint != 0) && (dontComeBet.getState() == 2) && (diceVal == dontComePoint)){
			dontComePoint = 0;
			System.out.println("Re-Setting don't come point: " + dontComePoint);
			dontComeBet.setState(0);
		}
		
		//Setting the come point 
		if ((comePoint == 0) && (comeBet.getState() == 1)){
			if (diceVal  != 2 && diceVal != 3 && diceVal != 7 && diceVal != 12 && diceVal !=11){ 
				comePoint = diceVal;
				System.out.println("Setting come point: " + comePoint);
				dontComeBet.setState(2);
			}
		}
		//Reset dont come point to 0 if 7 is rolled
		else if ((comePoint != 0) && (comeBet.getState() == 2) && (diceVal == 7)){
			comePoint = 0;
			System.out.println("Re-Setting come point: " + comePoint);
			dontComeBet.setState(0);
		}
		//Reset dont come point to 0 if dont come point is rolled
		else if ((comePoint != 0) && (comeBet.getState() == 2) && (diceVal == comePoint)){
			comePoint = 0;
			System.out.println("Re-Setting come point: " + comePoint);
			comeBet.setState(0);
		}

        */
		
		
	}	    

  
}			
			


