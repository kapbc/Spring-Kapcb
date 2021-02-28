package com.kapcb.ccc.domain;

import java.util.List;

/**
 * <a>Title: Lock </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/28 10:13
 */
public class Lock {

    private Integer id;
    private String lockName;

    /**
     * 查询锁的时候查询出所有钥匙
     */
    private List<Key> keys;

    public Lock() {
    }

    public Lock(Integer id, String lockName, List<Key> keys) {
        this.id = id;
        this.lockName = lockName;
        this.keys = keys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", lockName='" + lockName + '\'' +
                ", keys=" + keys +
                '}';
    }
}
