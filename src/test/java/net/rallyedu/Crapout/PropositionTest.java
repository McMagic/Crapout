package net.rallyedu.Crapout;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Crapout! 
 * To change this template use File | Settings | File Templates.
 */
public class PropositionTest {
    public int[] diceVal = new int[2];
    public int[] betAmt = new int[6];
    @Test(parameters = {"dice1", "dice2", "expected payout", "expected bet amount"})
    public void testGetReply(){
        //Rolled a 7 - Player Wins
        //Bet is on Any 7
        //Payout = 4:1 + bet amount
        //Bet amount = 0
        setBetAmt(10,0,0,0,0,0);
        setPropositionTest(2,5,50,0);
        
        //Rolled a 2 - Player Wins
        //Bet is on any craps
        //Payout = 30:1 + bet amount
        //Bet amount = 0
        setBetAmt(0,10,0,0,0,0);
        setPropositionTest(1,1,80,0);

        //Rolled a 2 - Player Wins
        //Bet is on Any Craps and Craps 2
        //Payout = 30:1 + from Craps 2 + bet amount + 7:1 from any Craps + Bet Amount
        //Bet amount = 0
        setBetAmt(0,10,10,0,0,0);
        setPropositionTest(1,1,390,0);


        //Rolled a 3 - Player Wins
        //Bet is on Any Craps
        //Payout = 30:1 + bet amount
        //Bet amount = 0
        setBetAmt(0,10,0,0,0,0);
        setPropositionTest(1,2,80,0);

        //Rolled a 3 - Player Wins
        //Bet is on Any Craps and Craps 3
        //Payout = 15:1 + from Craps 2 + bet amount + 7:1 from any Craps + Bet Amount
        //Bet amount = 0
        setBetAmt(0,10,0,10,0,0);
        setPropositionTest(2,1,240,0);

        //Rolled a 12 - Player Wins
        //Bet is on any craps
        //Payout = 30:1 + bet amount
        //Bet amount = 0
        setBetAmt(0,10,0,0,0,0);
        setPropositionTest(6,6,80,0);

        //Rolled a 12 - Player Wins
        //Bet is on Any Craps and Craps 2
        //Payout = 30:1 + from Craps 2 + bet amount + 7:1 from any Craps + Bet Amount
        //Bet amount = 0
        setBetAmt(0,10,0,0,10,0);
        setPropositionTest(6,6,390,0);

        //Rolled an 11 - Player wins
        //Bet is on yo Eleven!
        //Payout = 15:1 + Bet amount
        setBetAmt(0,0,0,0,0,10);
        setPropositionTest(5,6,160,0);

        //Rolled an 8 - Player Loses
        //bet is on yo Eleven!
        //Payout = 0
        //bet amount = 0
        setBetAmt(0,0,0,0,0,10);
        setPropositionTest(2,6,0,0);


    }

    public void setBetAmt (int n1, int n2, int n3, int n4, int n5, int n6){
        betAmt[0] = n1;
        betAmt[1] = n2;
        betAmt[2] = n3;
        betAmt[3] = n4;
        betAmt[4] = n5;
        betAmt[5] = n6; 

    }
    public void setPropositionTest(int d1, int d2, int exp1, int exp2){
        Proposition propositionBet = new Proposition();
        diceVal[0] = d1;
        diceVal[1] = d2;
        propositionBet.setBetAmount(betAmt);
        propositionBet.checkBetOutcome(diceVal,true, 5);

        Assert.assertEquals(propositionBet.getPayOut(), exp1);
        Assert.assertEquals(propositionBet.getBetAmount(), exp2);
    }
}
