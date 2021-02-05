package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.LoginLog;
import com.kapcb.ccc.service.ILoginLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * <a>Title: ILoginLogServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/5 22:51
 */
@Service(value = "loginLogService")
public class ILoginLogServiceImpl implements ILoginLogService {

    @Override
    public boolean loginLog(LoginLog loginLog) {
        loginLog = Optional.ofNullable(loginLog).orElseGet(LoginLog::new);
        LocalDateTime loginTime = loginLog.getLoginTime();
        loginTime = Optional.ofNullable(loginTime).orElseGet(LocalDateTime::now);

        System.out.println("user login's log is : " + loginLog);
        return true;
    }
}