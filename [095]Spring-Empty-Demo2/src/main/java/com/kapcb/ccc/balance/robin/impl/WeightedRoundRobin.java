package com.kapcb.ccc.balance.robin.impl;

import com.kapcb.ccc.balance.Invoker;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Map;

/**
 * <a>Title: WeightedRoundRobin </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/8-19:13
 */
@Slf4j
public class WeightedRoundRobin extends AbstractRoundRobin {

    public WeightedRoundRobin(Map<Invoker, Integer> invokersWeight) {
        if (invokersWeight != null && !invokersWeight.isEmpty()) {
            nodes = new ArrayList<>(invokersWeight.size());
            invokersWeight.forEach((invoker, weight) -> {
                if (invoker.isAvailable()) {
                    nodes.add(new Node(invoker, weight));
                }
            });
        } else {
            nodes = null;
        }
    }

    @Override
    public Invoker select() {
        if (!checkNodes()) {
            return null;
        } else if (nodes.size() == 1) {
            if (nodes.get(0).invoker.isAvailable()) {
                return nodes.get(0).invoker;
            } else {
                return null;
            }
        }
        Integer total = 0;
        Node nodeOfMaxWeight = null;
        for (Node node : nodes) {
            total += node.effectiveWeight;
            node.currentWeight += node.effectiveWeight;
            if (nodeOfMaxWeight == null) {
                nodeOfMaxWeight = node;
            } else {
                nodeOfMaxWeight = nodeOfMaxWeight.compareTo(node) > 0 ? nodeOfMaxWeight : node;
            }
        }
        nodeOfMaxWeight.currentWeight -= total;
        return nodeOfMaxWeight.invoker;
    }
}
