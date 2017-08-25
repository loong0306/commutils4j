package com.git.comm.utils.u4string;

import java.util.UUID;

public class StringUtils {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isSNullOrEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * 判断字符串组是否为空
     * @param strs
     * @return
     */
    public static boolean isStrsEmptyOrNull(String... strs) {
        if(strs != null && strs.length != 0) {
            String[] arr$ = strs;
            int len$ = strs.length;
            for(int i$ = 0; i$ < len$; ++i$) {
                String str = arr$[i$];
                if(str == null || str.trim().equals("")) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * 随机获取32位UUID字符串(无中划线)
     *
     * @return UUID字符串
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
    }
}
