package net.rallyedu.Crapout;

import junit.framework.Assert;
import net.rallyedu.Crapout.PassLine;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: nguyenkb
 * Date: Dec 4, 2010
 * Time: 11:59:02 AM
 * To change this template use File | Settings | File Templates.
 */
@Test
public class PassLineTest {
    public int[] diceVal = new int[2];
    public int[] betAmt = new int[1];
    public int point;
    public void test(){
       //Pass line bet
       //Point is not set
       //Dice = 7  or 11
       //Player should win (1:1 payout)
       diceVal[0] = 3;
       diceVal[1] = 4;
       betAmt[0] = 100;
       point = 0;
       PassLine passLineBet = new PassLine(0);
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, 0);
       Assert.assertEquals(passLineBet.getPayOut(), 200);
       Assert.assertEquals(passLineBet.getBetAmount(), 0);

       diceVal[0] = 7;
       diceVal[1] = 4;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 200);
       Assert.assertEquals(passLineBet.getBetAmount(), 0);

       //Test Case:
       //Pass line bet
       //Point is not set
       //Dice = 2,3, or 12
       //Player should lose (payout should be 0)
       diceVal[0] = 1;
       diceVal[1] = 1;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 0);
       Assert.assertEquals(passLineBet.getBetAmount(), 0);


       diceVal[0] = 1;
       diceVal[1] = 2;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 0);
       Assert.assertEquals(passLineBet.getBetAmount(), 0);

       diceVal[0] = 6;
       diceVal[1] = 6;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 0);
       Assert.assertEquals(passLineBet.getBetAmount(), 0);

        //Point is not set
        //Dice = 4,5, 6,8,9,10
        //Player doesn't win or lose (payout should be 0, bet amount should remain)
       diceVal[0] = 3;
       diceVal[1] = 1;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 0);
       Assert.assertEquals(passLineBet.getBetAmount(), 100);

       diceVal[0] = 4;
       diceVal[1] = 1;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 0);
       Assert.assertEquals(passLineBet.getBetAmount(), 100);

       diceVal[0] = 2;
       diceVal[1] = 4;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 0);
       Assert.assertEquals(passLineBet.getBetAmount(), 100);

       diceVal[0] = 5;
       diceVal[1] = 3;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 0);
       Assert.assertEquals(passLineBet.getBetAmount(), 100);

       diceVal[0] = 6;
       diceVal[1] = 3;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 0);
       Assert.assertEquals(passLineBet.getBetAmount(), 100);

       diceVal[0] = 6;
       diceVal[1] = 4;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 0);
       Assert.assertEquals(passLineBet.getBetAmount(), 100);


       //Point is set to 4
       //Dice = point
       //Player should win
       diceVal[0] = 2;
       diceVal[1] = 2;
       point = 4;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 200);
       Assert.assertEquals(passLineBet.getBetAmount(), 0);

       //Point is set to 4
       //Dice != point and 7
       //No payout, bet amount should remain the same
       diceVal[0] = 2;
       diceVal[1] = 4;
       point = 4;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 0);
       Assert.assertEquals(passLineBet.getBetAmount(), 100);

       //Point is set to 4
       //Dice = 7
       //Player loses
       //No payout, bet amount should be 0
       diceVal[0] = 3;
       diceVal[1] = 4;
       point = 4;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, point);
       Assert.assertEquals(passLineBet.getPayOut(), 0);
       Assert.assertEquals(passLineBet.getBetAmount(), 0);
    }
}
