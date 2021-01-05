package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.Person;
import com.kapcb.ccc.service.IApiThreadPoolService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * <a>Title: ThreadPoolController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/30 22:23
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class ThreadPoolController {

    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private final IApiThreadPoolService apiThreadPoolService;

    @ResponseBody
    @PostMapping(value = "/getPersonById/{id}", produces = "application/json,charset=UTF-8")
    public void execute(@PathVariable Long id) {
        ThreadFactory threadFactory = new CustomizableThreadFactory("Kapcb-Thread-Pool-");
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(20);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 500, TimeUnit.MILLISECONDS, queue, threadFactory);
        logger.warn("---Begin to process---");
        Future<?> future = executor.submit(() -> apiThreadPoolService.getPersonById(id));
        try {
            future.get(5, TimeUnit.SECONDS);
            logger.warn("---Process Success---");
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            logger.error("---Future Process Error---" + e.getMessage());
            future.cancel(true);
        }
    }
}
