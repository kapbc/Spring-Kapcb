package com.kapcb.ccc.commons.service.impl;

import com.kapcb.ccc.commons.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <a>Title: MailServiceImpl </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/9-8:42
 */
@Slf4j
@Component(value = "mailService")
public class MailServiceImpl implements MailService {

    @Value(value = "${}")
    private String fileFolder;

    /**
     * 发送邮件
     *
     * @param to
     * @param title
     * @param content
     * @param attachmentName
     * @param attachmentFile
     * @return
     */
    @Override
    public boolean sendMail(String to, String title, String content, String attachmentName, MultipartFile attachmentFile) throws IOException {
        log.info("come into send mail");
        File tempFile = null;
        log.info("the file folder is : " + fileFolder);
        if (attachmentFile != null) {
            log.info("the attachmentFile is not null");
            File tempFolder = new File(fileFolder);
            if (!tempFolder.exists() || !tempFolder.isDirectory()) {
                log.info("the folder is not exist and is not a directory");
                log.info("begin to create the : " + tempFolder + " folder");
                FileUtils.forceMkdir(tempFolder);
                log.info("create the : " + tempFolder + " success");
            }
            tempFile = new File(fileFolder, attachmentName);
            log.info("the tempFile is : " + tempFile);
            tempFile.createNewFile();
            log.info("create the new file success");
            attachmentFile.transferTo(tempFile);
        }

        return false;
    }

    /**
     * 发送邮件
     *
     * @param to
     * @param title
     * @param content
     * @param attachmentName
     * @param attachmentFile
     */
    @Override
    public void send(String to, String title, String content, String attachmentName, MultipartFile attachmentFile) {
        try {
            log.info("come into send");
            log.info("begin to send the mail");
            sendMail(to, title, content, attachmentName, attachmentFile);
            log.info("send the mail success");
        } catch (IOException e) {
            log.error("send the mail error, the error message is : " + e.getMessage(), e);
        }
    }
}
