package u4string;

import com.git.comm.utils.u4string.StringUtils;
import org.junit.Test;

/**
 * Created by dragon on 8/20/2017.
 */
public class U4stringTest {

    StringUtils stringUtils = new StringUtils();

    @Test
    public void test(){
        System.out.println(stringUtils.isSNullOrEmpty(""));
        System.out.println(stringUtils.isSNullOrEmpty("notNull"));
    }
}
