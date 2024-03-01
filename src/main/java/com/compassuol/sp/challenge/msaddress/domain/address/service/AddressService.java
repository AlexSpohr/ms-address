package com.compassuol.sp.challenge.msaddress.domain.address.service;

import com.compassuol.sp.challenge.msaddress.domain.address.entity.Address;
import com.compassuol.sp.challenge.msaddress.domain.address.repository.AddressRepository;
import com.compassuol.sp.challenge.msaddress.web.consumer.AddressConsumerFeing;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressConsumerFeing addressConsumerFeing;

    public Address saveAddress(String cep) {
        cep = cep.replace("-", "");
        Address address;
        if (addressRepository.existsByCep(cep)) {
            address = addressRepository.findByCep(cep);
        } else {
            address = addressConsumerFeing.getAddressByCep(cep);
            address.setCep(cep);
            address = addressRepository.save(address);
        }
        return address;
    }

    @Transactional(readOnly = true)
    public Address getById(Long id) {
        return addressRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not found.")
        );
    }

}
