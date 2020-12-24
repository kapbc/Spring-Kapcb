package com.kapcb.ccc.cache.impl;

import com.kapcb.ccc.cache.ICache;

import java.util.HashMap;
import java.util.Objects;

/**
 * <a>Title: CacheMap </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/23 - 22:42
 */
public class CacheMap implements ICache {

    private static final int maxSize = 1000;
    private static final long expireTime = 15 * 60L;

    private static final HashMap<Long, Object> store = new HashMap<>(maxSize);

    private CacheMap() {
    }

    public static final CacheMap getInstance() {
        return Lazy.CACHE_MAP;
    }

    private static final class Lazy {
        public static final CacheMap CACHE_MAP = new CacheMap();
    }

    @Override
    public void put(long id, Object value) {
        if (shouldBeClear(id) || isMaxSize()) {
            clear();
        }
        store.put(id, value);
    }


    @Override
    public boolean remove(long id) {
        return false;
    }

    @Override
    public boolean clear() {
        try {
            store.clear();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean shouldBeClear(long id) {
        return false;
    }

    public boolean isMaxSize() {
        return false;
    }


}
