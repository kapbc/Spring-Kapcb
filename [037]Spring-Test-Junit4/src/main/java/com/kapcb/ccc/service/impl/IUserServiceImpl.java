package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/12 23:53
 */
@Component(value = "userService")
public class IUserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(IUserServiceImpl.class);

    @Override
    public void testSpringJunit4ClassRunner(String word) {
        System.out.println("==============================================");
        log.warn("test the spring junit 4 class runner : Hello " + word);
        System.out.println("==============================================");
    }
}
