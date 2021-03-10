package com.kapcb.ccc.balance.robin;

import com.kapcb.ccc.balance.Invoker;

/**
 * <a>Title: RoundRobin </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/8-19:03
 */
public interface RoundRobin {

    /**
     * 轮询
     *
     * @return Invoker
     */
    Invoker select();
}
