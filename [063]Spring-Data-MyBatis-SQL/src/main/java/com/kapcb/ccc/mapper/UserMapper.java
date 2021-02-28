package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.User;

/**
 * <a>Title: UserMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/28 10:46
 */
public interface UserMapper {

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return User
     */
    public User findUserById(Integer id);


    /**
     * 新增用户
     *
     * @param user user
     * @return boolean
     */
    public boolean insertUser(User user);

    /**
     * 新增非自增主键id的用户
     *
     * @param user User
     * @return boolean
     */
    public boolean insertRandomIdUser(User user);
}
