package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.mapper.AccountMapper;
import com.kapcb.ccc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * <a>Title: IAccountServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/10 11:20
 */
@Component(value = "accountService")
public class IAccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier(value = "accountMapper")
    private AccountMapper accountMapper;

}
