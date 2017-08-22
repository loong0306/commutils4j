package com.git.comm.utils.u4string;

/**
 * Double类型金额 转换 大写中文
 *
 * @see "调用方法getTurnMoneys"({@String})
 */
public class ChinaUpperCaseUtil {

    private static String moneyD = new String();
    private static String moneyBefore = new String();
    private static String moneyAfter = new String();


    public static String getTurns(int i) {
        switch (i) {
            case 2:
                moneyD = "拾";
                break;
            case 3:
                moneyD = "佰";
                break;
            case 4:
                moneyD = "仟";
                break;
            case 5:
                moneyD = "万";
                break;
            case 6:
                moneyD = "拾";
                break;
            case 7:
                moneyD = "佰";
                break;
            case 8:
                moneyD = "仟";
                break;
            case 9:
                moneyD = "亿";
                break;
            case 10:
                moneyD = "拾";
                break;

            case 11:
                moneyD = "佰";
                break;
            case 12:
                moneyD = "仟";
                break;
        }
        return moneyD.toString();
    }

    public static String getTurnMoneyWord(String s) {
        switch (Integer.parseInt(s)) {
            case 0:
                return "零";
            case 1:
                return "壹";
            case 2:
                return "贰";
            case 3:
                return "叁";
            case 4:
                return "肆";
            case 5:
                return "伍";
            case 6:
                return "陆";
            case 7:
                return "柒";
            case 8:
                return "捌";
        }
        return "玖";
    }

    public static String getTurnMoneys(String money) {
        StringBuffer moneyA = new StringBuffer();
        try {
            if (money.indexOf("-") != -1) {
                moneyA.append("负");
                money = money.substring(money.indexOf("-") + 1, money.length());
            }
            if (money.indexOf(".") != -1) {
                moneyBefore = money.substring(0, money.indexOf("."));
                moneyAfter = money.substring(money.indexOf(".") + 1, money.length());
            } else {
                moneyBefore = money;
                moneyAfter = "none";
            }
            if (moneyBefore.length() == 1 && moneyBefore.charAt(0) == '0' && moneyAfter == "none") {
                moneyA.append("零");
                moneyA.append("圆");
            } else {
                for (int i = 0; i < moneyBefore.length(); i++) {
                    if (moneyBefore.charAt(i) != '0') {
                        moneyA.append(
                                getTurnMoneyWord(String.valueOf(String.valueOf(moneyBefore.charAt(i))).concat("")));
                        if (moneyBefore.length() != i + 1)
                            moneyA.append(getTurns(moneyBefore.length() - i));
                        continue;
                    }
                    if (moneyBefore.length() - i == 5 && (moneyBefore.length() > 5 && moneyBefore.length() <= 9))
                        moneyA.append("万");
                    if (moneyBefore.length() - i == 9 && moneyBefore.length() > 9)
                        moneyA.append("亿");
                    if (moneyBefore.length() != i + 1 && moneyBefore.charAt(i + 1) != '0')
                        moneyA.append("零");
                }
                if (moneyBefore.length() != 1 || moneyBefore.charAt(0) != '0') {
                    moneyA.append("圆");
                }
            }
            if (!moneyAfter.equals("none")) {
                for (int i = 0; i < moneyAfter.length(); i++) {
                    if (i == 0)
                        if (moneyAfter.charAt(i) != '0') {
                            moneyA.append(
                                    getTurnMoneyWord(String.valueOf(String.valueOf(moneyAfter.charAt(i))).concat("")));

                            moneyA.append("角");
                        } else if (moneyBefore.charAt(0) != '0' && moneyAfter.length() > 1
                                && (!moneyAfter.equals("00")))
                            moneyA.append("零");
                    if (i == 1 && moneyAfter.charAt(i) != '0') {
                        moneyA.append(
                                getTurnMoneyWord(String.valueOf(String.valueOf(moneyAfter.charAt(i))).concat("")));
                        moneyA.append("分");
                    }
                }

            }
            if (moneyAfter.equals("none") || moneyAfter.length() != 2 || moneyAfter.equals("00"))
                moneyA.append("整");
        } catch (Exception exception) {
        }
        return moneyA.toString();
    }

}

