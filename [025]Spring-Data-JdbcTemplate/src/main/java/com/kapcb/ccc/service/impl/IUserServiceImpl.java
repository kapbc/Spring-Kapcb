package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.IUserMapper;
import com.kapcb.ccc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/6 17:18
 */
@Service(value = "userService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class, readOnly = true)
public class IUserServiceImpl implements IUserService {

    @Autowired
    @Qualifier(value = "userMapper")
    private IUserMapper userMapper;

    @Override
    public List<User> getUserInfoList() {

        return null;
    }

}
