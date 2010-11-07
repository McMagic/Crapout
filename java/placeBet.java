/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Oct 15, 2010
 * Time: 7:58:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class placeBet extends Bet {
	
	//These variables keep track of the amount of money placed on a particular bet number
    protected int moneyOnFour = 0;
	protected int moneyOnFive= 0;
    protected int moneyOnSix = 0;
    protected int moneyOnEight= 0;
    protected int moneyOnNine = 0;
    protected int moneyOnTen = 0;



    public placeBet(int amount) {
        this.betAmount = amount;
        this.payOut = 0;
        this.active = true;

    }

	public void betMoneyOnNum(int numToBet, ) {
		
	}


    public void checkBetOutcome(int[] rollArray, boolean active, int point){
        int sum = rollArray[0] + rollArray[1];
		if (active) {
			System.out.print("Point is " + point);
			if(point != 0){
				//Button is on
				if(sum == 7) {
					//payout is set to 0 and bet amount is set to 0
					setPayOut(0); 
					setBetAmount(0);
				}
				else if (sum == 4 && (moneyOnFour > 0)) {
					//payout is set to my bet amount and bet amount remains the same
					setPayOut( (9*moneyOnFour) / 5 );
					
					
					setBetAmount(0);
				}
				else if (sum == 5 && (moneyOnFive > 0)) {
					//payout is set to my bet amount and bet amount remains the same
					setPayOut( (7*moneyOnFive) / 5 );
					
					
					setBetAmount(0);
				}
				else if (sum == 6 && (moneyOnSix > 0)) {
					//payout is set to my bet amount and bet amount remains the same
					setPayOut( (7*moneyOnSix) / 6);
					
					
					setBetAmount(0);
				}
				else if (sum == 8 && (moneyOnEight > 0)) {
					//payout is set to my bet amount and bet amount remains the same
					setPayOut( (7*moneyOnEight) / 6);
					
					
					setBetAmount(0);
				}
				else if (sum == 9 && (moneyOnNine > 0)) {
					//payout is set to my bet amount and bet amount remains the same
					setPayOut( (7*moneyOnNine) / 5);
					
					
					setBetAmount(0);
				}
				else if (sum == 10 && (moneyOnTen > 0)) {
					//payout is set to my bet amount and bet amount remains the same
					setPayOut( (9*moneyOnTen) / 5);
					
					
					setBetAmount(0);
				}
			}
			else if (point == 0) {
				// Button is off
				//Cannot make this type of bet
			} 
		} //End of active check
    }
    
    
}
