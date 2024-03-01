package com.compassuol.sp.challenge.msaddress.web.controller;

import com.compassuol.sp.challenge.msaddress.domain.address.entity.Address;
import com.compassuol.sp.challenge.msaddress.domain.address.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = AddressController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AddressControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    AddressService addressService;

    @Test
    void saveAddress_WithValidCep_ReturnsOk200() throws Exception {
        Address validAddress = new Address();

        when(addressService.saveAddress(any())).thenReturn(validAddress);

        mockMvc
                .perform(
                        post("/v1/address/{cep}", "validCep")
                                .header("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZTJAZW1haWwuY29tIiwiaWF0IjoxNzA5MjMxOTY0LCJleHAiOjE3MDkyMzI1NjR9.VxjeDLGyZsFQle5yIml-bmYg-23JmOtvL33QbDCiE98")
                                .content(objectMapper.writeValueAsString(validAddress))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAddress_WithValidId_ReturnsOk200() throws Exception {
        Address validAddress = new Address();

        when(addressService.getById(any())).thenReturn(validAddress);

        mockMvc
                .perform(
                        get("/v1/address/{id}", 1L)
                                .header("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZTJAZW1haWwuY29tIiwiaWF0IjoxNzA5MjMxOTY0LCJleHAiOjE3MDkyMzI1NjR9.VxjeDLGyZsFQle5yIml-bmYg-23JmOtvL33QbDCiE98")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
