package com.kapcb.ccc.exception;

/**
 * <a>Title:SystemException</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 自定义异常类
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 17:41
 */
public class SystemException extends Exception {
    private static final long serialVersionUID = 8415167801186847670L;

    private String message;

    public SystemException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
