package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <a>Title:UserMapper</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/9 10:41
 */
@Repository
public interface UserMapper {

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
