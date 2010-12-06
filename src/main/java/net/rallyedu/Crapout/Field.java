/**
 * Created by IntelliJ IDEA.
 * User: Crapout!
 * To change this template use File | Settings | File Templates.
 */

package net.rallyedu.Crapout;

public class Field extends Bet {

    public Field(int amount) {
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
			if (sum == 2) {
				/* This pays double */
				setPayOut(3*getBetAmount());
				
				betAmt[0] = 0;
				setBetAmount(betAmt);
			}
			else if (sum == 12){
				/* This pays double */
				setPayOut(3*getBetAmount());
				betAmt[0] = 0;
				setBetAmount(betAmt);
			}
			else if (sum == 3 || sum == 4 || sum == 9 || sum == 10 || sum == 11){
				/* This pays single */
				setPayOut(2*getBetAmount());
				betAmt[0] = 0;
				setBetAmount(betAmt);
			}
			else {
				/* Loose all of your money if any other roll is made */
				betAmt[0] = 0;
				setBetAmount(betAmt);
			}

		}
	}


}
