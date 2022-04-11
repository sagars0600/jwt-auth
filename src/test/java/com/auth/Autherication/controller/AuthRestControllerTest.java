package com.auth.Autherication.controller;


import com.auth.Autherication.enums.BloodGroup;
import com.auth.Autherication.enums.Gender;
import com.auth.Autherication.model.AuthDto;
import com.auth.Autherication.model.JWTRequest;
import com.auth.Autherication.model.UserDto;
import com.auth.Autherication.model.UserWithOutPassword;
import com.auth.Autherication.service.ServiceAuth;
import com.auth.Autherication.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@WebMvcTest(AuthRestController.class)
class AuthRestControllerTest {
    @MockBean
    ServiceAuth authService;

    @MockBean
    JwtUtil jwtUtil;

    @Autowired
    MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private UserWithOutPassword createOneUser() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date c= sdf.parse("2015-05-26");
        UserWithOutPassword user1 = new UserWithOutPassword();

        user1.setUserId("1");
        user1.setFirstName("Abbar");
        user1.setMiddleName("S");
        user1.setLastName("D");
        user1.setPhoneNumber("9090909090");
        user1.setEmail("nk@mail.com");
        user1.setDateOfBirth(c);
        user1.setEmployeeNumber("123459");
        user1.setBloodGroup(BloodGroup.A_POS);
        user1.setGender((Gender.MALE));
        user1.setAddress("Pune");
        return user1;
    }

    private UserDto createOneUserToPost() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date c= sdf.parse("2015-05-26");
        UserDto user1 = new UserDto();
        user1.setUserId("1");
        user1.setPassword("123");
        user1.setFirstName("Natsu");
        user1.setMiddleName("S");
        user1.setLastName("D");
        user1.setPhoneNumber("9090909090");
        user1.setEmail("sikhu@mail.com");
        user1.setDateOfBirth(c);
        user1.setEmployeeNumber("12345");
        user1.setBloodGroup(BloodGroup.A_POS);
        user1.setGender((Gender.MALE));
        user1.setAddress("Pune");
        return user1;

    }

    @Test
    void login() throws Exception {
        JWTRequest jwtRequest = new JWTRequest("sikhu@mail.com","123");


        UserWithOutPassword userDTO = createOneUser();
        String dummyToken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

        AuthDto authDTO=new AuthDto(dummyToken,userDTO);


        Mockito.when(authService.login(jwtRequest)).thenReturn(authDTO);
        mockMvc.perform(post("/auth/login")
                        .content(asJsonString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }




    @Test
    void register() throws Exception {

        UserDto user = createOneUserToPost();

        UserWithOutPassword userDTO = createOneUser();
        String dummyToken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

        AuthDto authDTO=new AuthDto(dummyToken,userDTO);

        Mockito.when(authService.signup(user)).thenReturn(userDTO);
        mockMvc.perform(post("/auth/signup")
                        .content(asJsonString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());


    }
}