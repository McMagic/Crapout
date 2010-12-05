package net.rallyedu.Crapout;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: nguyenkb
 * Date: Dec 4, 2010
 * Time: 1:57:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Test
public class DontComeTest {
    public int[] diceVal = new int[2];
    public int[] betAmt = new int[1];
    public int point;
    public void test(){
        //Don't come Point hasn't been set
        //Dice = 7 or 11
        //Player should lose (payout = 0; bet amount = 0)
        betAmt[0] = 100;
        diceVal[0] = 3;
        diceVal[1] = 4;
        DontCome dontComeBet = new DontCome(0);
        dontComeBet.setBetAmount(betAmt);
        dontComeBet.setDontComePoint(0);
        dontComeBet.checkBetOutcome(diceVal, true, 4);
        Assert.assertEquals(dontComeBet.getPayOut(),0);
        Assert.assertEquals(dontComeBet.getBetAmount(), 0);

        betAmt[0] = 100;
        diceVal[0] = 6;
        diceVal[1] = 5;
        dontComeBet.setBetAmount(betAmt);
        dontComeBet.setDontComePoint(0);
        dontComeBet.checkBetOutcome(diceVal, true, 4);
        Assert.assertEquals(dontComeBet.getPayOut(),0);
        Assert.assertEquals(dontComeBet.getBetAmount(), 0);

        //Don't Come point hasn't been set
        //Dice = 4,5,6,8,9,10
        //Player doesn't win or lose (payout = 0; bet amount should remain the same
        diceVal[0] = 3;
        diceVal[1] = 1;
        point = 4;
        dontComeBet.setBetAmount(betAmt);
        dontComeBet.setDontComePoint(0);
        dontComeBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontComeBet.getPayOut(), 0);
        Assert.assertEquals(dontComeBet.getBetAmount(), 100);

        diceVal[0] = 4;
        diceVal[1] = 1;
        point = 4;
        dontComeBet.setBetAmount(betAmt);
        dontComeBet.setDontComePoint(0);
        dontComeBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontComeBet.getPayOut(), 0);
        Assert.assertEquals(dontComeBet.getBetAmount(), 100);

        diceVal[0] = 2;
        diceVal[1] = 4;
        point = 4;
        dontComeBet.setBetAmount(betAmt);
        dontComeBet.setDontComePoint(0);
        dontComeBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontComeBet.getPayOut(), 0);
        Assert.assertEquals(dontComeBet.getBetAmount(), 100);

        diceVal[0] = 5;
        diceVal[1] = 3;
        point = 4;
        dontComeBet.setBetAmount(betAmt);
        dontComeBet.setDontComePoint(0);
        dontComeBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontComeBet.getPayOut(), 0);
        Assert.assertEquals(dontComeBet.getBetAmount(), 100);

        diceVal[0] = 6;
        diceVal[1] = 3;
        point = 4;
        dontComeBet.setBetAmount(betAmt);
        dontComeBet.setDontComePoint(0);
        dontComeBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontComeBet.getPayOut(), 0);
        Assert.assertEquals(dontComeBet.getBetAmount(), 100);

        diceVal[0] = 6;
        diceVal[1] = 4;
        point = 4;
        dontComeBet.setBetAmount(betAmt);
        dontComeBet.setDontComePoint(0);
        dontComeBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontComeBet.getPayOut(), 0);
        Assert.assertEquals(dontComeBet.getBetAmount(), 100);

        //Dont Come point is set to 4
        //Dice = dont come point
        //Player should lose (payout = 0 and bet amount = 0)
        diceVal[0] = 2;
        diceVal[1] = 2;
        dontComeBet.setBetAmount(betAmt);
        dontComeBet.setDontComePoint(4);
        dontComeBet.checkBetOutcome(diceVal, true, point);
        Assert.assertEquals(dontComeBet.getPayOut(), 0);
        Assert.assertEquals(dontComeBet.getBetAmount(), 0);

        //Dont come point is set to 4
        //Dice != dont come point or 7
        //Player doesn't win or lose (payout = 0 and bet amount remains  the same)
        diceVal[0] = 4;
        diceVal[1] = 2;
        dontComeBet.setBetAmount(betAmt);
        dontComeBet.setDontComePoint(4);
        dontComeBet.checkBetOutcome(diceVal, true, point);
        Assert.assertEquals(dontComeBet.getPayOut(), 0);
        Assert.assertEquals(dontComeBet.getBetAmount(), 100);
                 
        //Dont come point is set to 4
        //Dice = 7
        //Player wins (payout = 1:1 and bet amount = 0)
        diceVal[0] = 4;
        diceVal[1] = 3;
        dontComeBet.setBetAmount(betAmt);
        dontComeBet.setDontComePoint(4);
        dontComeBet.checkBetOutcome(diceVal, true, point);
        Assert.assertEquals(dontComeBet.getPayOut(), 200);
        Assert.assertEquals(dontComeBet.getBetAmount(), 0);
        
    }
}
