/**
 * Created by IntelliJ IDEA.
 * User: Crapout!
 * To change this template use File | Settings | File Templates.
 */

package net.rallyedu.Crapout;

public class Hardway extends Bet {
	
	//These variables keep track of the amount of money placed on a particular bet number
    protected int moneyOnFour;
    protected int moneyOnSix;
    protected int moneyOnEight;
    protected int moneyOnTen;

	//Constructor to set instance variables 
	public Hardway() {
		this.moneyOnFour = 0;
   		this.moneyOnSix = 0;
    	this.moneyOnEight = 0;
    	this.moneyOnTen = 0;
	}

	//Getters
	public int getMoneyOnFour() {
		return moneyOnFour;
	}
	
	
	public int getMoneyOnSix() {
		return moneyOnSix;

	}
	
	public int getMoneyOnEight() {
		return moneyOnEight;

	}
	
	public int getMoneyOnTen() {
		return moneyOnTen;
	}
	
	//Setters
	public void setMoneyOnFour(int amt) {
		moneyOnFour = amt;
	}
	
	public void setMoneyOnSix(int amt) {
		moneyOnSix = amt;
	}
	
	public void setMoneyOnEight(int amt) {
		moneyOnEight = amt;
	}
	
	public void setMoneyOnTen(int amt) {
		moneyOnTen = amt;
	}
	

	//Overrides the Bet parent class because an instance of this class
	//Handles setting the bet amounts for all Place numbers (4,5,7,8,9, and 10)
	public void setBetAmount(int[] betAmt) {
		moneyOnFour += betAmt[0];
		moneyOnSix += betAmt[1];
		moneyOnEight += betAmt[2];
		moneyOnTen += betAmt[3];

		
		betAmount = moneyOnFour + moneyOnSix + moneyOnEight + moneyOnTen;

	}

	//Used in 7 or Easy roll situation to reset the betAmount back to 0 and to clear all money on the table
	public void zeroBets() {
		moneyOnFour = 0;
		moneyOnSix = 0;
		moneyOnEight = 0;
		moneyOnTen = 0;

		
		betAmount = moneyOnFour + moneyOnSix + moneyOnEight + moneyOnTen;

	}




    public void checkBetOutcome(int[] rollArray, boolean active, int point){
        int sum = rollArray[0] + rollArray[1];
        
        int[] payouts = new int[6]; //The size of this array will change as we implement more bets
        //Init. Array values to 0
		for (int x=0; x< payouts.length; x++) {
         		payouts[x] = 0;
		}
        

		if(sum == 7) {
				System.out.println("A 7 is rolled before the Hardway number. Player looses all Hardway Bets on the board.");
				//payout is set to 0 and bet amount is set to 0
				setPayOut(0); 
				
				//Loose all your money on Hardway Bets
				zeroBets();
		}

		else if (sum == 4 && (moneyOnFour > 0)) {
			//Check if the Bet was a Hard 4
			if ( (rollArray[0] == 2) && (rollArray[1] == 2) ) {
				System.out.println("Player wins on Hardway Bet (Hard 4 rolled).");
				//payout is set to my bet amount and bet amount remains the same
				setPayOut( (7*moneyOnFour) / 1 );
			}
			else { //If a soft 4 was rolled, then the player looses the money on this bet
				System.out.println("Player looses on Hardway Bet (Soft 4 rolled).");
				setMoneyOnFour(0); //Zero out the money on 4
				setPayOut(0);

			}
		}
		else if (sum == 6 && (moneyOnSix > 0)) {
			//Check if the Bet was a Hard 6
			if ( (rollArray[0] == 3) && (rollArray[1] == 3) ) {
				System.out.println("Player wins on Hardway Bet (Hard 6 rolled).");
				//payout is set to my bet amount and bet amount remains the same
				setPayOut( (9*moneyOnSix) / 1 );
			}
			else { //If a soft 6 was rolled, then the player looses the money on this bet
				System.out.println("Player looses on Hardway Bet (Soft 6 rolled).");
				setMoneyOnSix(0); //Zero out the money on 6
				setPayOut(0);
			}
		}
		else if (sum == 8 && (moneyOnEight > 0)) {
			//Check if the Bet was a Hard 8
			if ( (rollArray[0] == 4) && (rollArray[1] == 4) ) {
				System.out.println("Player wins on Hardway Bet (Hard 8 rolled).");
				//payout is set to my bet amount and bet amount remains the same
				setPayOut( (9*moneyOnEight) / 1 );
			}
			else { //If a soft 8 was rolled, then the player looses the money on this bet
				System.out.println("Player looses on Hardway Bet (Soft 8 rolled).");
				setMoneyOnEight(0); //Zero out the money on 8
				setPayOut(0);

			}
			
		}
		else if (sum == 10 && (moneyOnTen > 0)) {
			//Check if the Bet was a Hard 10
			if ( (rollArray[0] == 5) && (rollArray[1] == 5) ) {
				System.out.println("Player wins on Hardway Bet (Hard 10 rolled).");
				//payout is set to my bet amount and bet amount remains the same
				setPayOut( (7*moneyOnTen) / 1 ); //Zero out the money on 10
			}
			else { //If a soft 10 was rolled, then the player looses the money on this bet
				System.out.println("Player looses on Hardway Bet (Soft 10 rolled).");
				setMoneyOnTen(0);  //Zero out the money on 10
				setPayOut(0);

			}
		}
	}

        
}
