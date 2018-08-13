package com.amar.util.common;

import java.util.List;

/**
 * @author dingmx
 * @date 2018/8/13 01:01
 */
public class SetUtils {

    /**
     * 判断list是否为null或者空
     * @param list
     * @return true: list为null或者空
     */
    public static boolean isNullList(List list) {
        if(list == null || list.size() == 0) {
            return true;
        }
        return false;
    }
}
