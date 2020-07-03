package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.User;

import java.text.ParseException;
import java.util.List;

/**
 * <a>Title:IUserService</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 14:19
 */
public interface IUserService {

    /**
     * 获取所有用户信息
     * @param id String
     * @return List<User>
     * @throws Exception Exception
     */
    List<User> getAllUserList(String id) throws Exception;
}
