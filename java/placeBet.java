/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Oct 15, 2010
 * Time: 7:58:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class placeBet extends Bet {
	
	//These variables keep track of the amount of money placed on a particular bet number
    protected int moneyOnFour;
	protected int moneyOnFive;
    protected int moneyOnSix;
    protected int moneyOnEight;
    protected int moneyOnNine;
    protected int moneyOnTen;

	//Constructor to set instance variables 
	public placeBet() {
		this.moneyOnFour = 0;
		this.moneyOnFive = 0;
   		this.moneyOnSix = 0;
    	this.moneyOnEight = 0;
    	this.moneyOnNine = 0;
    	this.moneyOnTen = 0;
	}

	//Getters
	public int getMoneyOnFour() {
		return moneyOnFour;
	}
	
	public int getMoneyOnFive() {
		return moneyOnFive;

	}
	
	public int getMoneyOnSix() {
		return moneyOnSix;

	}
	
	public int getMoneyOnEight() {
		return moneyOnEight;

	}
	
	public int getMoneyOnNine() {
		return moneyOnNine;

	}
	
	public int getMoneyOnTen() {
		return moneyOnTen;
	}
	
	


	//Overrides the Bet parent class because an instance of this class
	//Handles setting the bet amounts for all Place numbers (4,5,7,8,9, and 10)
	public void setBetAmount(int[] betAmt) {
		moneyOnFour += betAmt[0];
		moneyOnFive += betAmt[1];
		moneyOnSix += betAmt[2];
		moneyOnEight += betAmt[3];
		moneyOnNine += betAmt[4];
		moneyOnTen += betAmt[5];

		betAmount = moneyOnFour + moneyOnFive + moneyOnSix + moneyOnEight + moneyOnNine + moneyOnTen;

	}

	//Used in 7-crapout situation to reset the betAmount back to 0 and to clear all money on the table
	public void zeroBets() {
		moneyOnFour = 0;
		moneyOnFive = 0;
		moneyOnSix = 0;
		moneyOnEight = 0;
		moneyOnNine = 0;
		moneyOnTen = 0;

		betAmount = moneyOnFour + moneyOnFive + moneyOnSix + moneyOnEight + moneyOnNine + moneyOnTen;

	}




    public void checkBetOutcome(int[] rollArray, boolean active, int point){
        int sum = rollArray[0] + rollArray[1];
        
        int[] payouts = new int[6]; //The size of this array will change as we implement more bets
        //Init. Array values to 0
		for (int x=0; x< payouts.length; x++) {
         		payouts[x] = 0;
		}
        
		//If the point is set (aka button is on)
		if(point != 0) {
			//Button is on
			if(sum == 7) {
				System.out.println("7 Crapout. Player looses all Place Bets on the board.");
				//payout is set to 0 and bet amount is set to 0
				setPayOut(0); 
				
				//Loose all your money on Place Bets
				zeroBets();
			}
			else if (sum == 2 || sum == 3 || sum == 12) {
				System.out.println("2,3, or 12 rolled, so no payout from Place Bets.");
				//payout is set to my bet amount and bet amount remains the same
				setPayOut( 0 );
			}
			else if (sum == 4 && (moneyOnFour > 0)) {
				System.out.println("Player wins on Place Bet (4 rolled).");
				
				//DEBUG
				System.out.println("Payout place bet calc: " + ((9*moneyOnFour) / 5) );
				
				//payout is set to my bet amount and bet amount remains the same
				setPayOut( (9*moneyOnFour) / 5 );
			}
			else if (sum == 5 && (moneyOnFive > 0)) {
				System.out.println("Player wins on Place Bet (5 rolled).");
				
				//DEBUG
				System.out.println("Payout place bet calc: " + ((7*moneyOnFive) / 5 ) );				
				
				//payout is set to my bet amount and bet amount remains the same
				setPayOut( (7*moneyOnFive) / 5 );
			}
			else if (sum == 6 && (moneyOnSix > 0)) {
				System.out.println("Player wins on Place Bet (6 rolled).");
				
				//DEBUG
				System.out.println("Payout place bet calc: " + ((7*moneyOnSix) / 6) );				
				
				//payout is set to my bet amount and bet amount remains the same
				setPayOut( (7*moneyOnSix) / 6);
			}
			else if (sum == 8 && (moneyOnEight > 0)) {
				System.out.println("Player wins on Place Bet (8 rolled).");	
				
				//DEBUG
				System.out.println("Payout place bet calc: " + ((7*moneyOnEight) / 6) );				
				
				//payout is set to my bet amount and bet amount remains the same
				setPayOut( (7*moneyOnEight) / 6);
				
			}
			else if (sum == 9 && (moneyOnNine > 0)) {
				System.out.println("Player wins on Place Bet (9 rolled).");
				
				//DEBUG
				System.out.println("Payout place bet calc: " + ((7*moneyOnNine) / 5) );
					
				//payout is set to my bet amount and bet amount remains the same
				setPayOut( (7*moneyOnNine) / 5);
				
			}
			else if (sum == 10 && (moneyOnTen > 0)) {
				System.out.println("Player wins on Place Bet (10 rolled).");
				
				//DEBUG
				System.out.println("Payout place bet calc: " + ((9 * moneyOnTen) / 5) );
				
				//payout is set to my bet amount and bet amount remains the same
				setPayOut( (9*moneyOnTen) / 5);
				
			}
		}
		else if (point == 0) {
			// Button is off
			//Cannot make this type of bet, so set Payout to 0
			setPayOut(0);
		}
    }
    
    
}
