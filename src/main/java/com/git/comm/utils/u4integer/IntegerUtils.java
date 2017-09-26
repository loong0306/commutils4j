package com.git.comm.utils.u4integer;

public class IntegerUtils {

    // 数字转换汉字
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

    // String 类型转换 Integer
    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }
}
