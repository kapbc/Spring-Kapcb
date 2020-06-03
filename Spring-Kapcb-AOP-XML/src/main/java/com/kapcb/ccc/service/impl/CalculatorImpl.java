package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.service.Calculator;
import org.springframework.stereotype.Service;

/**
 * <a>Title:CalculatorImpl</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/1 19:05
 */
public class CalculatorImpl implements Calculator {

    public int add(int i, int j) {
        return i + j;
    }

    public int sub(int i, int j) {
        return i - j;
    }

    public int mul(int i, int j) {
        return i * j;
    }

    public int div(int i, int j) {
        return i / j;
    }
}
