package com.mmendoza.smart_invoice_reminder.validator;

import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateClientRequest;
import com.mmendoza.smart_invoice_reminder.validator.rules.AddressValidationRule;
import com.mmendoza.smart_invoice_reminder.validator.rules.EmailValidationRule;
import com.mmendoza.smart_invoice_reminder.validator.rules.NameValidationRule;
import com.mmendoza.smart_invoice_reminder.validator.rules.TelephoneValidationRule;
import org.springframework.stereotype.Component;

@Component
public class CreateClientRequestValidator {

    private final NameValidationRule nameValidationRule;
    private final TelephoneValidationRule telephoneValidationRule;
    private final EmailValidationRule emailValidationRule;
    private final AddressValidationRule addressValidationRule;

    public CreateClientRequestValidator(NameValidationRule nameValidationRule, TelephoneValidationRule telephoneValidationRule, EmailValidationRule emailValidationRule, AddressValidationRule addressValidationRule) {
        this.nameValidationRule = nameValidationRule;
        this.telephoneValidationRule = telephoneValidationRule;
        this.emailValidationRule = emailValidationRule;
        this.addressValidationRule = addressValidationRule;
    }

    public void validate(CreateClientRequest request) {
        nameValidationRule.validate(request.name());
        nameValidationRule.validate(request.lastName());
        emailValidationRule.validate(request.email());
        telephoneValidationRule.validate(request.telephone());
        addressValidationRule.validate(request.address());
    }
}
