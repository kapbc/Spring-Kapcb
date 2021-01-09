package com.kapcb.ccc.common.exception;

/**
 * <a>Title: UserUnLoginException </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/9 15:56
 */
public class UserUnLoginException extends Exception {

    private static final long serialVersionUID = 5685844252030513446L;

    public UserUnLoginException() {
    }

    public UserUnLoginException(String message) {
        super(message);
    }

    public UserUnLoginException(Exception e) {
        super(e);
    }
}
