package com.kapcb.ccc;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * <a>Title:Test02</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/9 9:44
 */
public class Test02 {


    @Test
    public void findAll() {
        ApplicationContext IoC = new ClassPathXmlApplicationContext("spring-context.xml");
        IUserService bean = (IUserService) IoC.getBean("IUserService");
        List<User> all = bean.findAll();
        all.stream().forEach(System.out::println);
    }


}
