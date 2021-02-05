package com.kapcb.ccc.commons.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * <a>Title: DateUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * <p>
 * <p>
 * JDK1.8 解决SimpleDateFormatter线程问题
 * Instant代替Date
 * LocalDateTime代替Calendar
 * DateTimeFormatter代替SimpleDateFormatter   如果是共享变量，可能会出现线程问题
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/5 23:02
 */
public class DateUtil {

    /**
     * 时间元素
     */
    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static final String WEEK = "week";
    private static final String DAY = "day";
    private static final String HOUR = "hour";
    private static final String MINUTE = "minute";
    private static final String SECOND = "second";

    /**
     * 星期元素
     */
    private static final String MONDAY = "monday";
    private static final String TUESDAY = "tuesday";
    private static final String WEDNESDAY = "wednesday";
    private static final String THURSDAY = "thursday";
    private static final String FRIDAY = "friday";
    private static final String SATURDAY = "saturday";
    private static final String SUNDAY = "sunday";

    /**
     * date time formatter
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_HH_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_HH_MM_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_HH_MM_SS_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 本地时间显示格式：区分中文和英文
     */
    private static final DateTimeFormatter SHORT_DATE_TIME = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
    private static final DateTimeFormatter FULL_DATE_TIME = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    private static final DateTimeFormatter LONG_DATE_TIME = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    private static final DateTimeFormatter MEDIUM_DATE_TIME = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

    private DateUtil() {
    }

    /**
     * 获取当前日期
     * yyyy-MM-dd
     *
     * @return String
     */
    public static String getCurrentDate() {
        return String.valueOf(LocalDate.now());
    }

    /**
     * 获取当前时间 24
     * yyyy-MM-dd HH:mm:ss
     *
     * @return String
     */
    public static String getCurrentTime() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER_HH_MM_SS_EN);
    }
}
