package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.Key;
import com.kapcb.ccc.domain.Lock;

/**
 * <a>Title: KeyMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/28 10:15
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
