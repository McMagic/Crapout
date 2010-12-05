package net.rallyedu.Crapout;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Dec 4, 2010
 * Time: 3:08:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Test
public class HardwayTest {
    public int[] droll;

    public HardwayTest(){
        droll = new int[2];
    }
    public void testGetReply(){
        Hardway hwt = new Hardway();
        droll[0] = 2;
        droll[1] = 2;
        hwt.setMoneyOnFour(5);
        hwt.setMoneyOnEight(5);
        hwt.setMoneyOnTen(5);
        hwt.setMoneyOnSix(5);
        hwt.checkBetOutcome(droll,true,5);
        Assert.assertEquals(hwt.getPayOut(),35);
    }

}
