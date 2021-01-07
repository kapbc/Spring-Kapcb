package com.kapcb.ccc.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <a>Title: TestTaskTwo </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-9:41
 */
@Slf4j
@Component("taskJob")
public class TestTaskTwo {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");

    @Scheduled(cron = "0/10 * * * * ?")
    public void testTaskTwo() {
        LocalDateTime now = LocalDateTime.now();
        String currentTime = now.format(DATE_TIME_FORMATTER);
        log.info("The Task Job Two Begin To Run, Current Local Time Is ::: " + currentTime);
    }
}
