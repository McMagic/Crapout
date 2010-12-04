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

       diceVal[0] = 7;
       diceVal[1] = 4;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, 0);
       Assert.assertEquals(passLineBet.getPayOut(), 200);

       //Test Case:
       //Pass line bet
       //Point is not set
       //Dice = 2,3, or 12
       //Player should lose (payout should be 0)
       diceVal[0] = 1;
       diceVal[1] = 1;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, 0);
       Assert.assertEquals(passLineBet.getPayOut(), 0);

       diceVal[0] = 1;
       diceVal[1] = 2;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, 0);
       Assert.assertEquals(passLineBet.getPayOut(), 0);

       diceVal[0] = 6;
       diceVal[1] = 6;
       point = 0;
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, 0);
       Assert.assertEquals(passLineBet.getPayOut(), 0);

        

    }
}
