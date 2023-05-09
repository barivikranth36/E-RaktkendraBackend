package com.dd.eraktkendrabackend.Controller;

import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.DTO.FieldWorkerDTO;
import com.dd.eraktkendrabackend.DTO.LoginDTO;
import com.dd.eraktkendrabackend.Service.FieldWorkerService;
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

@ContextConfiguration(classes = {FieldWorkerController.class})
@ExtendWith(SpringExtension.class)
class FieldWorkerControllerTest {
    @Autowired
    private FieldWorkerController fieldWorkerController;

    @MockBean
    private FieldWorkerService fieldWorkerService;

    /**
     * Method under test: {@link FieldWorkerController#registerFieldWorker(FieldWorkerDTO)}
     */
    @Test
    void testRegisterFieldWorker() throws Exception {
        when(fieldWorkerService.registerFieldWorker(Mockito.<FieldWorkerDTO>any())).thenReturn(new FieldWorkerDTO());

        FieldWorkerDTO fieldWorkerDTO = new FieldWorkerDTO();
        fieldWorkerDTO.setAddress("42 Main St");
        fieldWorkerDTO.setBloodBankId(1L);
        fieldWorkerDTO.setCity("Oxford");
        fieldWorkerDTO.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        fieldWorkerDTO.setEmailId("42");
        fieldWorkerDTO.setFirstName("Jane");
        fieldWorkerDTO.setGender("Gender");
        fieldWorkerDTO.setLastName("Doe");
        fieldWorkerDTO.setPassword("iloveyou");
        fieldWorkerDTO.setPhoneNumber("6625550144");
        fieldWorkerDTO.setPincode(1L);
        fieldWorkerDTO.setTitle("Dr");
        fieldWorkerDTO.setWorkerId(1L);
        String content = (new ObjectMapper()).writeValueAsString(fieldWorkerDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/fieldWorker/registerFieldWorker")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(fieldWorkerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"workerId\":0,\"title\":null,\"firstName\":null,\"lastName\":null,\"dob\":null,\"gender\":null,\"phoneNumber\""
                                        + ":null,\"emailId\":null,\"address\":null,\"city\":null,\"password\":null,\"pincode\":0,\"bloodBankId\":0}"));
    }

    /**
     * Method under test: {@link FieldWorkerController#fieldWorkerLogin(LoginDTO)}
     */
    @Test
    void testFieldWorkerLogin() throws Exception {
        when(fieldWorkerService.fieldWorkerLogin(Mockito.<LoginDTO>any())).thenReturn(new FieldWorkerDTO());

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPassword("iloveyou");
        loginDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/fieldWorker/workerLogin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(fieldWorkerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"workerId\":0,\"title\":null,\"firstName\":null,\"lastName\":null,\"dob\":null,\"gender\":null,\"phoneNumber\""
                                        + ":null,\"emailId\":null,\"address\":null,\"city\":null,\"password\":null,\"pincode\":0,\"bloodBankId\":0}"));
    }
}

