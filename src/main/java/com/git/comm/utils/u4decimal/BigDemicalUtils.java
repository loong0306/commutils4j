package com.git.comm.utils.u4decimal;

import java.math.BigDecimal;

public class BigDemicalUtils {
    /**
     * 提供精确加法计算的add方法
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确减法运算的sub方法
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double mul(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale  表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static BigDecimal div(double value1, double value2, int scale) throws IllegalAccessException {
        if (scale < 0) {
            //如果精确范围小于0，抛出异常信息。
            throw new IllegalArgumentException("精确度不能小于0");
        } else if (value2 == 0) {
            //如果除数为0，抛出异常信息。
            throw new IllegalArgumentException("除数不能为0");
        }
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static BigDecimal round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("精确度不能小于0");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供精确加法计算的add方法，确认精确度
     *
     * @param value1 被加数
     * @param value2 加数
     * @param scale  小数点后保留几位
     * @return 两个参数求和之后，按精度四舍五入的结果
     */
    public static BigDecimal add(double value1, double value2, int scale) {
        return round(add(value1, value2), scale);
    }

    /**
     * 提供精确减法运算的sub方法，确认精确度
     *
     * @param value1 被减数
     * @param value2 减数
     * @param scale  小数点后保留几位
     * @return 两个参数的求差之后，按精度四舍五入的结果
     */
    public static BigDecimal sub(double value1, double value2, int scale) {
        return round(sub(value1, value2), scale);
    }

    /**
     * 提供精确乘法运算的mul方法，确认精确度
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @param scale  小数点后保留几位
     * @return 两个参数的乘积之后，按精度四舍五入的结果
     */
    public static BigDecimal mul(double value1, double value2, int scale) {
        return round(mul(value1, value2), scale);
    }


    /**
     * 比较两个 BigDecimal 类型的数值 是否相等
     * 如果 其中一个 为null 返回 false
     * 如果 都为 null 返回 false
     * 如果 相等 返回 true
     * 如果 不等 返回 false
     */
    public static boolean equals(BigDecimal b1, BigDecimal b2) {
        if (b1 == null || b2 == null) {
            return false;
        }
        int i = b1.compareTo(b2);
        if (i != 0) {
            return false;
        }
        return true;
    }

    public static BigDecimal add(BigDecimal... values) {
        if (values.length == 0) {
            return null;
        }
        BigDecimal sum = BigDecimal.valueOf(0);
        for (BigDecimal value : values) {
            if (value == null) {
                value = BigDecimal.valueOf(0);
            }
            sum = sum.add(value);
        }
        return sum;
    }
}
