package u4decimal;

import com.git.comm.utils.u4decimal.BigDemicalUtils;
import org.junit.Test;

/**
 * Created by dragon on 6/21/2018.
 */
public class U4BigDecimalTest {
    @Test
    public void test() throws IllegalAccessException {
        // 提供精确加法计算的add方法
        System.out.println(BigDemicalUtils.add(1.11, 2.22));
        // 提供精确减法运算的sub方法
        System.out.println(BigDemicalUtils.sub(1.11, 2.22));
        // 提供精确乘法运算的mul方法
        System.out.println(BigDemicalUtils.mul(1.11, 2.22));
        // 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
        System.out.println(BigDemicalUtils.div(1.11, 2.22, 3));
    }
}
