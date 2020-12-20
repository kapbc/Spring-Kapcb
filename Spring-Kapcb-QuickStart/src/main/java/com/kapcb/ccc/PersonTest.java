package com.kapcb.ccc;

import com.kapcb.ccc.domain.Person;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title: PersonTest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/20 - 15:14
 */
public class PersonTest {

    @Test
    public void testSpringIoC() {
        // 加载Spring的配置文件
        String configuration = "bean.xml";
        BeanFactory ioc = new ClassPathXmlApplicationContext(configuration);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configuration);

        // 获取配置创建的对象    args: 第一个值为配置文件中bean对应的id属性, 第二个为获取对象的class
        Person person = ioc.getBean("person", Person.class);

        // 调用方法
        person.add();
    }
}
