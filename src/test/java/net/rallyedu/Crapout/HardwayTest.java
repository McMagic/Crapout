package net.rallyedu.Crapout;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Crapout!
 * To change this template use File | Settings | File Templates.
 */
public class HardwayTest {
    public int[] droll;

    public HardwayTest(){
        droll = new int[2];
    }
    @Test(parameters = {"dice1","dice2","expected payout", "expected bet amount"})
    public void testGetReply(){
        //Rolled hard 4 - Player wins
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        rtest(2,2,35,0);

        //Rolled hard 8 - Player wins
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        rtest(4,4,45,0);

        //Rolled hard 6 - Player wins
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        rtest(3,3,45,0);

        //Rolled hard 10 - Player wins
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        rtest(5,5,35,0);

        //Rolled 4 (but not hard 4) - Player loses
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        rtest(3,1,0,0);

        //Rolled 6 (but not hard 4) - Player loses
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        rtest(2,4,0,0);

        //Rolled 8 (but not hard 8) - Player loses
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        rtest(2,6,0,0);

        //Rolled 10 (but not hard 4) - Player loses
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        rtest(4,6,0,0);
    }

    public void rtest(int d1, int d2, int exp1, int exp2){
        Hardway hwt = new Hardway();
        droll[0] = d1;
        droll[1] = d2;
        hwt.setMoneyOnFour(5);
        hwt.setMoneyOnEight(5);
        hwt.setMoneyOnTen(5);
        hwt.setMoneyOnSix(5);
        hwt.checkBetOutcome(droll,true,5);
        Assert.assertEquals(hwt.getPayOut(),exp1);
        Assert.assertEquals(hwt.getBetAmount(),exp2);
    }


}

