package com.mmendoza.smart_invoice_reminder.config.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    private JwtProperties jwt = new JwtProperties();
    private DefaultProperties defaultProps = new DefaultProperties();

    @Data
    public static class JwtProperties {
        private String secretKey;
        private Long expiration;
        private RefreshTokenProperties refreshToken = new RefreshTokenProperties();
    }

    @Data
    public static class RefreshTokenProperties {
        private Long expiration;
    }

    @Data
    public static class DefaultProperties {
        private String role;
    }
}

