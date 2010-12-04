package net.rallyedu.Crapout;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: nguyenkb
 * Date: Dec 4, 2010
 * Time: 12:56:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Test
public class DontPassLineTest {
    public int[] diceVal = new int[2];
    public int[] betAmt = new int[1];
    public int point;
    public void test(){

        //Test Case 1
        //Point is not set
        //Player loses when dice roll = 7 or 11
        diceVal[0] = 3;
        diceVal[1] = 4;
        betAmt[0] = 100;
        point = 0;
        DontPassLine dontPassLineBet = new DontPassLine(0);
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 0);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 0);

        //Test Cases where:
        //Point is not set
        //Player wins when dice roll = 2,3, or 12 
        diceVal[0] = 1;
        diceVal[1] = 1;
        betAmt[0] = 100;
        point = 0;
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 200);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 0);

        diceVal[0] = 2;
        diceVal[1] = 1;
        betAmt[0] = 100;
        point = 0;
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 200);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 0);

        diceVal[0] = 7;
        diceVal[1] = 5;
        betAmt[0] = 100;
        point = 0;
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 200);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 0);

        //Test Cases where:
        //Point is not set
        //Dice = 4,6,8,9,10
        //Player doesn't win or lose (payout should be 0, bet amount should remain)
        diceVal[0] = 3;
        diceVal[1] = 1;
        point = 0;
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 0);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 100);

        diceVal[0] = 3;
        diceVal[1] = 3;
        point = 0;
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 0);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 100);

        diceVal[0] = 2;
        diceVal[1] = 6;
        point = 0;
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 0);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 100);

        diceVal[0] = 4;
        diceVal[1] = 5;
        point = 0;
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 0);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 100);

        diceVal[0] = 5;
        diceVal[1] = 5;
        point = 0;
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 0);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 100);

        //Point is set to 4
        //Dice = 7
        //Player wins
        diceVal[0] = 5;
        diceVal[1] = 2;
        point = 4;
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 200);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 0);

        //Point is set to 4
        //Dice != point or 7
        //No Payout, bet amount should remain the same
        diceVal[0] = 3;
        diceVal[1] = 2;
        point = 4;
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 0);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 100);

        //Point is set to 4
        //Dice = point
        //Player loses
        diceVal[0] = 2;
        diceVal[1] = 2;
        point = 4;
        dontPassLineBet.setBetAmount(betAmt);
        dontPassLineBet.checkBetOutcome(diceVal,true, point);
        Assert.assertEquals(dontPassLineBet.getPayOut(), 0);
        Assert.assertEquals(dontPassLineBet.getBetAmount(), 0);


    }
}
