/**
 * Created by IntelliJ IDEA.
 * User: Crapout! 
 * To change this template use File | Settings | File Templates.
 */

package net.rallyedu.Crapout;

public class Proposition extends Bet {
	
	//These variables keep track of the amount of money placed on a particular bet number
    protected int anySevenMoney;
    protected int anyCrapsMoney;
    protected int crapsTwoMoney;
    protected int crapsThreeMoney;
	protected int crapsTwelveMoney;
	protected int yoElevenMoney;

	
	
	//Constructor to set instance variables 
	public Proposition() {
		anySevenMoney = 0;
		anyCrapsMoney = 0;
		crapsTwoMoney = 0;
		crapsThreeMoney = 0;
		crapsTwelveMoney = 0;
		yoElevenMoney = 0;
	}

	//Getters
	public int getAnySevenMoney() {
		return anySevenMoney;
	}
	
	
	public int getAnyCrapsMoney() {
		return anyCrapsMoney;

	}
	
	public int getCrapsTwoMoney() {
		return crapsTwoMoney;

	}
	
	public int getCrapsThreeMoney() {
		return crapsThreeMoney;
	}

	public int getCrapsTwelveMoney() {
		return crapsTwelveMoney;
	}
	
	
	public int getYoElevenMoney() {
		return yoElevenMoney;
	}
	

	

	
	
	//Setters
	public void setAnySevenMoney(int amt) {
		anySevenMoney = amt;
	}
	
	
	public void setAnyCrapsMoney(int amt) {
		anyCrapsMoney = amt;
		
	}
	
	public void setCrapsTwoMoney(int amt) {
		crapsTwoMoney = amt;
		
	}
	
	public void setCrapsThreeMoney(int amt) {
		crapsThreeMoney = amt;
	}
	
	
	public void setCrapsTwelveMoney(int amt) {
		crapsTwelveMoney = amt;
	}
	
	public void setYoElevenMoney(int amt) {
		yoElevenMoney = amt;
	}
	
	

	//Overrides the Bet parent class because an instance of this class
	//Handles setting the bet amounts for all Place numbers (4,5,7,8,9, and 10)
	public void setBetAmount(int[] betAmt) {
		anySevenMoney += betAmt[0];
		anyCrapsMoney += betAmt[1];
		crapsTwoMoney += betAmt[2];
		crapsThreeMoney += betAmt[3];
		crapsTwelveMoney += betAmt[4];
		yoElevenMoney += betAmt[5];
		
		betAmount = anySevenMoney + anyCrapsMoney + crapsTwoMoney + crapsThreeMoney + crapsTwelveMoney + yoElevenMoney;

	}

	public void zeroBets() {
		anySevenMoney = 0;
		anyCrapsMoney = 0;
		crapsTwoMoney = 0;
		crapsThreeMoney = 0;
		crapsTwelveMoney = 0;
		yoElevenMoney = 0;

		
		betAmount = anySevenMoney + anyCrapsMoney + crapsTwoMoney + crapsThreeMoney + crapsTwelveMoney + yoElevenMoney;

	} 




    public void checkBetOutcome(int[] rollArray, boolean active, int point){
        int sum = rollArray[0] + rollArray[1];
        
        int[] payouts = new int[6]; //The size of this array will change as we implement more bets
        //Init. Array values to 0
		for (int x=0; x< payouts.length; x++) {
         		payouts[x] = 0;
		}
        
		//Any Seven
		if((sum == 7) && (anySevenMoney > 0) ) {
				//4 to 1 payout for Any 7
				System.out.println("Won money on Any 7.");
				//payout is set to 0 and bet amount is set to 0
				setPayOut(5 * anySevenMoney); 
				
		}
		//If the Dice Roll is 2
		else if (sum == 2) {
			//30 to 1 payout for Craps 2
			//7 to 1 payout for Any Craps
			if ((crapsTwoMoney > 0) && (anyCrapsMoney > 0)) { //If both Craps 2 and Any Craps bets on table
				System.out.println("Won money on Craps 2.");
				System.out.println("Won money on Any Craps.");
				setPayOut((31 * crapsTwoMoney) + (8 * anyCrapsMoney)); 

			}
			else if ((crapsTwoMoney > 0) && (anyCrapsMoney <= 0)) { //If only Craps 2 money on the table
				System.out.println("Won money on Craps 2.");
				setPayOut(31 * crapsTwoMoney); 

			}
			else if((crapsTwoMoney <= 0) && (anyCrapsMoney > 0)) { //If only an Any Craps bet is on the table
				System.out.println("Won money on Any Craps.");
				setPayOut(8 * anyCrapsMoney); 

			}
			
		}
		//If Dice Roll is three 3
		else if (sum == 3) {
			//15 to 1 payout for Craps 3
			//7 to 1 payout for Any Craps
			if ((crapsThreeMoney > 0) && (anyCrapsMoney > 0)) { //If both Craps 3 and Any Craps bets on table
				System.out.println("Won money on Craps 3.");
				System.out.println("Won money on Any Craps.");
				setPayOut((16 * crapsThreeMoney) + (8 * anyCrapsMoney)); 
				
			}
			else if ((crapsThreeMoney > 0) && (anyCrapsMoney <= 0)) { //If only Craps 3 money on the table
				System.out.println("Won money on Craps 3.");
				setPayOut(16 * crapsThreeMoney); 

			}
			else if((crapsThreeMoney <= 0) && (anyCrapsMoney > 0)) { //If only an Any Craps bet is on the table
				System.out.println("Won money on Any Craps.");
				setPayOut(8 * anyCrapsMoney); 

			}
			

		}
		//If Dice Roll is 12
		else if (sum == 12) {
			//30 to 1 payout for Craps 12
			//7 to 1 payout for Any Craps
			if ((crapsTwelveMoney > 0) && (anyCrapsMoney > 0)) { //If both Craps 12 and Any Craps bets on table
				System.out.println("Won money on Craps 12.");
				System.out.println("Won money on Any Craps.");
				setPayOut((31 * crapsTwelveMoney) + (8 * anyCrapsMoney)); 
				
			}
			else if ((crapsTwelveMoney> 0) && (anyCrapsMoney <= 0)) { //If only Craps 12 money on the table
				System.out.println("Won money on Craps 12.");
				setPayOut(31 * crapsTwelveMoney); 

			}
			else if((crapsTwelveMoney <= 0) && (anyCrapsMoney > 0)) { //If only an Any Craps bet is on the table
				System.out.println("Won money on Any Craps.");
				setPayOut(8 * anyCrapsMoney); 

			}
			

		}
		//If Dice Roll is 11
		else if ((sum == 11) && (yoElevenMoney > 0)) {
			//15 to 1 payout for Yo Eleven
			System.out.println("Won money on Yo Eleven.");
			setPayOut(16 * yoElevenMoney); 
			
		}
		
		//Call zeroBets() to clear the table of these bets (these are all One-Roll Bets)
		zeroBets();

	}

        
}
