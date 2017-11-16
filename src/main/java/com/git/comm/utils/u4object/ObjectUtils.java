package com.git.comm.utils.u4object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectUtils {

    /**
     * 通过反射，遍历对象中各参数的值
     * @param obj
     */
    public static void getSonFromObject(Object obj){
        try {
            Class<? extends Object> objClass = obj.getClass();
            Field[] fields = objClass.getDeclaredFields();
            for (int k = 0; k < fields.length; k++) {
                String fieldName = fields[k].getName();
                Method m = obj.getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
                Object value = m.invoke(obj);
                System.out.println(fieldName + " : " + value);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
