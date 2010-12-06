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
public class HardwayTest {
    public int[] droll;

    public HardwayTest(){
        droll = new int[2];
    }
    @Test(parameters = {"dice1","dice2","expected"})
    public void testGetReply(){
        rtest(2,2,35);
        rtest(4,4,45);
        rtest(3,3,45);
        rtest(5,5,35);
    }

    public void rtest(int d1, int d2, int exp){
        Hardway hwt = new Hardway();
        droll[0] = d1;
        droll[1] = d2;
        hwt.setMoneyOnFour(5);
        hwt.setMoneyOnEight(5);
        hwt.setMoneyOnTen(5);
        hwt.setMoneyOnSix(5);
        hwt.checkBetOutcome(droll,true,5);
        Assert.assertEquals(hwt.getPayOut(),exp);
    }


}

