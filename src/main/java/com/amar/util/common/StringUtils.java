package com.amar.util.common;

import com.amar.domain.Message;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author dingmx
 * @date 2018/8/12 23:03
 */
public class StringUtils {

    /**
     * 判断字符串是否为null或者空串
     * @param str 字符串
     * @return true: 为null或者空串
     */
    public static boolean isNullString(String str) {
        if(str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 对象转字符串
     * @param obj 对象
     * @return 字符串
     */
    public static String objToString(Object obj) {
        return StringUtils.objToString(obj, ToStringStyle.DEFAULT_STYLE);
    }

    /**
     * 对象转字符串
     * @param obj 对象
     * @param style 转字符串风格
     * @return 字符串
     */
    public static String objToString(Object obj, ToStringStyle style) {
        return ReflectionToStringBuilder.toString(obj, style);
    }

    public static void main(String[] args) {
        Message message = new Message();
        message.setId("1010");
        message.setLength(20L);
        message.setType("weChat");
        String result = ReflectionToStringBuilder.toString(new Message(),ToStringStyle.MULTI_LINE_STYLE);
        System.out.println(result);
        System.out.println(StringUtils.objToString(message));
    }
}
