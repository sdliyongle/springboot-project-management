package com.example.springbootprojectmanagement.service;

public interface IMailService {
    /**
     *  发送多媒体类型邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendMimeMail(String to, String subject, String content);

    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
