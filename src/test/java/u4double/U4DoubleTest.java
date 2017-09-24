package u4double;

import com.git.comm.utils.u4double.DoubleUtils;
import org.junit.Test;

/**
 * Created by dragon on 8/21/2017.
 */
public class U4DoubleTest {

    @Test
    public void test(){
        // 将double类型的数字保留两位小数
        System.out.println(DoubleUtils.formatNumber(3.1415926));
        // 加法
        System.out.println(DoubleUtils.add(1.1,2.2));
        // 减法
        System.out.println(DoubleUtils.sub(5,0.9));
        // 乘法
        System.out.println(DoubleUtils.mul(3.3,0.1));
        // 除法
        System.out.println(DoubleUtils.div(5,0.5));
    }
}
