package net.rallyedu.Crapout;

import junit.framework.Assert;
import org.testng.annotations.Test;
import twitter4j.Place;

/**
 * Created by IntelliJ IDEA.
 * User: Crapout!
 * To change this template use File | Settings | File Templates.
 */

public class PlaceTest {
    public int[] diceVal = new int[2];
    public int[] betAmt = new int[6];
    @Test(parameters = {"dice1", "dice2", "expected payout", "expected bet amount"})
    public void testGetReply(){
        //4,5,6,8,9,10
        //Rolled a 4 - Player wins
        //Bet is on 4
        //Payout = 9:5
        //bet amount = 10
        setBetAmt(10,0,0,0,0,0);
        setPlaceTest(3,1,18,10);

        //Rolled a 5 - Player Wins
        //Bet is on 5
        //Payout = 7:5
        //Bet amount = 5
        setBetAmt(0,5,0,0,0,0);
        setPlaceTest(2,3,7,5);

        //Rolled a 6 - Player wins
        //Bet is on 6
        //Payout =  7:6
        //bet amount = 6
        setBetAmt(0,0,6,0,0,0);
        setPlaceTest(4,2,7,6);

        //Rolled a 8 - Player wins
        //Bet is on 8
        //Payout =  7:6
        //bet amount = 6
        setBetAmt(0,0,0,6,0,0);
        setPlaceTest(6,2,7,6);

        //Rolled a 9 - Player wins
        //Bet is on 9
        //Payout =  7:5
        //bet amount = 5
        setBetAmt(0,0,0,0,5,0);
        setPlaceTest(6,3,7,5);

        //Rolled a 10 - Player wins
        //Bet is on 10
        //Payout =  9:5
        //bet amount = 5
        setBetAmt(0,0,0,0,0,5);
        setPlaceTest(6,4,9,5);


    }
    public void setBetAmt (int n1, int n2, int n3, int n4, int n5, int n6){
        betAmt[0] = n1;
        betAmt[1] = n2;
        betAmt[2] = n3;
        betAmt[3] = n4;
        betAmt[4] = n5;
        betAmt[5] = n6;

    }

    public void setPlaceTest(int d1, int d2, int exp1, int exp2){
        PlaceBet placeBet = new PlaceBet();
        diceVal[0] = d1;
        diceVal[1] = d2;
        placeBet.setBetAmount(betAmt);
        placeBet.checkBetOutcome(diceVal,true, 5);

        Assert.assertEquals(placeBet.getPayOut(), exp1);
        Assert.assertEquals(placeBet.getBetAmount(), exp2);
    }
}
