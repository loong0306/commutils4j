package u4integer;

import com.git.comm.utils.u4integer.IntegerUtils;
import org.junit.Test;

/**
 * Created by dragon on 8/20/2017.
 */
public class U4IntegerUtilsTest {

    IntegerUtils integerUtils = new IntegerUtils();

    @Test
    public void test(){
        System.out.println(integerUtils.getChinaNumber(6));
    }
}
