package com.mmendoza.smart_invoice_reminder.config.email;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mail")
public class EmailProperties {

    private Server server = new Server();
    private Smtp smtp = new Smtp();

    @Data
    public static class Server {
        private String host;
        private int port;
        private String username;
        private String password;
        private String protocol;
    }

    @Data
    public static class Smtp {
        private boolean auth;
        private boolean starttlsEnabled;
    }
}
