package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.Person;
import com.kapcb.ccc.service.IApiThreadPoolService;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * <a>Title: IApiThreadPoolSerivceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/30 22:30
 */
@Service("apiService")
public class IApiThreadPoolServiceImpl implements IApiThreadPoolService {

    @Override
    public Person getPersonById(Long id) {
        if (Objects.equals(1234L, id)) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new Person(1234L, "kapcb", "eirccallroot@163.com", LocalDateTime.now());
    }
}
