package com.git.comm.utils.u4list;

import java.util.Collection;

public class ListUtils {

    /**
     * 判断集合是否为空
     * @param coll
     * @return
     */
    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }
}
