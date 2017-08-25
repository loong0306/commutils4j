package com.git.comm.utils.u4datetime;


import com.git.comm.utils.u4string.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeUtils {

    private static String datePatternFirst = "yyyy-MM-dd HH:mm:ss";
    private static String datePatternSecond = "yyyyMMddHHmmss";

    /**
     * 获取当前精确时间 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getNowTimeYMDHMS(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 获取当前日期 yyyy-MM-dd
     * @return
     */
    public static String getNowTimeYMD(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    /**
     * 获取当前日期 HH:mm:ss
     * @return
     */
    public static String getNowTimeHMS(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 形如yyyy-MM-dd HH:mm:ss补足转换成yyyMMddHHmmssSS
     * @param dateString
     * @return
     */
    public static String stringDataPattern(String dateString){
        String result = dateString;
        try {
            if(StringUtils.isEmpty(result)){
                return result;
            }
            if(result.length() < 17){
                result += ":00";
            }
            SimpleDateFormat sdf1 = new SimpleDateFormat(datePatternFirst);
            SimpleDateFormat sdf2 = new SimpleDateFormat(datePatternSecond);
            Date date;
            date = sdf1.parse(result);
            result = sdf2.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 形如yyyyMMddHHmmssSS转换成yyyy-MM-dd HH:mm:ss
     * @param dateString
     * @return
     */
    public static String stringDataPatternSecond(String dateString){
        String result = dateString;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat(datePatternFirst);
            SimpleDateFormat sdf2 = new SimpleDateFormat(datePatternSecond);
            Date date;
            date = sdf2.parse(result);
            result = sdf1.format(date);
            result = result.substring(0, 16);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 计算剩余时间
     * @param "类型yyyyMMddHHmmss"
     */
    public static String dateCount(String start, String end) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String result = "";
        try {
            Date now1 = df.parse(start);
            Date date1 = df.parse(end);
            long l = date1.getTime() - now1.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            result = day + "-" + hour + "-" + min;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 时间转换中文
     * @param dateStr
     */
    public static String getChinaDateSec(String dateStr){
        String ret = "";
        try {
            ret += dateStr.substring(0, 4) + "年";
            ret += dateStr.substring(4, 6) + "月";
            ret += dateStr.substring(6, 8) + "日 ";
            ret += dateStr.substring(8, 10) + "时";
            ret += dateStr.substring(10, 12) + "分";
        } catch (Exception e) {
            ret = dateStr;
            e.printStackTrace();
        }
        return ret;
    }
}
