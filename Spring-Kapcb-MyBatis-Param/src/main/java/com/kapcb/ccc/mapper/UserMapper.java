package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <a>Title:UserMapper</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/3 23:17
 */
public interface UserMapper {

    public List<User> getAllUser();


    /**
     * 根据id查询用户
     *
     * @param id id
     * @return user
     */
    public User findUserById(Integer id);

    /**
     * 根据id和用户名查询用户(多条件查询)
     *
     * @param id       id
     * @param username username
     * @return User
     */
    public User findUserByIdAndUsername(Integer id, String username);

    /**
     * 基于注解的方式
     *
     * @param id     id
     * @param gender gender
     * @return User
     */
    public User findUserByIdAndGender(@Param("id") Integer id, @Param("gender") String gender);

    /**
     *
     * @param map
     * @return
     */
    public User findUserByIdAndEmail(Map<String, Object> map);

    /**
     * 新增用户
     *
     * @param user user
     * @return boolean
     */
    public boolean insertUser(User user);

}
