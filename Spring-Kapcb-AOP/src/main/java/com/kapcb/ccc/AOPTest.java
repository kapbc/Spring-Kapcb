package com.kapcb.ccc;

import com.kapcb.ccc.calculator.Calculator;
import com.kapcb.ccc.calculator.impl.CalculatorImpl;
import com.kapcb.ccc.proxy.CalculatorProxy;

import java.util.Arrays;

/**
 * <a>Title:AOPTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 19:34
 */
public class AOPTest {
    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl();
        calculator.add(1, 2);

        //拿到这个对象的代理对象，代理对象执行 加减乘除
        Calculator proxy = CalculatorProxy.getProxy(calculator);
        proxy.add(3, 4);

        proxy.div(3, 1);

        System.out.println(proxy.getClass() == calculator.getClass());
        System.out.println(calculator);
        System.out.println(proxy.getClass());
        //代理对象的实例
        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
    }
}
