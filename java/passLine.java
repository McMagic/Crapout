/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Oct 15, 2010
 * Time: 7:58:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class passLine extends Bet {

    public passLine(int amount) {
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
			System.out.print("Point is " + point);
            if(point != 0){
                //Button is on
                if(sum == 7) {
					//payout is set to 0 and bet amount is set to 0
                    setPayOut(0); 
					setBetAmount(0);
				}
                else if (sum == point){
					//payout is set to my bet amount and bet amount remains the same
                    setPayOut(2*getBetAmount());
					setBetAmount(0);
				}
                else {
					//payout is set to 0 and bet amount remains the same 
                    setPayOut(0);
				}
            }
            else if (point == 0){
                // Button is off
                if(sum == 7 || sum == 11){
					setPayOut(getBetAmount());
                }
                else if(sum == 2 || sum == 3 || sum == 12){
					setPayOut(0);
					setBetAmount(0);
				}
            }
        }
    }
}
