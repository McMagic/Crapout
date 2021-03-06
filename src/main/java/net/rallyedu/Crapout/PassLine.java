/**
 * Created by IntelliJ IDEA.
 * User: Crapout!
 * To change this template use File | Settings | File Templates.
 */

package net.rallyedu.Crapout;

public class PassLine extends Bet {

    public PassLine(int amount) {
        this.betAmount = amount;
        this.payOut = 0;
        this.active = true;

    }

    public void checkBetOutcome(int[] rollArray, boolean active, int point){
        int sum = rollArray[0] + rollArray[1];
		
		int[] betAmt = new int[1];
		
        if(active == false){
           // return 0;
        }
        else {
			//reset payout
			setPayOut(0);
			//If Button is on, meaning point HAS been set
            if(point != 0){
                if(sum == 7) { //If 7 is rolled, player loses 
					//payout is set to 0 and bet amount is set to 0
                    setPayOut(0);
                    
                    betAmt[0] = 0;
					setBetAmount(betAmt);
					System.out.println("Crap out!");
				}
                else if (sum == point){ //If point is rolled, player wins
					//payout is set to my bet amount and bet amount remains the same
                    setPayOut(2*getBetAmount());
					betAmt[0] = 0;
					setBetAmount(betAmt);
					System.out.println("Winner!");
				}
                else {
					//payout is set to 0 and bet amount remains the same 
                    setPayOut(0);
				}
            }
			
			//If Button is off, meaning point HAS NOT been set 
            else if (point == 0){
                if(sum == 7 || sum == 11){	//If 7 or 11 is rolled then player wins
					setPayOut(2*getBetAmount());
					betAmt[0] = 0;
					setBetAmount(betAmt);
					//System.out.println("Bet amount is "+ getBetAmount());
					System.out.println("7 or 11 is rolled and Player wins! " + getPayOut());
					
                }
                else if(sum == 2 || sum == 3 || sum == 12){ 	//If 2, 3 or 12 is rolled then player loses
					setPayOut(0);
					betAmt[0] = 0;
					setBetAmount(betAmt);
					System.out.println("2, 3, or 12 is rolled and Player loses! ");
				}
            }
        }
    }
}
