package com.mmendoza.internal_system_for_club.infrastructure.adapters.in.http;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private RegisterUserUserService registerUserService;
//
//    @Test
//    void should_call_use_case() throws Exception {
//
//        Mockito.doNothing()
//                .when(registerUserService)
//                .register(Mockito.any(User.class));
//
//        mockMvc.perform(post("/api/v1/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                    {
//                      "username": "username",
//                      "email": "username@email.com",
//                      "password": "password"
//                    }
//                """))
//                .andExpect(status().isCreated());
//
//        Mockito.verify(registerUserService)
//                .register(Mockito.any(User.class));
//    }
}