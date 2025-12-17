package com.mmendoza.smart_invoice_reminder.config.beans;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.mmendoza.smart_invoice_reminder.exceptions.ResourceNotFoundException;
import com.mmendoza.smart_invoice_reminder.mapper.UserDetailsMapper;
import com.mmendoza.smart_invoice_reminder.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityBeans {

    //TODO
    private final UserRepository userRepository;
    private final UserDetailsMapper userDetailsMapper;

    private static final String USER_NOT_FOUND = "User not found";

    public SecurityBeans(UserRepository userRepository, UserDetailsMapper userDetailsMapper) {
        this.userRepository = userRepository;
        this.userDetailsMapper = userDetailsMapper;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userDetailsMapper.toUserDetails(
                userRepository.findByEmail(username)
                        .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND))
        );
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
