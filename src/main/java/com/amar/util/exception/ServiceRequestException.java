package com.amar.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author dingmx
 * @date 2018/8/13 00:06
 */
public class ServiceRequestException extends RuntimeException {

    private Logger logger = LoggerFactory.getLogger(ServiceRequestException.class);

    public ServiceRequestException(String message) {
        super(message);
        logger.debug("service request Exception:" + message);
    }

    public ServiceRequestException(String message, Throwable cause) {
        super(message, cause);
        if(cause == null) {
            logger.debug("service request exception cause is null");
            return;
        }
        logger.debug("service request Exception[" + cause.getCause().getClass().getName() + "]" + message);
    }
}
