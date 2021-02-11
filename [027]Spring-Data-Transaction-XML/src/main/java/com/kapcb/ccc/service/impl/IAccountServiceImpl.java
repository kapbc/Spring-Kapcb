package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.mapper.impl.IAccountMapperImpl;
import com.kapcb.ccc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * <a>Title: IAccountServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/11 11:24
 */
@Component(value = "accountService")
public class IAccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("accountMapper")
    private IAccountMapperImpl accountMapper;

    @Override
    public boolean transferBalance(String fromUserId, String fromUsername, BigDecimal balanceOut, String toUserId, String toUsername) {
        boolean transferOut = accountMapper.transferOutBalance(fromUserId, fromUsername, balanceOut);
        int i = 10 / 0;
        boolean transferIn = accountMapper.transferInBalance(toUserId, toUsername, balanceOut);
        return transferOut && transferIn;
    }
}
