package com.git.comm.utils.u4string;

/**
 * Created by dragon on 8/20/2017.
 */
public class StringUtils {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public boolean isSNullOrEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
