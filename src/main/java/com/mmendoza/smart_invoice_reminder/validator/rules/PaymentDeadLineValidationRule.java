package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.InvoiceError;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class PaymentDeadLineValidationRule {

    public void validate(LocalDate paymentDeadline) {
        if (paymentDeadline == null) {
            throw invalidDeadline();
        }

        if (paymentDeadline.isBefore(LocalDate.now())) {
            throw invalidDeadline();
        }

        if (isWeekend(paymentDeadline)) {
            throw new ValidationException(
                    InvoiceError.PAYMENT_DEADLINE_NOT_WEEKEND.getMessage()
            );
        }
    }

    private boolean isWeekend(LocalDate paymentDeadline) {
        DayOfWeek day = paymentDeadline.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    private ValidationException invalidDeadline() {
        return new ValidationException(
                InvoiceError.PAYMENT_DEADLINE_INVALID.getMessage()
        );
    }
}
