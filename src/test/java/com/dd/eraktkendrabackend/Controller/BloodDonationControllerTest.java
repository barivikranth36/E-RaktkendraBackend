package com.dd.eraktkendrabackend.Controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.DTO.BloodDonationRequestDTO;
import com.dd.eraktkendrabackend.Service.BloodDonationRequestService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BloodDonationController.class})
@ExtendWith(SpringExtension.class)
class BloodDonationControllerTest {
    @Autowired
    private BloodDonationController bloodDonationController;

    @MockBean
    private BloodDonationRequestService bloodDonationRequestService;

    /**
     * Method under test: {@link BloodDonationController#bloodDonationRequest(BloodDonationRequestDTO)}
     */
    @Test
    void testBloodDonationRequest() throws Exception {
        when(bloodDonationRequestService.bloodDonationRequest(Mockito.<BloodDonationRequestDTO>any())).thenReturn(true);

        BloodDonationRequestDTO bloodDonationRequestDTO = new BloodDonationRequestDTO();
        bloodDonationRequestDTO.setBankId(1L);
        bloodDonationRequestDTO.setBloodDonationRequestId(1L);
        bloodDonationRequestDTO.setBloodType("Blood Type");
        bloodDonationRequestDTO.setUserId(1L);
        String content = (new ObjectMapper()).writeValueAsString(bloodDonationRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bloodDonation/bloodDonationRequest")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link BloodDonationController#bloodDonationRequest(BloodDonationRequestDTO)}
     */
    @Test
    void testBloodDonationRequest2() throws Exception {
        when(bloodDonationRequestService.bloodDonationRequest(Mockito.<BloodDonationRequestDTO>any())).thenReturn(false);

        BloodDonationRequestDTO bloodDonationRequestDTO = new BloodDonationRequestDTO();
        bloodDonationRequestDTO.setBankId(1L);
        bloodDonationRequestDTO.setBloodDonationRequestId(1L);
        bloodDonationRequestDTO.setBloodType("Blood Type");
        bloodDonationRequestDTO.setUserId(1L);
        String content = (new ObjectMapper()).writeValueAsString(bloodDonationRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bloodDonation/bloodDonationRequest")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link BloodDonationController#revokeBloodDonationRequest(String)}
     */
    @Test
    void testRevokeBloodDonationRequest() throws Exception {
        when(bloodDonationRequestService.revokeBloodDonationRequest(anyLong())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodDonation/revokeBloodDonationRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link BloodDonationController#revokeBloodDonationRequest(String)}
     */
    @Test
    void testRevokeBloodDonationRequest2() throws Exception {
        when(bloodDonationRequestService.revokeBloodDonationRequest(anyLong())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodDonation/revokeBloodDonationRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link BloodDonationController#checkBloodDonationRequest(String)}
     */
    @Test
    void testCheckBloodDonationRequest() throws Exception {
        when(bloodDonationRequestService.checkBloodDonationRequest(anyLong())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bloodDonation/checkBloodDonationRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link BloodDonationController#checkBloodDonationRequest(String)}
     */
    @Test
    void testCheckBloodDonationRequest2() throws Exception {
        when(bloodDonationRequestService.checkBloodDonationRequest(anyLong())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bloodDonation/checkBloodDonationRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link BloodDonationController#acceptBloodDonationRequest(String)}
     */
    @Test
    void testAcceptBloodDonationRequest() throws Exception {
        when(bloodDonationRequestService.acceptBloodDonationRequest(anyLong())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodDonation/acceptBloodDonationRequest/{donationRequestId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link BloodDonationController#acceptBloodDonationRequest(String)}
     */
    @Test
    void testAcceptBloodDonationRequest2() throws Exception {
        when(bloodDonationRequestService.acceptBloodDonationRequest(anyLong())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodDonation/acceptBloodDonationRequest/{donationRequestId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link BloodDonationController#getAllBloodDonationRequests(String)}
     */
    @Test
    void testGetAllBloodDonationRequests() throws Exception {
        when(bloodDonationRequestService.getAllBloodDonationRequests(anyLong())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bloodDonation/getAllBloodDonationRequests/{bankId}", "42");
        MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BloodDonationController#getBloodDonationHistory(String)}
     */
    @Test
    void testGetBloodDonationHistory() throws Exception {
        when(bloodDonationRequestService.getBloodDonationHistory(anyLong())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bloodDonation/getBloodDonationHistory/{userId}", "42");
        MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BloodDonationController#deleteBloodDonationRequest(String)}
     */
    @Test
    void testDeleteBloodDonationRequest() throws Exception {
        when(bloodDonationRequestService.revokeBloodDonationRequest(anyLong())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodDonation/deleteBloodDonationRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link BloodDonationController#deleteBloodDonationRequest(String)}
     */
    @Test
    void testDeleteBloodDonationRequest2() throws Exception {
        when(bloodDonationRequestService.revokeBloodDonationRequest(anyLong())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodDonation/deleteBloodDonationRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodDonationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }
}

