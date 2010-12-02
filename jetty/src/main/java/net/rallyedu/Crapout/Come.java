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
 
package net.rallyedu.Crapout;
 
public class Come extends Bet {
	//Instance variable
    private int comePoint=0;

	
	//Default constructor 
	public Come (int amount){
		this.betAmount = amount;
		this.payOut = 0; 
		this.active = false;
	}

    //Getters
    public int getComePoint(){
        return comePoint;
    }

    public void setComePoint(int i){
        comePoint = i;
    }

    

	public void checkBetOutcome(int[] rollArray, boolean active, int point){
		//Sum of the dice roll 
		int rollSum = rollArray[0] + rollArray[1];
		
		//For setting the betAmount to 0
		int[] betAmt = new int[1];

        //Resetting payOut to be 0
        setPayOut(0);

        /** Come Point HAS been set **/
        if (comePoint != 0){
            System.out.println("FROM COME.JAVA: come point has been set!!!!!!!\n");
            //Shooter rolls comePoint before 7 --> Wins 
            if (rollSum == comePoint){
                System.out.println("Come bet WINS");
                setPayOut(2*getBetAmount()); //set payout to winning of 1:
                System.out.println("Don't come bet PayOut: " + getPayOut());
                betAmt[0] = 0;
                setBetAmount(betAmt);	//set bet amount to 0
                //Reset the comePoint to "OFF"
                setComePoint(0);
            }
            //Shooter rolls don't come point before 7. LOSES
            else if (rollSum == 7){
                System.out.println("Come bet LOSES");
                setPayOut(0); //set payout to 0
                betAmt[0]=0;
                setBetAmount(betAmt); //set bet amount to 0     \
                //Reset the comePoint to "OFF"
                setComePoint(0);
            }
            //Shooter didn't roll come point or 7, nothing happens
            else{
                setPayOut(0);
               //Debugging
                System.out.println("FROM COME.JAVA: Bet amount on Come Bet: " + getBetAmount());
            }
        }

        /** Come Point HAS NOT been set **/
        else if (comePoint == 0){
            //Shooter rolls a 2, 3, or 12 on come-out roll for come point, player LOSES
            if (rollSum == 2 || rollSum == 3 || rollSum == 12){
                setPayOut(0); //set payout to 0
                betAmt[0] = 0;
                setBetAmount(betAmt);
                System.out.println("2,3, or 12 is rolled on come bet: Player loses\n");
            }

            //Shooter rolls a 7 or 11 on come-out roll for come point, player wins
            //Player's bet is returned in the winnings
            else if (rollSum == 7 || rollSum == 11) {
                setPayOut(2*getBetAmount()); //set payout to betAmount (winnings: 1:1)
                betAmt[0]=0;
                setBetAmount(betAmt);

            }
            //No winnings/losses, come point should be set
            else{
                setPayOut(0);
            }
        }


	}
}
