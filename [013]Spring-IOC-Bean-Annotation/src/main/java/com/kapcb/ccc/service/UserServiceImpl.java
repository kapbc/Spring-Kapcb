package com.kapcb.ccc.service;

import org.springframework.stereotype.Service;

/**
 * <a>Title: UserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * <p>
 * 在注解中的value属性值可以省略, 默认值为类名首字母小写
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 21:02
 */
@Service(value = "userService") // <bean id="userService" class="...."/>
public class UserServiceImpl {

    public void transfer() {
        System.out.println("transfer the method in user service...");
    }
}
