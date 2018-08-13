package com.amar.util.tool;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dingmx
 * @date 2018/8/13 00:31
 */
public class ShiroKit {

    private static Logger logger = LoggerFactory.getLogger(ShiroKit.class);

    /**
     * 加盐参数
     */
    public final static String hashAlgorithmName = "MD5";


    /**
     * 设置session值
     * @param key
     * @param value
     */
    public static void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser != null){
            Session session = currentUser.getSession();
            logger.debug("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if(session != null){
                session.setAttribute(key, value);
            }
        }
    }

    /**
     * shiro密码加密工具类
     *
     * @param credentials 密码
     * @return
     */
    public static String md5(String credentials) {
        return new SimpleHash(hashAlgorithmName, credentials).toString();
    }
}
