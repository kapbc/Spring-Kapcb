package com.kapcb.ccc.balance.robin.factory;

import com.kapcb.ccc.balance.Invoker;
import com.kapcb.ccc.balance.robin.RoundRobin;
import com.kapcb.ccc.balance.robin.impl.NormalRoundRobin;
import com.kapcb.ccc.balance.robin.impl.WeightedRoundRobin;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * <a>Title: RoundRobinFactory </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/8-19:06
 */
@Slf4j
public class RoundRobinFactory {

    /**
     * 正常
     */
    public static final String NORMAL = "normal";

    /**
     * 权重
     */
    public static final String WEIGHTED = "weighted";

    public static RoundRobin create(String type, final Collection<Properties> properties) {
        switch (type) {
            case WEIGHTED:
                Map<Invoker, Integer> invokerMap = new HashMap<>(properties.size());
                properties.stream().forEach(element -> {
                    invokerMap.put(new Invoker() {
                        @Override
                        public Boolean isAvailable() {
                            return Boolean.valueOf(element.getProperty("mail.isAvailable"));
                        }

                        @Override
                        public String id() {
                            return element.getProperty("mail.id");
                        }
                    }, Integer.valueOf(element.getProperty("mail.weight")));
                });
                return new WeightedRoundRobin(invokerMap);
            case NORMAL:
                List<Invoker> invokerList = properties.stream().map(element -> new Invoker() {
                    @Override
                    public Boolean isAvailable() {
                        return Boolean.valueOf(element.getProperty("mail.isAvailable"));
                    }

                    @Override
                    public String id() {
                        return element.getProperty("mail.id");
                    }
                }).collect(Collectors.toList());
                return new NormalRoundRobin(invokerList);
            default:
                return null;
        }
    }
}
