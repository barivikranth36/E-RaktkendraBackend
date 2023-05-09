package com.dd.eraktkendrabackend.Controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.DTO.BloodRequestDTO;
import com.dd.eraktkendrabackend.Service.BloodRequestService;
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

@ContextConfiguration(classes = {BloodRequestController.class})
@ExtendWith(SpringExtension.class)
class BloodRequestControllerTest {
    @Autowired
    private BloodRequestController bloodRequestController;

    @MockBean
    private BloodRequestService bloodRequestService;

    /**
     * Method under test: {@link BloodRequestController#bloodRequestByUser(BloodRequestDTO)}
     */
    @Test
    void testBloodRequestByUser() throws Exception {
        when(bloodRequestService.bloodRequestByUser(Mockito.<BloodRequestDTO>any())).thenReturn(true);

        BloodRequestDTO bloodRequestDTO = new BloodRequestDTO();
        bloodRequestDTO.setBloodBankId(1L);
        bloodRequestDTO.setBloodRequestId(1L);
        bloodRequestDTO.setBloodType("Blood Type");
        bloodRequestDTO.setQuantity(1L);
        bloodRequestDTO.setTotalCost(1L);
        bloodRequestDTO.setUserId(1L);
        String content = (new ObjectMapper()).writeValueAsString(bloodRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bloodRequest/bloodRequestByUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link BloodRequestController#bloodRequestByUser(BloodRequestDTO)}
     */
    @Test
    void testBloodRequestByUser2() throws Exception {
        when(bloodRequestService.bloodRequestByUser(Mockito.<BloodRequestDTO>any())).thenReturn(false);

        BloodRequestDTO bloodRequestDTO = new BloodRequestDTO();
        bloodRequestDTO.setBloodBankId(1L);
        bloodRequestDTO.setBloodRequestId(1L);
        bloodRequestDTO.setBloodType("Blood Type");
        bloodRequestDTO.setQuantity(1L);
        bloodRequestDTO.setTotalCost(1L);
        bloodRequestDTO.setUserId(1L);
        String content = (new ObjectMapper()).writeValueAsString(bloodRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bloodRequest/bloodRequestByUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link BloodRequestController#checkBloodRequest(String)}
     */
    @Test
    void testCheckBloodRequest() throws Exception {
        when(bloodRequestService.checkBloodRequest(anyLong())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bloodRequest/checkBloodRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link BloodRequestController#checkBloodRequest(String)}
     */
    @Test
    void testCheckBloodRequest2() throws Exception {
        when(bloodRequestService.checkBloodRequest(anyLong())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bloodRequest/checkBloodRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link BloodRequestController#revokeBloodRequest(String)}
     */
    @Test
    void testRevokeBloodRequest() throws Exception {
        when(bloodRequestService.revokeBloodRequest(anyLong())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodRequest/revokeBloodRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link BloodRequestController#revokeBloodRequest(String)}
     */
    @Test
    void testRevokeBloodRequest2() throws Exception {
        when(bloodRequestService.revokeBloodRequest(anyLong())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodRequest/revokeBloodRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link BloodRequestController#acceptBloodRequest(String)}
     */
    @Test
    void testAcceptBloodRequest() throws Exception {
        when(bloodRequestService.acceptBloodRequest(anyLong())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodRequest/acceptBloodRequest/{bloodRequestId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link BloodRequestController#acceptBloodRequest(String)}
     */
    @Test
    void testAcceptBloodRequest2() throws Exception {
        when(bloodRequestService.acceptBloodRequest(anyLong())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodRequest/acceptBloodRequest/{bloodRequestId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link BloodRequestController#getAllBloodRequests(String)}
     */
    @Test
    void testGetAllBloodRequests() throws Exception {
        when(bloodRequestService.getAllBloodRequests(anyLong())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bloodRequest/getAllBloodRequests/{bankId}", "42");
        MockMvcBuilders.standaloneSetup(bloodRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BloodRequestController#rejectBloodRequest(String)}
     */
    @Test
    void testRejectBloodRequest() throws Exception {
        when(bloodRequestService.revokeBloodRequest(anyLong())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodRequest/rejectBloodRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link BloodRequestController#rejectBloodRequest(String)}
     */
    @Test
    void testRejectBloodRequest2() throws Exception {
        when(bloodRequestService.revokeBloodRequest(anyLong())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/bloodRequest/rejectBloodRequest/{userId}", "42");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(bloodRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }
}

