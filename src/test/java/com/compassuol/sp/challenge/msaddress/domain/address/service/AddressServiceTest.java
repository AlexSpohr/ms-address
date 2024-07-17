package com.compassuol.sp.challenge.msaddress.domain.address.service;

import com.compassuol.sp.challenge.msaddress.domain.address.entity.Address;
import com.compassuol.sp.challenge.msaddress.domain.address.repository.AddressRepository;
import com.compassuol.sp.challenge.msaddress.web.consumer.AddressConsumerFeing;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AddressServiceTest {

    @Mock
    AddressRepository addressRepository;

    @Mock
    AddressConsumerFeing addressConsumerFeing;

    @InjectMocks
    AddressService addressService;

    @Test
    public void saveAddress_WithValidCep_ReturnsAddress() {
        String validCep = "validCep";
        Address validAddress = new Address();

        when(addressRepository.existsByCep(any())).thenReturn(false);
        when(addressConsumerFeing.getAddressByCep(any())).thenReturn(validAddress);
        when(addressRepository.save(any())).thenReturn(validAddress);

        Address result = addressService.saveAddress(validCep);

        assertEquals(validAddress, result);
    }

    @Test
    public void getById_WithValidId_ReturnsAddress() {
        Long validId = 1L;
        Address validAddress = new Address();

        when(addressRepository.findById(any())).thenReturn(Optional.of(validAddress));

        Address result = addressService.getById(validId);

        assertEquals(validAddress, result);
    }
}