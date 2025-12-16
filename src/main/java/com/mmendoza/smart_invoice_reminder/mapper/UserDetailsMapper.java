package com.mmendoza.smart_invoice_reminder.mapper;

import com.mmendoza.smart_invoice_reminder.config.security.UserDetailsService;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {

    public UserDetails toUserDetails(User user) {
        return new UserDetailsService(user);
    }

}
