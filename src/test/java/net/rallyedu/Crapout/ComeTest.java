package net.rallyedu.Crapout;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: nguyenkb
 * Date: Dec 4, 2010
 * Time: 1:30:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Test
public class ComeTest {
    public int[] diceVal = new int[2];
    public int[] betAmt = new int[1];
    public int point;
    public void test(){
        //Come point hasn't been set
        //Dice = 7 or 11
        //Player should win (payout = 1:1 bet amount = 0)
        betAmt[0] = 100;
        diceVal[0] = 3;
        diceVal[1] = 4;
        Come comeBet = new Come(0);
        comeBet.setBetAmount(betAmt);
        comeBet.setComePoint(0);
        comeBet.checkBetOutcome(diceVal, true, 4);
        Assert.assertEquals(comeBet.getPayOut(),200);
        Assert.assertEquals(comeBet.getBetAmount(), 0);

        betAmt[0] = 100;
        diceVal[0] = 5;
        diceVal[1] = 6;
        comeBet.setBetAmount(betAmt);
        comeBet.setComePoint(0);
        comeBet.checkBetOutcome(diceVal, true, 4);
        Assert.assertEquals(comeBet.getPayOut(),200);
        Assert.assertEquals(comeBet.getBetAmount(), 0);

        //Come point hasn't been set
        //Dice = 4,5,6,8,9,10
        //Player doesn't win or lose (payout = 0; bet amount should remain the same)
        diceVal[0] = 3;
        diceVal[1] = 1;
        point = 4;
        comeBet.setBetAmount(betAmt);
        comeBet.setComePoint(0);
        comeBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(comeBet.getPayOut(), 0);
        Assert.assertEquals(comeBet.getBetAmount(), 100);

        diceVal[0] = 4;
        diceVal[1] = 1;
        point = 4;
        comeBet.setBetAmount(betAmt);
        comeBet.setComePoint(0);
        comeBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(comeBet.getPayOut(), 0);
        Assert.assertEquals(comeBet.getBetAmount(), 100);

        diceVal[0] = 2;
        diceVal[1] = 4;
        point = 4;
        comeBet.setBetAmount(betAmt);
        comeBet.setComePoint(0);
        comeBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(comeBet.getPayOut(), 0);
        Assert.assertEquals(comeBet.getBetAmount(), 100);

        diceVal[0] = 5;
        diceVal[1] = 3;
        point = 4;
        comeBet.setBetAmount(betAmt);
        comeBet.setComePoint(0);
        comeBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(comeBet.getPayOut(), 0);
        Assert.assertEquals(comeBet.getBetAmount(), 100);

        diceVal[0] = 6;
        diceVal[1] = 3;
        point = 4;
        comeBet.setBetAmount(betAmt);
        comeBet.setComePoint(0);
        comeBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(comeBet.getPayOut(), 0);
        Assert.assertEquals(comeBet.getBetAmount(), 100);

       diceVal[0] = 6;
       diceVal[1] = 4;
       point = 4;
       comeBet.setBetAmount(betAmt);
       comeBet.setComePoint(0);
       comeBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(comeBet.getPayOut(), 0);
       Assert.assertEquals(comeBet.getBetAmount(), 100);

        //Come point is set to 4
        //Dice = come point
        //Player should win (payout = 1:1 and bet amount = 0)
        diceVal[0] = 2;
        diceVal[1] = 2;
        comeBet.setBetAmount(betAmt);
        comeBet.setComePoint(4);
        comeBet.checkBetOutcome(diceVal, true, point);
        Assert.assertEquals(comeBet.getPayOut(), 200);
        Assert.assertEquals(comeBet.getBetAmount(), 0);

        //Come point is set to 4
        //Dice != come point or 7
        //Player doesn't win or lose (payout = 0 and bet amount remains the same)
        diceVal[0] = 3;
        diceVal[1] = 2;
        comeBet.setBetAmount(betAmt);
        comeBet.setComePoint(4);
        comeBet.checkBetOutcome(diceVal, true, point);
        Assert.assertEquals(comeBet.getPayOut(), 0);
        Assert.assertEquals(comeBet.getBetAmount(), 100);

        //Come point is set to 4
        //Dice = 7
        //Player loses (payout = 0 and bet = 0)
        diceVal[0] = 5;
        diceVal[1] = 2;
        comeBet.setBetAmount(betAmt);
        comeBet.setComePoint(4);
        comeBet.checkBetOutcome(diceVal, true, point);
        Assert.assertEquals(comeBet.getPayOut(), 0);
        Assert.assertEquals(comeBet.getBetAmount(), 0);
    }
}
