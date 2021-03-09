package com.kapcb.ccc.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: ThreadLocalUtil </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/8-18:55
 */
@Slf4j
public class ThreadLocalUtil {

    private ThreadLocalUtil() {
    }

    private static final int INITIAL_CAPACITY = 16;
    private static final ThreadLocal<Map<String, Object>> LOCAL = ThreadLocal.withInitial(() -> new HashMap<>(INITIAL_CAPACITY));

    public static <T> T put(String key, T value) {
        log.info("ThreadLocalUtil's put method");
        LOCAL.get().put(key, value);
        log.info("the return value is : " + value);
        return value;
    }

    public static void remove(String key) {
        log.info("ThreadLocalUtil's remove method");
        LOCAL.get().remove(key);
    }

    public static void clear() {
        log.info("ThreadLocalUtil's clear method");
        LOCAL.remove();
    }

    public static <T> T get(String key) {
        log.info("ThreadLocalUtil's get method");
        return (T) LOCAL.get().get(key);
    }
}
