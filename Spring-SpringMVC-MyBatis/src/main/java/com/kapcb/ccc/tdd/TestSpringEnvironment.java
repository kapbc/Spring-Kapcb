package com.kapcb.ccc.tdd;

import com.kapcb.ccc.service.impl.IUserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title: TestSpringEnvironment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/27 - 18:55
 */
public class TestSpringEnvironment {

    @Test
    public void testSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        IUserServiceImpl userService = context.getBean("userService", IUserServiceImpl.class);
        userService.getUserInfoByUserId(1L);
    }
}
