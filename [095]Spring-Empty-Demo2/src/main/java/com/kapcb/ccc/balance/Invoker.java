package com.kapcb.ccc.balance;

/**
 * <a>Title: Invoker </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/8-19:04
 */
public interface Invoker {

    /**
     * 是否可用
     *
     * @return Boolean
     */
    Boolean isAvailable();

    /**
     * Id标识
     *
     * @return String
     */
    String id();
}
