/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Oct 21, 2010
 * Time: 12:53:14 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Bet {
    protected int payOut;
    protected int betAmount;
    protected boolean active;

    public Bet(){
        this.payOut = 0;
        this.betAmount = 0;
        this.active = false;
    }

	//Setters 
	public void setPayOut(int pay){
		payOut = pay;
	}
	public void setBetAmount(int bet){
		betAmount = bet;
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


