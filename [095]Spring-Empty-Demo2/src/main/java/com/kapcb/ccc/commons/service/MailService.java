package com.kapcb.ccc.commons.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <a>Title: MailService </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/9-8:42
 */
public interface MailService {

    /**
     * 发送邮件
     * @param to
     * @param title
     * @param content
     * @param attachmentName
     * @param attachmentFile
     * @return
     * @throws IOException
     */
    boolean sendMail(String to, String title, String content, String attachmentName, MultipartFile attachmentFile) throws IOException;

    /**
     * 发送邮件
     *
     * @param to
     * @param title
     * @param content
     * @param attachmentName
     * @param attachmentFile
     */
    void send(String to, String title, String content, String attachmentName, MultipartFile attachmentFile);
}
