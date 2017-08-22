package com.git.comm.utils.u4double;


import java.text.DecimalFormat;

public class DoubleUtils {
    /**
     * 将double类型的数字保留两位小数（四舍五入）
     *
     * @param number
     * @return
     */
    public static String formatNumber(double number) {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("#0.00");
        return df.format(number);
    }
}
