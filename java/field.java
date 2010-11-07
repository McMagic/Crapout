/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Oct 15, 2010
 * Time: 7:58:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class field extends Bet {

    public field(int amount) {
        this.betAmount = amount;
        this.payOut = 0;
        this.active = true;

    }

    public void checkBetOutcome(int[] rollArray, boolean active, int point){
        int sum = rollArray[0] + rollArray[1];
        if(active == false){
           // return 0;
        }
		else {
			if (sum == 2) {
				/* This pays double */
				setPayOut(3*getBetAmount());
				setBetAmount(0);
			}
			else if (sum == 12){
				/* This pays double */
				setPayOut(3*getBetAmount());
				setBetAmount(0);
			}
			else if (sum == 3 || sum == 4 || sum == 9 || sum == 10 || sum == 11){
				/* This pays single */
				setPayOut(2*getBetAmount());
				setBetAmount(0);
			}
			else {
				setBetAmount(0);
				setPayOut(0);
			}

		}
	}


}
