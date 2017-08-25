package u4datetime;

import com.git.comm.utils.u4datetime.DatetimeUtils;
import org.junit.Test;

/**
 * Created by dragon on 8/21/2017.
 */
public class U4DatetimeTest {

    @Test
    public void test(){
        // 获取当前精确时间 yyyy-MM-dd HH:mm:ss
        System.out.println(DatetimeUtils.getNowTimeYMDHMS());
        // 获取当前日期 yyyy-MM-dd
        System.out.println(DatetimeUtils.getNowTimeYMD());
        // 获取当前日期 HH:mm:ss
        System.out.println(DatetimeUtils.getNowTimeHMS());
        // 形如yyyy-MM-dd HH:mm:ss补足转换成yyyMMddHHmmssSS
        System.out.println(DatetimeUtils.stringDataPattern(DatetimeUtils.getNowTimeYMDHMS()));
        // 形如yyyyMMddHHmmssSS转换成yyyy-MM-dd HH:mm:ss
        System.out.println(DatetimeUtils.stringDataPatternSecond(DatetimeUtils.stringDataPattern(DatetimeUtils.getNowTimeYMDHMS())));
        // 计算剩余时间
        System.out.println(DatetimeUtils.dateCount(DatetimeUtils.getNowTimeYMDHMS(),DatetimeUtils.getNowTimeYMDHMS()));
        // 时间转换中文
        System.out.println(DatetimeUtils.getChinaDateSec(DatetimeUtils.getNowTimeYMDHMS()));
    }
}
