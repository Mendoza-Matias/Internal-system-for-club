package com.mmendoza.internal.infrastructure.adapters.in.http;

import com.mmendoza.internal.application.service.user.RegisterUserService;
import com.mmendoza.internal.domain.model.User;
import com.mmendoza.internal.domain.ports.in.RegisterUserUseCase;
import jakarta.servlet.ServletContext;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RegisterUserService registerUserService;

    @Test
    void should_call_use_case() throws Exception {

        Mockito.doNothing()
                .when(registerUserService)
                .register(Mockito.any(User.class));

        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                    {
                      "username": "username",
                      "email": "username@email.com",
                      "password": "password"
                    }
                """))
                .andExpect(status().isCreated());

        Mockito.verify(registerUserService)
                .register(Mockito.any(User.class));
    }
}