package com.dd.eraktkendrabackend.Controller;

import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.DTO.LoginDTO;
import com.dd.eraktkendrabackend.Entity.User;
import com.dd.eraktkendrabackend.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#addUser(User)}
     */
    @Test
    void testAddUser() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setBloodType("Blood Type");
        user.setCity("Oxford");
        user.setCredit(1);
        user.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setPincode(1L);
        user.setTitle("Dr");
        user.setUserId(1L);
        when(userService.addUser(Mockito.<User>any())).thenReturn(user);

        User user2 = new User();
        user2.setAddress("42 Main St");
        user2.setBloodType("Blood Type");
        user2.setCity("Oxford");
        user2.setCredit(1);
        user2.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setEmailId("42");
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setPincode(1L);
        user2.setTitle("Dr");
        user2.setUserId(1L);
        String content = (new ObjectMapper()).writeValueAsString(user2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"userId\":1,\"title\":\"Dr\",\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"dob\":0,\"gender\":\"Gender\",\"phoneNumber\""
                                        + ":\"6625550144\",\"emailId\":\"42\",\"password\":\"iloveyou\",\"bloodType\":\"Blood Type\",\"address\":\"42 Main"
                                        + " St\",\"city\":\"Oxford\",\"pincode\":1,\"credit\":1}"));
    }

    /**
     * Method under test: {@link UserController#userLogin(LoginDTO)}
     */
    @Test
    void testUserLogin() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setBloodType("Blood Type");
        user.setCity("Oxford");
        user.setCredit(1);
        user.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setPincode(1L);
        user.setTitle("Dr");
        user.setUserId(1L);
        when(userService.userLogin(Mockito.<LoginDTO>any())).thenReturn(user);

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPassword("iloveyou");
        loginDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/userLogin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"userId\":1,\"title\":\"Dr\",\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"dob\":0,\"gender\":\"Gender\",\"phoneNumber\""
                                        + ":\"6625550144\",\"emailId\":\"42\",\"password\":\"iloveyou\",\"bloodType\":\"Blood Type\",\"address\":\"42 Main"
                                        + " St\",\"city\":\"Oxford\",\"pincode\":1,\"credit\":1}"));
    }
}

