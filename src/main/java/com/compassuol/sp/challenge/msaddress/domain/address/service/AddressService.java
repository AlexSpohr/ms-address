package com.compassuol.sp.challenge.msaddress.domain.address.service;

import com.compassuol.sp.challenge.msaddress.domain.address.entity.Address;
import com.compassuol.sp.challenge.msaddress.domain.address.repository.AddressRepository;
import com.compassuol.sp.challenge.msaddress.web.consumer.AddressConsumerFeing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressConsumerFeing addressConsumerFeing;

    public void saveAddress(String cep) {
        Address address = addressConsumerFeing.getAddressByCep(cep);
        addressRepository.save(address);
    }
}
