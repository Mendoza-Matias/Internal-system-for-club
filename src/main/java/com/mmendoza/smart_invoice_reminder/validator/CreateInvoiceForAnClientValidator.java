package com.mmendoza.smart_invoice_reminder.validator;

import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateInvoiceForAnClientRequest;
import com.mmendoza.smart_invoice_reminder.validator.rules.DescriptionValidationRule;
import com.mmendoza.smart_invoice_reminder.validator.rules.PaymentDeadLineValidationRule;
import com.mmendoza.smart_invoice_reminder.validator.rules.PriceValidationRule;
import com.mmendoza.smart_invoice_reminder.validator.rules.TitleValidationRule;
import org.springframework.stereotype.Component;

@Component
public class CreateInvoiceForAnClientValidator {

    private final TitleValidationRule titleValidationRule;
    private final DescriptionValidationRule descriptionValidationRule;
    private final PriceValidationRule priceValidationRule;
    private final PaymentDeadLineValidationRule paymentDeadLineValidationRule;

    public CreateInvoiceForAnClientValidator(TitleValidationRule titleValidationRule, DescriptionValidationRule descriptionValidationRule, PriceValidationRule priceValidationRule, PaymentDeadLineValidationRule paymentDeadLineValidationRule) {
        this.titleValidationRule = titleValidationRule;
        this.descriptionValidationRule = descriptionValidationRule;
        this.priceValidationRule = priceValidationRule;
        this.paymentDeadLineValidationRule = paymentDeadLineValidationRule;
    }

    public void validate(CreateInvoiceForAnClientRequest request) {
        titleValidationRule.validate(request.title());
        descriptionValidationRule.validate(request.description());
        priceValidationRule.validate(request.price());
        paymentDeadLineValidationRule.validate(request.paymentDeadline());
    }
}
