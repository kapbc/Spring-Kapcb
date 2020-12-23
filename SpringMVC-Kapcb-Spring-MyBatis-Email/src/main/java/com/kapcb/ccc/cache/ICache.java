package com.kapcb.ccc.cache;

/**
 * <a>Title: ICache </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/23 - 22:41
 */
public interface ICache<T> {

    void put(long id, T value);

    boolean remove(long id);

    boolean clear();

    int size();

    boolean shouldBeClear(long id);

}
