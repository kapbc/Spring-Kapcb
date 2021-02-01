package com.kapcb.ccc.service;

/**
 * <a>Title: ICalculatorService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 22:52
 */
public interface ICalculatorService {

    /**
     * 加法
     *
     * @param i int
     * @param j int
     * @return int
     */
    public int add(int i, int j);

    /**
     * 减法
     *
     * @param i int
     * @param j int
     * @return int
     */
    public int sub(int i, int j);

    /**
     * 乘法
     *
     * @param i int
     * @param j int
     * @return int
     */
    public int mul(int i, int j);

    /**
     * 除法
     *
     * @param i int
     * @param j int
     * @return int
     */
    public int div(int i, int j);
}
