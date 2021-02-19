package com.kapcb.ccc.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <a>Title: TestTask </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-9:17
 */
@Slf4j
@Service
public class TestTask {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");

    public void jobTaskOne() {
        LocalDateTime now = LocalDateTime.now();
        String currentTime = now.format(DATE_TIME_FORMATTER);
        log.info("The Task Job Begin To Run, Current Local Time is ::: " + currentTime);
    }
}