package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.User;

/**
 * <a>Title:UserMapper</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/2 21:03
 */
public interface UserMapper {

    /**
     * 根据 id 查询用户信息
     *
     * @param id id
     * @return User
     */
    public User findUserById(Integer id);

    /**
     * 修改用户
     *
     * @param user User
     */
    public void updateUser(User user);

    /**
     * 添加用户
     *
     * @param user User
     */
    public int addUser(User user);

    /**
     * 删除用户
     *
     * @param id id
     */
    public void deleteUser(Integer id);

}
