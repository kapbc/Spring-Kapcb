package com.kapcb.ccc.balance.robin.impl;

import com.kapcb.ccc.balance.Invoker;
import com.kapcb.ccc.balance.robin.RoundRobin;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * <a>Title: AbstractRoundRobin </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/8-19:14
 */
@Slf4j
public abstract class AbstractRoundRobin implements RoundRobin {

    protected List<Node> nodes;

    protected boolean checkNodes() {
        return nodes != null && nodes.size() > 0;
    }

    protected static class Node implements Comparable<Node> {

        public final Invoker invoker;
        public Integer weight;
        public Integer effectiveWeight;
        public Integer currentWeight;

        public Node(Invoker invoker) {
            this.invoker = invoker;
            this.currentWeight = 0;
        }

        public Node(Invoker invoker, Integer weight) {
            this.invoker = invoker;
            this.weight = weight;
            this.effectiveWeight = weight;
            this.currentWeight = 0;
        }

        @Override
        public int compareTo(Node o) {
            return currentWeight > o.currentWeight ? 1 : (currentWeight.equals(o.currentWeight) ? 0 : -1);
        }

        /**
         * 调用升级成功
         */
        public void onSuccess() {
            if (effectiveWeight < this.weight) {
                effectiveWeight++;
            }
        }

        /**
         * 调用异常服务降级
         */
        public void onFail() {
            effectiveWeight--;
        }
    }
}
