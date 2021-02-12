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
 * @date 2021/2/13 0:08
 */
@Component(value = "userService")
public class IUserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(IUserServiceImpl.class);

    @Override
    public void testSpringExtension(String word) {
        System.out.println("==============================================");
        log.warn("test the spring extension : Hello " + word);
        System.out.println("==============================================");
    }
}
