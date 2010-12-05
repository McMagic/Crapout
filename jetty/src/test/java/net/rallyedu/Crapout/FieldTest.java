package net.rallyedu.Crapout;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Dec 4, 2010
 * Time: 11:59:35 AM
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

        droll[0] =1;
        droll[1]= 2;
        ftng.checkBetOutcome(droll,true,5);
	    Assert.assertEquals(ftng.getPayOut(),10);

        ftng = new Field(5);
        droll[0] = 1;
        droll[1] = 1;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),15);

        ftng = new Field(5);
        droll[0] = 6;
        droll[1] = 6;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),15);

        ftng = new Field(5);
        droll[0] = 4;
        droll[1] = 2;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),0);

        ftng = new Field(5);
        droll[0] = 2;
        droll[1] = 9;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),10);

        ftng = new Field(5);
        droll[0] = 3;
        droll[1] = 4;
        ftng.checkBetOutcome(droll,true,9);
        Assert.assertEquals(ftng.getPayOut(),0);
	 }

}
