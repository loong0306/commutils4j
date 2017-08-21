package u4double;

import com.git.comm.utils.u4double.DoubleUtil;
import org.junit.Test;

/**
 * Created by dragon on 8/21/2017.
 */
public class U4DoubleTest {

    DoubleUtil doubleUtil = new DoubleUtil();

    @Test
    public void test(){
        System.out.println(doubleUtil.formatNumber(3.1415926));
    }
}
