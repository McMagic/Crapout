package net.rallyedu.Crapout;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by IntelliJ IDEA.
 * User: Crapout! 
 * To change this template use File | Settings | File Templates.
 */


@Test
public class FieldTest {
    public int[] droll;
    public Field ftng = new Field(5);
    public FieldTest(){
        droll = new int[2];
    }

    public void testGetReply(){

        //Dice roll is 3, bet amount = 5, player wins
        //(Payout = 1:1 + bet amount,
        // bet amount = 0
        droll[0] = 1;
        droll[1] = 2;
        ftng.checkBetOutcome(droll,true,5);
	    Assert.assertEquals(ftng.getPayOut(),10);
        Assert.assertEquals(ftng.getBetAmount(), 0);

        //Dice roll is 4, bet amount = 5, player wins
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        ftng = new Field(5);
        droll[0] = 2;
        droll[1] = 2;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),10);
        Assert.assertEquals(ftng.getBetAmount(), 0);

        //Dice roll is 9, bet amount = 5, player wins
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        ftng = new Field(5);
        droll[0] = 3;
        droll[1] = 6;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),10);
        Assert.assertEquals(ftng.getBetAmount(), 0);

        //Dice roll is 10, bet amount = 5, player wins
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        ftng = new Field(5);
        droll[0] = 5;
        droll[1] = 5;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),10);
        Assert.assertEquals(ftng.getBetAmount(), 0);

        //Dice roll is 11, bet amount = 5, player wins
        //Payout = 1:1 + bet amount
        //Bet amount = 0
        ftng = new Field(5);
        droll[0] = 5;
        droll[1] = 6;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),10);
        Assert.assertEquals(ftng.getBetAmount(), 0);

        //Dice roll is 2, bet amount = 5, player wins
        //Payout = 2:1 + bet amount
        //Bet amount = 0
        ftng = new Field(5);
        droll[0] = 1;
        droll[1] = 1;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),15);
        Assert.assertEquals(ftng.getBetAmount(), 0);

        //Dice roll is 12, bet amount = 5, player wins
        //Payout = 2:1 + bet amount
        //Bet amount = 0
        ftng = new Field(5);
        droll[0] = 6;
        droll[1] = 6;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),15);
        Assert.assertEquals(ftng.getBetAmount(), 0);


        //Dice roll is 5, bet amount = 5, player loses
        //Payout = 0
        //Bet amount = 0
        ftng = new Field(5);
        droll[0] = 3;
        droll[1] = 2;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),0);
        Assert.assertEquals(ftng.getBetAmount(), 0);

        //Dice roll is 6, bet amount = 5, player loses
        //Payout = 0
        //Bet amount = 0
        ftng = new Field(5);
        droll[0] = 4;
        droll[1] = 2;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),0);
        Assert.assertEquals(ftng.getBetAmount(), 0);


        //Dice roll is 7, bet amount = 5, player loses
        //Payout = 0
        //Bet amount = 0
        ftng = new Field(5);
        droll[0] = 3;
        droll[1] = 4;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),0);
        Assert.assertEquals(ftng.getBetAmount(), 0);

        //Dice roll is 8, bet amount = 5, player loses
        //Payout = 0
        //Bet amount = 0
        ftng = new Field(5);
        droll[0] = 4;
        droll[1] = 4;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),0);
        Assert.assertEquals(ftng.getBetAmount(), 0);

	 }

}
