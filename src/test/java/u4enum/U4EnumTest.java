package u4enum;

import com.git.comm.utils.u4enum.BusinessEnum;
import org.junit.Test;

/**
 * Created by dragon on 12/6/2017.
 */
public class U4EnumTest {
    @Test
    public void test() {
        // getList
        System.out.println(BusinessEnum.getList().toString());
        // getMap2List
        System.out.println(BusinessEnum.getMap2List().toString());
    }
}
