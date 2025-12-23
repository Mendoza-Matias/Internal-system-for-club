package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.dtos.SendPaymentReminderRequest;
import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;
import com.mmendoza.smart_invoice_reminder.exceptions.NotificationException;
import com.mmendoza.smart_invoice_reminder.service.NotificationService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
public class EmailNotificationServiceImpl implements NotificationService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public EmailNotificationServiceImpl(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendPaymentReminder(Invoice request) {
        try {
            String htmlBody = buildHtmlBody(request);
            sendEmail(request, htmlBody);
        } catch (Exception e) {
            throw new NotificationException("Error sending payment reminder");
        }
    }

    private String buildHtmlBody(Invoice invoice) {
        Context context = new Context();
        context.setVariable("name", invoice.getClient().getName());
        context.setVariable("amount", invoice.getPrice());
        context.setVariable("deadline", invoice.getPaymentDeadline());

        return templateEngine.process("payment-reminder", context);
    }

    private void sendEmail(Invoice invoice, String htmlBody) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(invoice.getClient().getEmail());
        helper.setSubject("Recordatorio de pago");
        helper.setText(htmlBody, true);

        mailSender.send(message);
    }
}
