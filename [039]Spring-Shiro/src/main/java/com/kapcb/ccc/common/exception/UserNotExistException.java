package com.kapcb.ccc.common.exception;

/**
 * <a>Title: UserNotExistException </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/9 15:49
 */
public class UserNotExistException extends Exception {
    private static final long serialVersionUID = -7498663418162141757L;

    public UserNotExistException() {
    }

    public UserNotExistException(String message) {
        super(message);
    }

    public UserNotExistException(Exception e) {
        super(e);
    }
}
