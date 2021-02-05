package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.LoginLog;

/**
 * <a>Title: ILoginLogService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/5 22:49
 */
public interface ILoginLogService {

    /**
     * login log
     *
     * @param loginLog {@link LoginLog}
     * @return boolean
     */
    boolean loginLog(LoginLog loginLog);
}
