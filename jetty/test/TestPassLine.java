import junit.framework.Assert;
import net.rallyedu.Crapout.passLine;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: nguyenkb
 * Date: Dec 4, 2010
 * Time: 11:59:02 AM
 * To change this template use File | Settings | File Templates.
 */
@Test
public class TestPassLine {
    public int[] diceVal = new int[2];
    public int[] betAmt = new int[1];
    public void test(){
       diceVal[0] = 3;
       diceVal[1] = 4;
       betAmt[0] = 100;

       //Testing pass line bet
       //Point is not set
       //Dice = 7
       //Player should win (1:1 payout)
       passLine passLineBet = new passLine(0);
       passLineBet.setBetAmount(betAmt);
       passLineBet.checkBetOutcome(diceVal,true, 0);
       Assert.assertEquals(passLineBet.getPayOut(), 150);
    }
}
