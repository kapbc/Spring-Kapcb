package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.service.ILogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a>Title: ILogServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/12 13:48
 */
public class ILogServiceImpl implements ILogService {

    private static final Logger log = LoggerFactory.getLogger(ILogServiceImpl.class);
    private static final Map<String, String> USER_MAP = new HashMap<>(4);

    static {
        log.warn("begin to initial the user map");
        USER_MAP.put("kapcb", "123456");
    }

    @Override
    public boolean login(String username, String password) {
        log.warn("begin to process the login logic");
        String kapcb = USER_MAP.getOrDefault("kapcb", "");
        if (Objects.equals(kapcb, password)) {
            log.warn("user login success");
            return true;
        }
        log.warn("user login fail");
        return false;
    }
}
