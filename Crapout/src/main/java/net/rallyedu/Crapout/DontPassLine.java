/*
 *
 * Author: CrapOut
 *
 * DontPassLine class: 
 * 	Player wins if 7 or 11 rolls on come-out roll 
 * 	Player loses if 2, 3, or 12 rolls on come-out roll. 
 *	Player win if 7 is rolled on non come-out roll (after point is established) 
 *  Player loses if point is rolled on non come-out roll (after point is established)
 *
 *
 */
 
 
public class DontPassLine extends Bet {

	//Default constructor 
	public DontPassLine (int amount){
		this.betAmount = amount;
		this.payOut = 0; 
		this.active = true; 
	}
	
	public void checkBetOutcome(int[] rollArray, boolean active, int point){
		int rollSum = rollArray[0] + rollArray[1];
		
		int[] amt = new int[1];
		amt[0] = 0;
		//Bet is not valid at this point. Return 0
		if(active == false){
		}

		else{
			//reset payout
			setPayOut(0);
			/** Point HAS been set **/ 
			if (point != 0){
				if (rollSum == 7){
				//7 rolled before point, player WINS 
					System.out.println("Don't pass line bets WINS");
					setPayOut(2*getBetAmount()); 
					System.out.println("don't pass line get: PayOut after getting Craps: " + getPayOut());
					setBetAmount(amt);
				}
				else if (rollSum == point){
				//Point is rolled before 7, player LOSES 
					setPayOut(0); 
					setBetAmount(amt);
				}
				else if (rollSum != 7 && rollSum != point){
					System.out.println("Am i in last else statement");
					setPayOut(0);
				}
			}
			/** Point HAS NOT been set **/
			else if (point == 0){
				if (rollSum == 7 || rollSum == 11){
				//7 or 11 is rolled on come-out roll, player LOSES
					setPayOut(0); 
					setBetAmount(amt);
				}
				
				else if (rollSum == 2 || rollSum == 3 ||  rollSum == 12){
				//2, 3, or 12 is rolled on come-out roll, player WINS 
					setPayOut(getBetAmount()); 
				}
			}
		}

	}
}