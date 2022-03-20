package com.gzh.springbootmail.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author GZH
 * @date 2021-12-11
 */
public class SendMail {

    private final JavaMailSenderImpl mailSender;

    public SendMail(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * 简单邮件
     */
    public void simpleSend() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("小狂神你好呀");
        message.setText("谢谢你的狂神说Java系列课程");
        message.setTo("2473673@qq.com");
        message.setFrom("964148400@qq.com");
        mailSender.send(message);
    }

    /**
     * 复杂邮件
     */
    public void mimeSend() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("小狂神你好呀 mime");
        helper.setText("<p style='color:yellow'>谢谢你的狂神说Java系列课程</p>", true);
        helper.addAttachment("1.jpg", new File("D:\\GZH\\IdeaProjects\\SpringBootStudy\\SpringBoot-Mail\\src\\main\\resources\\static\\blue.png"));
        helper.addAttachment("2.jpg", new File("D:\\GZH\\IdeaProjects\\SpringBootStudy\\SpringBoot-Mail\\src\\main\\resources\\static\\green.png"));
        helper.setTo("2473673@qq.com");
        helper.setFrom("964148400@qq.com");
        mailSender.send(mimeMessage);
    }

}
