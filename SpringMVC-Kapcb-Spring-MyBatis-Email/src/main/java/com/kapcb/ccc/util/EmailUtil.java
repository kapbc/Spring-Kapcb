package com.kapcb.ccc.util;

import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.resolver.DataSourceCompositeResolver;
import org.apache.commons.mail.resolver.DataSourceFileResolver;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * <a>Title: EmailUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/23 - 21:23
 */
public class EmailUtil {

    public String hostname;

    private String emailAddress;

    private String password;

    private String emailTo;

    private String name;

    private String emailFrom;

    private EmailUtil() {
    }

    public static EmailUtil getInstance() {
        return LazyHold.EMAIL_UTIL;
    }

    private static final class LazyHold {
        public static final EmailUtil EMAIL_UTIL = new EmailUtil();
    }

    /**
     * 发送内容为简单文本的邮件
     *
     * @throws EmailException EmailException
     */
    public void sendSimpleTextEmail() throws EmailException {
        Email simpleEmail = new SimpleEmail();

        // 设置主机名,QQ邮箱是"smtp.qq.com",网易邮箱是"smtp.163.com"
        simpleEmail.setHostName(hostname);

        // 用户名和密码为邮箱的账号和授权码（不需要进行base64编码）
        simpleEmail.setAuthenticator(new DefaultAuthenticator(emailAddress, password));

        // 设置SSL连接
        simpleEmail.setSSLOnConnect(true);

        // 设置来源,就是发送方的邮箱地址
        simpleEmail.setFrom(emailFrom);

        // 设置主题,可以不设置
        simpleEmail.setSubject("");

        // 设置信息,就是内容,这个必须要有
        simpleEmail.setMsg("测试邮件");

        // 接收人邮箱地址
        simpleEmail.addTo(emailTo, name);

        simpleEmail.send();
    }

    /**
     * 发送包含附件的邮件
     *
     * @throws EmailException EmailException
     */
    public void sendEmailsWithAttachments() throws EmailException {
        // 创建一个attachment（附件）对象
        EmailAttachment emailAttachment = new EmailAttachment();

        // 设置上传附件的地址
        emailAttachment.setPath("E:\\download\\psb (1).jpg");
        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);

        // 附件描述
        emailAttachment.setDescription("Test Email");

        // 这个名称要注意和文件格式一致,这将是接收人下载下来的文件名称
        emailAttachment.setName("psb (1).jpg");

        // 因为要上传附件，所以用MultiPartEmail()方法创建一个email对象，固定步骤都是一样的
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(hostname);
        email.setAuthenticator(new DefaultAuthenticator(emailAddress, password));
        email.setSSLOnConnect(true);
        email.addTo(emailTo, name);
        email.setFrom(emailFrom);
        email.setSubject("图片");
        email.setMsg("Test Pictures!");

        // 将附件添加到邮件
        email.attach(emailAttachment);

        email.send();
    }

    /**
     * 发送包含附件的邮件（附件为在线资源）
     * QQ邮箱对图片兼容性不好, 建议使用163邮箱
     *
     * @throws EmailException        EmailException
     * @throws MalformedURLException MalformedURLException
     */
    public void sendEmailsWithOnlineAttachments() throws EmailException, MalformedURLException {
        EmailAttachment emailAttachment = new EmailAttachment();

        // 设置在线资源路径，和上传本地附件的唯一区别
        emailAttachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        emailAttachment.setDescription("Apache Logo");
        emailAttachment.setName("Apache logo.gif");

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(hostname);
        email.setAuthenticator(new DefaultAuthenticator(emailAddress, password));
        email.setSSLOnConnect(true);
        email.addTo(emailTo, name);
        email.setFrom(emailFrom);
        email.setSubject("The Apache Logo");
        email.setMsg("Here is Apache Logo!");
        email.attach(emailAttachment);
        email.send();
    }

    /**
     * 发送内容为HTML格式的邮件
     *
     * @throws EmailException        EmailException
     * @throws MalformedURLException MalformedURLException
     */
    public void sendHTMLFormatterEmail() throws EmailException, MalformedURLException {
        // 需要使用HtmlEmail创建一个email对象
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.163.com");
        email.setAuthenticator(new DefaultAuthenticator("eircccallroot@163.com", ""));
        email.setSSLOnConnect(true);
        email.addTo("eircccallroot@yeah.net", "ccc");
        email.setFrom("eircccallroot@163.com");
        email.setSubject("Test The Email With inline image");
        email.setMsg("The Email Template!");

        // 嵌入图像并获取内容id,虽然案例这样写，但我感觉直接在html内容里面写图片网络地址也可以
        // URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
        URL url = new URL("http://127.0.0.1:8080/kapcb/send/email?userId=4000000000017");
        String imageId = email.embed(url, "Email Template!");

        // 设置html内容
        email.setHtmlMsg(imageId);
        email.setTextMsg("您的邮箱客户端不支持html邮件!");
        email.send();
    }

    /**
     * 发送内容为HTML格式的邮件(嵌入图片更方便)
     *
     * @throws EmailException        EmailException
     * @throws MalformedURLException MalformedURLException
     */
    public void sendHTMLFormatterEmailWithEmbeddedImages() throws EmailException, MalformedURLException {
        String htmlEmailTemplate = "<img src=\"http://www.conti.com/images/1.jpg\">";
        DataSourceResolver[] dataSourceResolvers = {new DataSourceFileResolver(), new DataSourceUrlResolver(new URL("http://"))};
        ImageHtmlEmail email = new ImageHtmlEmail();
        email.setDataSourceResolver(new DataSourceCompositeResolver(dataSourceResolvers));
        email.setHostName(hostname);
        email.setAuthenticator(new DefaultAuthenticator(emailAddress, password));
        email.setSSLOnConnect(true);
        email.addTo(emailTo, name);
        email.setFrom(emailFrom);
        email.setSubject("");
        email.setMsg("");
        email.setHtmlMsg(htmlEmailTemplate);
        email.setTextMsg("您的邮箱客户端不支持html邮件!");
        email.send();
    }

}
