package com.mmendoza.smart_invoice_reminder.config.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    private final EmailProperties emailProperties;

    public EmailConfig(EmailProperties emailProperties) {
        this.emailProperties = emailProperties;
    }

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailProperties.getServer().getHost());
        mailSender.setPort(emailProperties.getServer().getPort());

        mailSender.setUsername(emailProperties.getServer().getUsername());
        mailSender.setPassword(emailProperties.getServer().getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", emailProperties.getServer().getProtocol());
        props.put("mail.smtp.auth", emailProperties.getSmtp().isAuth());
        props.put("mail.smtp.starttls.enable", emailProperties.getSmtp().isStarttlsEnabled());

        return mailSender;
    }

}
