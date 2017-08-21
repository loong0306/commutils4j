package u4datetime;

import com.git.comm.utils.u4datetime.DatetimeUtils;
import org.junit.Test;

/**
 * Created by dragon on 8/21/2017.
 */
public class U4DatetimeTest {

    DatetimeUtils datetimeUtils = new DatetimeUtils();

    @Test
    public void test(){
        // 获取当前精确时间 yyyy-MM-dd HH:mm:ss
        System.out.println(datetimeUtils.getNowTimeYMDHMS());
        // 获取当前日期 yyyy-MM-dd
        System.out.println(datetimeUtils.getNowTimeYMD());
        // 获取当前日期 HH:mm:ss
        System.out.println(datetimeUtils.getNowTimeHMS());
    }
}
