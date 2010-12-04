import net.rallyedu.Crapout.Field;
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
        droll[0] =1;
        droll[1]= 2;
        ftng.checkBetOutcome(droll,true,5);

    }
    public void testGetReply(){
        Assert.assertEquals(ftng.getPayOut(),10);
    }

}
