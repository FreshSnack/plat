package com.amar.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dingmx
 * @date 2018/8/13 00:16
 */
public class DaoRequestException extends RuntimeException {

    private Logger logger = LoggerFactory.getLogger(DaoRequestException.class);

    public DaoRequestException(String message) {
        super(message);
        logger.debug("dao request Exception:" + message);
    }

    public DaoRequestException(String message, Throwable cause) {
        super(message, cause);
        if(cause == null) {
            logger.debug("dao request exception cause is null");
            return;
        }
        logger.debug("dao request Exception[" + cause.getCause().getClass().getName() + "]" + message);
    }
}
