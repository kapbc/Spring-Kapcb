package com.kapcb.ccc;

import com.kapcb.ccc.calculator.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:AOPTest02</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 23:48
 */
public class AOPTest02 {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1, 2);
        bean.div(1, 0);
        System.out.println(bean);
        System.out.println(bean.getClass());
    }
}
