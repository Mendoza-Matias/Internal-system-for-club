package com.mmendoza.internal_system_for_club.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "Internal System Club",
                description = "API for club",
                contact = @Contact(
                        name = "Mendoza Matias Ezequiel",
                        email = "mendoza.e.matias@gmail.com"
                )
        )
)
@SecurityScheme(
        name = "Bearer Authentication",
        description = "JWT token that allows authorization to access resources. This can be requested when logging in from the authentication endpoint.",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {
}
