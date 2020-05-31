package com.kapcb.ccc.calculator;

/**
 * <a>Title:Calculator</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 19:29
 */
public interface Calculator {

    /**
     * 四则运算
     *
     * @param i object
     * @param j object
     * @return int
     */
    public int add(int i, int j);

    public int sub(int i, int j);

    public int mul(int i, int j);

    public int div(int i, int j);
}
