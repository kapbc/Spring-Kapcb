package com.kapcb.ccc.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <a>Title: UnExtendJobOne </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-14:22
 */
@Slf4j
@Service(value = "unExtendJobOne")
public class UnExtendJobOne {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");

    public void doJobOne() {
        LocalDateTime now = LocalDateTime.now();
        String currentTime = now.format(DATE_TIME_FORMATTER);
        log.warn("Un extend Quartz Job Bean Job One Task is running, current time is : " + currentTime);
    }
}
