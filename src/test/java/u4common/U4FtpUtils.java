package u4common;

import com.git.comm.utils.u4common.FtpUtils;
import org.junit.Test;

/**
 * Created by dragon on 10/16/2017.
 */
public class U4FtpUtils {

    private final String downloadFtpName = "";
    private final String downloadFtpPwd = "";
    private final String downloadFtpUrl = "";
    private final String downloadFtpFolder = "";

    private final String uploadFtpName = "";
    private final String uploadFtpPwd = "";
    private final String uploadFtpUrl = "";
    private final String uploadFtpFolder = "";

    @Test
    public void test() throws Exception {
        String sourcePath = "ftp://" + downloadFtpName + ":" + downloadFtpPwd + "@" + downloadFtpUrl + downloadFtpFolder;
        String targetPath = "ftp://" + uploadFtpName + ":" + uploadFtpPwd + "@" + uploadFtpUrl + uploadFtpFolder;
        FtpUtils.copyFile(sourcePath, targetPath);
    }
}
