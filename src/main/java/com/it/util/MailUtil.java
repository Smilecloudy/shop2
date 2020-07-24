package com.it.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 邮件工具类
 */
public final class MailUtil {

    /**
     * 发送邮件
     * 参数一：发件人邮箱
     * 参数二：收件人邮箱
     * 参数三：邮件主题
     * 参数四：邮件内容
     */
    public static void sendMail(String fromEmail, String toEmail, String subject, String emailMsg) {
        try {
            //1_建立Java程序与邮件服务器的连接对象
            Properties props = new Properties();
            props.put("mail.smtp.host", "127.0.0.1");//邮件服务器中SMTP服务器的域名或IP
            Session session = Session.getInstance(props, null);

            //2_创建一封邮件
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));//发件人邮箱
            message.setRecipient(RecipientType.TO, new InternetAddress(toEmail));//收件人邮箱
            message.setSubject(subject);//主题
            message.setContent(emailMsg, "text/html;charset=UTF-8");//内容和格式编码

            //3_发送邮件
            Transport.send(message);

            System.out.println("发送邮件成功");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String fromEmail = "boss@it.com";
        String toEmail = "zhaojun@it.com";
        String subject = "注册成功";
        String emailMsg = "<h3 style='color:red'>恭喜赵君，注册成功，你的激活码1234，点击<a href='https://www.baidu.com'>激活</a></h3>";
        MailUtil.sendMail(fromEmail, toEmail, subject, emailMsg);
    }

}








