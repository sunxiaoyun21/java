package com.sxy.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * Created by Administrator on 2016/12/16.
 */
public class SendEmail {

    public static void sendEmailHtml(String toAddress,String subject,String context){
        HtmlEmail htmlEmail=new HtmlEmail();
        htmlEmail.setHostName(Config.get("email.smpt"));
        htmlEmail.setSmtpPort(Integer.valueOf(Config.get("email.port")));
        htmlEmail.setAuthentication(Config.get("email.username"),Config.get("email.password"));
        htmlEmail.setCharset("UTF-8");
        htmlEmail.setStartTLSEnabled(true);

        try {
            htmlEmail.setFrom(Config.get("email.frommail"));
            htmlEmail.setSubject(subject);
            htmlEmail.setHtmlMsg(context);
            htmlEmail.addTo(toAddress);

            htmlEmail.send();
        } catch (EmailException e) {
            e.printStackTrace();
            throw new RuntimeException("发送邮件失败"+toAddress);
        }


    }
}
