package com.amar.util.common;

import com.amar.domain.Message;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;

/**
 * @author dingmx
 * @date 2018/8/11 01:12
 */
public class JacksonUtils {

    // ObjectMapper
    private static ObjectMapper mapper = new ObjectMapper();

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(JacksonUtils.class);

    /**
     * 将实体对象转化为json字符串
     * @param obj 实体对象
     * @return json字符串
     */
    public static String toJson(Object obj) {
        StringWriter writer = new StringWriter();
        JsonGenerator generator = null;
        try {
            generator = new JsonFactory().createGenerator(writer);
            mapper.writeValue(generator, obj);
        } catch(Exception e) {
            logger.error("创建json生成器异常", e);
        } finally {
            try {
                if(generator != null) generator.close();
            } catch(Exception e) {
                logger.error("关闭json生成器异常", e);
            }
        }
        return writer.toString();
    }

    /**
     * 将json字符串转为实体对象
     * @param jsonStr json字符串
     * @param objClass 实体类
     * @param <T> 泛型
     * @return
     */
    public static <T> T toBean(String jsonStr, Class<T> objClass) {
        try{
            return mapper.readValue(jsonStr, objClass);
        } catch(Exception e) {
            logger.error("json字符串转为实体对象异常", e);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        Message message = new Message();
        message.setId("101");
        message.setType("weChat");
        message.setLength(100L);
        String jsonStr = JacksonUtils.toJson(message);
        logger.debug(jsonStr);
        message = JacksonUtils.toBean(jsonStr, Message.class);
        logger.debug(message.getType());
    }
}
