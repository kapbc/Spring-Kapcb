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
 * @date 2020/6/9 10:43
 */
public interface IUserService {

    /**
     * 查询所有
     *
     * @return List<User>
     */
    public List<User> findAll();

    /**
     * 新增用户
     */
    public void addUser();
}
