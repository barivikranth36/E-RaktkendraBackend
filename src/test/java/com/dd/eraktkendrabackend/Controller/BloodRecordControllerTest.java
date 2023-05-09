package com.dd.eraktkendrabackend.Controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.Service.BloodRecordService;

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

@ContextConfiguration(classes = {BloodRecordController.class})
@ExtendWith(SpringExtension.class)
class BloodRecordControllerTest {
    @Autowired
    private BloodRecordController bloodRecordController;

    @MockBean
    private BloodRecordService bloodRecordService;

    /**
     * Method under test: {@link BloodRecordController#getBloodRecord(String)}
     */
    @Test
    void testGetBloodRecord() throws Exception {
        when(bloodRecordService.getBloodRecord(anyLong())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bloodRecord/getBloodRecord/{bloodBankId}", "42");
        MockMvcBuilders.standaloneSetup(bloodRecordController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

