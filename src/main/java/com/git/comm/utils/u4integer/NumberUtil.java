package com.git.comm.utils.u4integer;

/**
 * Created by dragon on 4/1/2017.
 */
public class NumberUtil {
    public String getChinaNumber(int i){
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
