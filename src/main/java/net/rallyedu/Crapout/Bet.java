/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Oct 21, 2010
 * Time: 12:53:14 PM
 * To change this template use File | Settings | File Templates.
 */

package net.rallyedu.Crapout;

public abstract class Bet {
    protected int payOut;
    protected boolean active;
    protected int betAmount;

    public Bet(){
        this.payOut = 0;
        this.betAmount = 0;
        this.active = false;
    }

	//Setters 
	public void setPayOut(int pay){
		payOut = pay;
	}
	
	
	//NOTE: This function now takes an array as opposed to a value
	//This is because is its overwritten in the PlaceBet class
	public void setBetAmount(int[] bet){
		betAmount = bet[0];
	}
	
	
	
	
	public void setActive(boolean b){
		active = b; 
	}
	
	//Getters
	public int getPayOut(){
		return payOut;
	}
	public int getBetAmount(){
		return betAmount;
	}
	public boolean getActive(){
		return active; 
	}
	
	public abstract void checkBetOutcome(int[] rollArray, boolean active, int point);
}
	
	/* Don't know what this is for 
    public int payBet(){
        return 0;
    }

    public int loseBet(){
        return 0;
    }
	*/


