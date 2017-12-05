package u4string;

import com.git.comm.utils.u4string.NumberUtil;
import com.git.comm.utils.u4string.StringUtils;
import org.junit.Test;

/**
 * Created by dragon on 8/20/2017.
 */
public class U4StringTest {

    @Test
    public void test(){
        // isEmpty
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty("notNull"));
        // isSNullOrEmpty
        System.out.println(StringUtils.isSNullOrEmpty(""));
        System.out.println(StringUtils.isSNullOrEmpty("notNull"));
        // isStrsEmptyOrNull
        System.out.println(StringUtils.isStrsEmptyOrNull("first","second"));
        System.out.println(StringUtils.isStrsEmptyOrNull("first",""));
        // getUUID
        System.out.println(StringUtils.getUUID());
        // utf8Encode
        System.out.println(StringUtils.utf8Encode("utf8"));
        // getHrefInnerHtml
        System.out.println(StringUtils.getHrefInnerHtml("http://github.com"));
        // trimString
        System.out.println(StringUtils.trimString("This is a test string.", 12));
        // NumberUtil-getChinaNumber
        System.out.println(NumberUtil.getChinaNumber(98));
    }
}
