package com.kapcb.ccc.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <a>Title: JobTwo </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-13:52
 */
@Slf4j
public class JobTwo extends QuartzJobBean {

    private int timeOut;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");

    /**
     * 调度工厂实例化之后，经过timeOut时间开始执行调度==> 指定当服务器启动后过多少秒首次调用工作累
     *
     * @param timeOut int
     */
    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDateTime now = LocalDateTime.now();
        String currentTime = now.format(DATE_TIME_FORMATTER);
        log.warn("JobTwo task is running, current time is : " + currentTime);
    }
}
