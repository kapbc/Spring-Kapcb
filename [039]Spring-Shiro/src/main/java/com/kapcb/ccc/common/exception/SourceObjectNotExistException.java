package com.kapcb.ccc.common.exception;

/**
 * <a>Title: SourceObjectNotExsitException </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/8 22:09
 */
public class SourceObjectNotExistException extends Exception {

    private static final long serialVersionUID = 703040037408826231L;

    public SourceObjectNotExistException() {
        super();
    }

    public SourceObjectNotExistException(String message) {
        super(message);
    }

    public SourceObjectNotExistException(Exception e) {
        super(e);
    }
}
