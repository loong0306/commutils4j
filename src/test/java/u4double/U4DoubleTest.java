package u4double;

import com.git.comm.utils.u4double.DoubleUtils;
import org.junit.Test;

/**
 * Created by dragon on 8/21/2017.
 */
public class U4DoubleTest {

    DoubleUtils doubleUtils = new DoubleUtils();

    @Test
    public void test(){
        System.out.println(doubleUtils.formatNumber(3.1415926));
    }
}
