package com.mmendoza.smart_invoice_reminder.config.security;

import com.mmendoza.smart_invoice_reminder.domain.entities.Token;
import com.mmendoza.smart_invoice_reminder.repository.TokenRepository;
import com.mmendoza.smart_invoice_reminder.service.TokenService;
import com.mmendoza.smart_invoice_reminder.validator.JwtAuthenticationTokenValidator;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationTokenValidator tokenValidator;

    private static final String REFRESH_PATH = "/api/v1/authentications/refresh";

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService, JwtAuthenticationTokenValidator tokenValidator) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.tokenValidator = tokenValidator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (request.getServletPath().equals(REFRESH_PATH) || !hasBearerToken(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = jwtService.extractBearerOfToken(request.getHeader("Authorization"));
        String username = jwtService.extractUsername(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails user = userDetailsService.loadUserByUsername(username);

            if (tokenValidator.isValid(token, user)) {
                setAuthentication(request, user);
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean hasBearerToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        return authHeader != null && authHeader.startsWith("Bearer ");
    }

    private void setAuthentication(HttpServletRequest request, UserDetails user) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authToken);
    }
}
