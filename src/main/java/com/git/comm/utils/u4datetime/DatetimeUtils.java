package com.git.comm.utils.u4datetime;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeUtils {


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
}
