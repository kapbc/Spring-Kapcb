package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.mapper.AccountMapper;
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
 * <p>
 * MySQL默认的事务隔离级别为 可重复读
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/10 11:20
 */
@Component(value = "accountService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = false, rollbackFor = Exception.class)
public class IAccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier(value = "accountMapper")
    private AccountMapper accountMapper;

    /**
     * test spring transaction
     *
     * @param fromUserId         String
     * @param fromUsername       String
     * @param transferOutBalance BigDecimal
     * @param toUserId           String
     * @param toUsername         String
     * @param transferToBalance  BigDecimal
     * @return boolean
     */
    @Override
    public boolean transferBalance(String fromUserId, String fromUsername, BigDecimal transferOutBalance, String toUserId, String toUsername, BigDecimal transferToBalance) {
        boolean transferOut = accountMapper.transferOutFromAccount(fromUserId, fromUsername, transferOutBalance);
        int i = 10 / 0;
        boolean transferIn = accountMapper.transferInFromAccount(toUserId, toUsername, transferToBalance);

        return transferOut && transferIn;
        //return accountMapper.transferOutFromAccount(fromUserId, fromUsername, transferOutBalance) && accountMapper.transferInFromAccount(toUserId, toUsername, transferToBalance);
    }
}
