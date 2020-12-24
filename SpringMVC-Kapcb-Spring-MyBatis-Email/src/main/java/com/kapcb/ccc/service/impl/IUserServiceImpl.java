package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.map.IUserMapper;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/24 - 18:28
 */
@Service("IUserService")
@RequiredArgsConstructor
public class IUserServiceImpl implements IUserService {

    private IUserMapper userMapper;

    @Override
    public List<User> getUserListForEmail() {
        return userMapper.getUserListForEmail();
    }

    @Override
    public User getUserInfoByUserId(Long userId) {
        return userMapper.getUserInfoByUserId(userId);
    }


}
