package com.kapcb.ccc.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * <a>Title: MailUtil </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/8-18:54
 */
@Slf4j
public class MailUtil {

    private MailUtil() {
    }

    private static final String mail_properties = "mail%d.properties";

    private static final String chart_set_utf8 = "UTF-8";

    private static final String content_type_html = "text/html; charset=UTF-8";

    private static final String read_system_path_file = "read_system_path_file";

    private static final String read_class_path_file = "read_class_path_file";

    private boolean intiComplete = false;


}
