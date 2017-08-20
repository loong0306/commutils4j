package u4integer;

import com.git.comm.utils.u4integer.NumberUtil;
import org.junit.Test;

/**
 * Created by dragon on 8/20/2017.
 */
public class U4NumberUtilTest {

    NumberUtil numberUtil = new NumberUtil();

    @Test
    public void test(){
        System.out.println(numberUtil.getChinaNumber(6));
    }
}
