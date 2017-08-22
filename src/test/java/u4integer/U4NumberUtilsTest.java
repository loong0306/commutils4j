package u4integer;

import com.git.comm.utils.u4integer.NumberUtils;
import org.junit.Test;

/**
 * Created by dragon on 8/20/2017.
 */
public class U4NumberUtilsTest {

    NumberUtils numberUtils = new NumberUtils();

    @Test
    public void test(){
        System.out.println(numberUtils.getChinaNumber(6));
    }
}
