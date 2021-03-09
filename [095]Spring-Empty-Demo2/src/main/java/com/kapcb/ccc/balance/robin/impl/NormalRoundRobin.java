package com.kapcb.ccc.balance.robin.impl;

import com.kapcb.ccc.balance.Invoker;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a>Title: NormalRoundRobin </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/8-19:22
 */
@Slf4j
public class NormalRoundRobin extends AbstractRoundRobin {

    private final AtomicInteger position = new AtomicInteger();

    public NormalRoundRobin(List<Invoker> invokers) {
        log.info("NormalRoundRobin");
        nodes = new ArrayList<>(invokers.size());
        invokers.forEach(invoker -> nodes.add(new Node(invoker)));
    }

    @Override
    public Invoker select() {
        if (!checkNodes()) {
            return null;
        }
        int index = position.updateAndGet(p -> p + 1 < nodes.size() ? p + 1 : 0);
        return nodes.get(index).invoker;
    }
}
