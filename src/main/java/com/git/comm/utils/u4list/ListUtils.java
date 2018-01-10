package com.git.comm.utils.u4list;

import java.util.*;

public class ListUtils {

    /**
     * 判断对象数组是否为空并且数量大于0
     *
     * @param value
     * @return
     */
    public static Boolean isNotNullAndNotEmpty(Object[] value) {
        boolean bl = false;
        if (null != value && 0 < value.length) {
            bl = true;
        }
        return bl;
    }

    /**
     * 判断对象集合（List,Set）是否为空并且数量大于0
     *
     * @param value
     * @return
     */
    public static Boolean isNotNullAndNotEmpty(Collection<?> value) {
        boolean bl = false;
        if (null != value && 0 < value.size()) {
            bl = true;
        }
        return bl;
    }

    /**
     * 判断集合是否为空
     * @param coll
     * @return
     */
    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }

    /**
     * 拆分list，按500条拆分
     * @param list
     * @return
     */
    public static List<List<String>> splitList(List<String> list){
        List<List<String>> lists = new ArrayList<List<String>>();
        List<String> subList = new ArrayList<String>();
        int size = list.size();
        int sum = 500;
        int count = size / sum;
        int yu = size % sum;
        if (count == 0) {
            lists.add(list);
        } else {
            if(size % sum != 0){
                count ++;
            }
            for (int i = 0; i < count; i++) {
                if(sum*(i+1) <= size){
                    subList = list.subList(sum*i, sum*(i+1));
                }else{
                    subList = list.subList(sum*i, sum*(i)+yu);
                }
                lists.add(subList);
            }
        }
        return lists;
    }
}
