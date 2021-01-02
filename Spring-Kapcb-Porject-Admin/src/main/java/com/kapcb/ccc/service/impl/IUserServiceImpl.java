package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/2 21:54
 */
@Service(value = "userService")
@RequiredArgsConstructor
public class IUserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    @Override
    public List<User> getUserInfoList() {
        List<User> userInfoList = userMapper.getUserInfoList();
        return Objects.equals(null, userInfoList) ? Collections.emptyList() : userInfoList;
    }
}
