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
 
 
public class Come extends Bet {
	//Instance variable 
	int state; //(0 means not active, 1 means come point is not set, 2 means come point is set)
	
	//Default constructor 
	public Come (int amount){
		this.betAmount = amount;
		this.payOut = 0; 
		this.active = false; 
		state = 0;
	}
	
	public int getState(){
		return state; 
	}
	
	public void setState(int newState){
		state = newState;
	}
	
	public void checkBetOutcome(int[] rollArray, boolean active, int comePoint){
		//Sum of the dice roll 
		int rollSum = rollArray[0] + rollArray[1];
		
		//For setting the betAmount to 0
		int[] amt = new int[1];
		amt[0] = 0;
		
		//Bet is not valid at this point. Return 0
		if(active == false){
		}

		
		else{
			//Resetting payOut to be 0 
			setPayOut(0); 
		
			/** Come Point HAS been set **/ 
			if ((comePoint != 0) && (state == 2)){
				//Shooter rolls 7 before dont come point. WINS 
				if (rollSum == comePoint){
					System.out.println("Come bet WINS"); 
					setPayOut(2*getBetAmount()); //set payout to winning of 1:1
					System.out.println("Don't come bet PayOut: " + getPayOut());
					setBetAmount(amt);	//set bet amount to 0 
				}
				//Shooter rolls don't come point before 7. LOSES
				else if (rollSum == 7){
					System.out.println("Come bet LOSES"); 
					setPayOut(0); //set payout to 0 
					setBetAmount(amt); //set bet amount to 0 
				}
				//Shooter didn't roll come point or 7, nothing happens  
				else{
					setPayOut(0);
				}
			}
			
			/** Come Point HAS NOT been set **/
			else if ((comePoint == 0) && (state == 1)){
				//Shooter rolls a 23, or 12 on come-out roll for come point, player LOSES
				if (rollSum == 2 || rollSum == 3 || rollSum == 12){
					setPayOut(0); //set payout to 0
					setBetAmount(amt);
				}
				
				//Shooter rolls a 7 or 11 on come-out roll for come point, player LOSES 
				else if (rollSum == 7 || rollSum == 11) {
					setPayOut(getBetAmount()); //set payout to betAmount (winnings: 1:1)
					//Set bet remains on table
				}
				else{
					setPayOut(0);
				}
			}
		}

	}
}