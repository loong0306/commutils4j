package u4encrypt;

import com.git.comm.utils.u4encrypt.MD5Utils;
import org.junit.Test;

/**
 * Created by dragon on 8/20/2017.
 */
public class U4Md5Test {

    MD5Utils md5Utils = new MD5Utils();

    @Test
    public void test(){
        // 32位密文
        String md5Str = md5Utils.encryption("this is pwd");
        System.out.println(md5Str);
    }
}
