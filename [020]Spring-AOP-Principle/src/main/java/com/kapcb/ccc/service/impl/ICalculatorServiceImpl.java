package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.service.ICalculatorService;
import org.springframework.stereotype.Service;

/**
 * <a>Title: ICalculatorServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 22:54
 */
@Service(value = "calculatorService")
public class ICalculatorServiceImpl implements ICalculatorService {

    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
