package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.Key;
import com.kapcb.ccc.domain.Lock;

/**
 * <a>Title:KeyMapper</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/5 16:30
 */
public interface KeyMapper {

    /**
     * 将钥匙和锁信息一起查出
     *
     * @param id id
     * @return Key
     */
    public Key getKeyById(int id);

    /**
     * 根据id查询锁
     *
     * @param id id
     * @return Lock
     */
    public Lock getLockById(int id);
}
