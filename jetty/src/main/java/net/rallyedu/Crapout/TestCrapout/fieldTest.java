
import net.rallyedu.Crapout.field;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zachmanc
 * Date: Sep 8, 2010
 * Time: 1:20:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Test
public class fieldTest {
    public int[] droll;
    public field ftng = new field(5);
    public fieldTest(){
        droll = new int[2];
        droll[0] =1;
        droll[1]= 2;
        ftng.checkBetOutcome(droll,true,5);

    }
    public void testGetReply(){
        Assert.assertEquals(ftng.getPayOut(),10);
    }

}
