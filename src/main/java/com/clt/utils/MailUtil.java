package com.clt.utils;

import com.clt.entity.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ：clt
 * @Date ：Created in 19:27 2020/02/25
 */
@Component
public class MailUtil {

    /**
     * 邮件发送者
     */
    @Value("${spring.mail.username}")
    private String MAIL_SENDER;

    @Autowired
    private JavaMailSender javaMailSender;


    private Logger logger = LoggerFactory.getLogger(MailUtil.class);

    /**
     * 发送文本邮件
     *
     * @param Email
     */
    @Async
    public void sendSimpleMail(Email Email) {
        logger.info("开始发送邮件");
        long start = System.currentTimeMillis();
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(MAIL_SENDER);
            mailMessage.setTo(Email.getRecipient());
            mailMessage.setSubject(Email.getSubject());
            mailMessage.setText(Email.getContent());
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            logger.error("邮件发送失败", e.getMessage());
        }
        logger.info("邮件发送成功，耗时" + (System.currentTimeMillis() - start) + "毫米");
    }


}
