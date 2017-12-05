package com.git.comm.utils.u4string;

/**
 * Created by dragon on 12/5/2017.
 */
public class NumberUtil {
    /**
     * 二十以下的转换
     * @param i
     * @return
     */
    public static String getChinaNumber(int i){
        String number1 = "零一二三四五六七八九";
        String result = "";
        if(i < 10){
            result = number1.substring(i, i + 1);
        }else if(i >= 10 && i < 20){
            result = "十" + number1.substring(i - 10, i -10 + 1);
        }
        return result;
    }
}
