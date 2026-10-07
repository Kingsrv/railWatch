package com.railwatch.pnr.controller;

import com.railwatch.common.exception.PnrNotFoundException;
import com.railwatch.pnr.dto.PnrResponse;
import com.railwatch.pnr.service.PnrService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PnrController.class)
class PnrControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PnrService pnrService;

    @Test
    void shouldReturnPnrResponseForValidPnr() throws Exception {

        PnrResponse response =
                new PnrResponse("1234567890", "WAITING",java.util.List.of());

        Mockito.when(pnrService.getPnr("1234567890"))
                .thenReturn(response);

        mockMvc.perform(get("/api/v1/pnr/1234567890"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pnr").value("1234567890"))
                .andExpect(jsonPath("$.status").value("WAITING"));
    }

    @Test
    void shouldRejectInvalidPnr() throws Exception {

        mockMvc.perform(get("/api/v1/pnr/123"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("INVALID_REQUEST"))
                .andExpect(jsonPath("$.message")
                        .value("PNR must be exactly 10 digits"));
    }

    @Test
    void shouldReturnNotFoundWhenPnrDoesNotExist() throws Exception {

        Mockito.when(pnrService.getPnr("9999999999"))
                .thenThrow(new PnrNotFoundException("PNR not found"));

        mockMvc.perform(get("/api/v1/pnr/9999999999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("PNR_NOT_FOUND"))
                .andExpect(jsonPath("$.message").value("PNR not found"));
    }
}