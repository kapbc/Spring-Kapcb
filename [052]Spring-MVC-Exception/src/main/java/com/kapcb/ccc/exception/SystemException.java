package com.kapcb.ccc.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <a>Title: SystemException </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/23 23:08
 */
public class SystemException extends Exception {

    private static final Logger log = LoggerFactory.getLogger(SystemException.class);

    private static final long serialVersionUID = 8415167801186847670L;

    private String message;

    public SystemException(String message) {
        log.error("System error, the exception is : " + message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
