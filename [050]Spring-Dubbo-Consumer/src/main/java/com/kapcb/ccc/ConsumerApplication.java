package com.kapcb.ccc;

import com.kapcb.ccc.service.IConsumerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:ConsumerApplication</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 14:39
 */
public class ConsumerApplication {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        ioc.start();
        IConsumerService consumerService = ioc.getBean(IConsumerService.class);
        consumerService.init("a");
        System.in.read();
    }
}
