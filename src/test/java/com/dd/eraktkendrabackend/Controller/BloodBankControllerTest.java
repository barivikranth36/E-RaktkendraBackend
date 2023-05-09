package com.dd.eraktkendrabackend.Controller;

import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.Service.BloodBankService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BloodBankController.class})
@ExtendWith(SpringExtension.class)
class BloodBankControllerTest {
    @Autowired
    private BloodBankController bloodBankController;

    @MockBean
    private BloodBankService bloodBankService;

    /**
     * Method under test: {@link BloodBankController#getBloodBankCities()}
     */
    @Test
    void testGetBloodBankCities() throws Exception {
        when(bloodBankService.getBloodBankCities()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bloodBank/getCitiesAndBankId");
        MockMvcBuilders.standaloneSetup(bloodBankController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BloodBankController#getBloodBankCities()}
     */
    @Test
    void testGetBloodBankCities2() throws Exception {
        when(bloodBankService.getBloodBankCities()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bloodBank/getCitiesAndBankId");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(bloodBankController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

