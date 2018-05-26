package com.git.comm.utils.u4string;

import com.git.comm.utils.u4list.ListUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * 判断一个或多个对象是否为空
     *
     * @param values
     *          可变参数，要判断的一个或多个对象
     * @return 只有要判断的一个对象都为空则返回true,否则返回false
     */
    public static boolean isNull(Object... values) {
        if (!ListUtils.isNotNullAndNotEmpty(values)) {
            return true;
        }
        for (Object value : values) {
            boolean flag = false;
            if (value instanceof Object[]) {
                flag = !ListUtils.isNotNullAndNotEmpty((Object[]) value);
            } else if (value instanceof Collection<?>) {
                flag = !ListUtils.isNotNullAndNotEmpty((Collection<?>) value);
            } else if (value instanceof String) {
                flag = isOEmptyOrNull(value);
            } else {
                flag = (null == value);
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOEmptyOrNull(Object o) {
        return o == null ? true : isSEmptyOrNull(o.toString());
    }

    public static boolean isSEmptyOrNull(String s) {
        return trimAndNullAsEmpty(s).length() <= 0 ? true : false;
    }

    public static String trimAndNullAsEmpty(String s) {
        if (s != null && !s.trim().equals("-")) {
            return s.trim();
        } else {
            return "";
        }
    }


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

    /**
     * 返回一个utf8的字符串
     * @param str
     * @return str
     */
    public static String utf8Encode(String str) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UnsupportedEncodingException occurred.", e);
            }
        }
        return str;
    }

    /**
     * 返回一个html
     * @param href
     * @return href
     */
    public static String getHrefInnerHtml(String href) {
        if (isEmpty(href)) {
            return "";
        }
        String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
        Pattern hrefPattern = Pattern.compile(hrefReg,
                Pattern.CASE_INSENSITIVE);
        Matcher hrefMatcher = hrefPattern.matcher(href);
        if (hrefMatcher.matches()) {
            return hrefMatcher.group(1);
        }
        return href;
    }

    /**
     * 如果字符串没有超过最长显示长度返回原字符串，否则从开头截取指定长度并加...返回。
     * @param str
     * @param length
     * @return str
     */
    public static String trimString(String str, int length) {
        if (str == null) {
            return "";
        } else if (str.length() > length) {
            return str.substring(0, length - 3) + "...";
        } else {
            return str;
        }
    }
}
