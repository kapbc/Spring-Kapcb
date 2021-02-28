package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <a>Title: UserMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/28 10:34
 */
public interface UserMapper {

    /**
     * 模糊查询
     *
     * @param username     username
     * @param loginAccount loginAccount
     * @return List<User>
     */
    public List<User> getAllUserByQuery(@Param("username") String username, @Param("loginAccount") String loginAccount);


    /**
     * 获取所有用户信息
     *
     * @return List<User>
     */
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
     * 获取用户信息
     *
     * @param map map
     * @return User
     */
    public User findUserByIdAndEmail(Map<String, Object> map);

    /**
     * 根据id返回map类型
     *
     * @param id id
     * @return Map<String, Object>
     */
    public Map<String, Object> findUserByIdReturnMap(Integer id);

    /**
     * key为主键，value为封装好的对象
     *
     * @return Map<Integer, User>
     * @MapKey("id")将查询记录对象中的 id 作为 key 封装map
     */
    @MapKey("id")
    public Map<Integer, User> getUserByIdReturnMap();

    /**
     * 根据 ResultMap 结果映射以 id 查询用户
     *
     * @param id id
     * @return User
     */
    public User getUserByIdResultMap(Integer id);

    /**
     * 新增用户
     *
     * @param user user
     * @return boolean
     */
    public boolean insertUser(User user);

}
