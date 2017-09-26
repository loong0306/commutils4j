package u4integer;

import com.git.comm.utils.u4integer.IntegerUtils;
import org.junit.Test;

/**
 * Created by dragon on 8/20/2017.
 */
public class U4IntegerUtilsTest {

    @Test
    public void test(){
        System.out.println(IntegerUtils.getChinaNumber(6));
        System.out.println(IntegerUtils.parseInt("987"));
        System.out.println(IntegerUtils.parseInt("noInt"));
    }
}
