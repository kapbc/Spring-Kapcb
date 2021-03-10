package com.kapcb.ccc.utils;

import com.kapcb.ccc.balance.robin.RoundRobin;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

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

    private static final String MAIL_PROPERTIES = "mail%d.properties";

    private static final String CHART_SET_UTF8 = "UTF-8";

    private static final String CONTENT_TYPE_HTML = "text/html; charset=UTF-8";

    private static final String READ_SYSTEM_PATH_FILE = "read_system_path_file";

    private static final String READ_CLASS_PATH_FILE = "read_class_path_file";

    private boolean intiComplete = false;

    private RoundRobin roundRobin;

    private MailUtil(String roundRobinType) {

    }

    /**
     * 读取外部配置
     *
     * @param fileName
     * @return
     */
    private InputStream readFromSystemPath(String fileName) {
        String path = System.getProperty("user.dir") + File.separator + fileName;
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            log.error("read from system path error, the error exception is : " + e.getMessage(), e);
        }
        return inputStream;
    }

    /**
     * 读取内部文件
     *
     * @param fileName
     * @return
     */
    private InputStream readClassPath(String fileName) {
        return this.getClass().getClassLoader().getResourceAsStream(fileName);
    }

    private void readConfigFiles(String readPath) {
        InputStream inputStream = null;
        Properties properties = null;
        String fileName = "";
        for (int i = 0; ; i++) {
            fileName = String.format(MAIL_PROPERTIES, i);
            inputStream = READ_SYSTEM_PATH_FILE.equals(readPath) ? readClassPath(fileName) : readClassPath(fileName);
            if (inputStream == null) {
                break;
            }
            log.info("load : " + fileName);
            try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8.toString())) {
                properties = new Properties();
                properties.load(reader);
                if (!checkMailConfig(properties)) {
                    log.info(readPath + " " + fileName + " config error!");
                    break;
                }
                //MailManager.

            } catch (Exception e) {
                log.error("load " + readPath + " " + fileName + " error!", e);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("inputStream close error, the error message is : " + e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 校验mail配置项
     *
     * @param properties
     * @return
     */
    private boolean checkMailConfig(Properties properties) {
        if (null == properties.get("mail.id")) {
            log.error("mail id is not null!");
            return false;
        }
        if (null == properties.get("mail.username")
                || "".equals(properties.get("mail.username"))) {
            log.error("mail username is not null!");
            return false;
        }
        if (null == properties.get("mail.password")
                || "".equals(properties.get("mail.password"))) {
            log.error("mail password is not null!");
            return false;
        }
        if (null != properties.get("mail.weight")
                && !(StringUtils.isNumeric((String) properties.get("mail.weight")))) {
            log.error("mail weight requirement is number!");
            return false;
        }
        if (null == properties.getProperty("mail.isAvailable")) {
            log.error("mail isAvailable is not null!");
            return false;
        }
        try {
            Boolean tmp = Boolean.valueOf((String) properties.get("mail.isAvailable"));
        } catch (Exception e) {
            log.error("mail isAvailable requirement is boolean!");
            return false;
        }
        return true;
    }

    public static boolean send(String to, String subject, String content) {
        return false;
    }
}
