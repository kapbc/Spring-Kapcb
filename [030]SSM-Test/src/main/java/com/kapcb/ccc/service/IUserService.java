package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.User;

import java.util.List;

/**
 * <a>Title:IUserService</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 21:13
 */
public interface IUserService {

    /**
     * 查询所有用户
     *
     * @return List<User>
     */
    public List<User> findAll();

    /**
     * 新增用户
     *
     * @param user user
     * @return boolean
     */
    public void addUser(User user);


}
