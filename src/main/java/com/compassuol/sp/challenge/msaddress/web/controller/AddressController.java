package com.compassuol.sp.challenge.msaddress.web.controller;

import com.compassuol.sp.challenge.msaddress.domain.address.entity.Address;
import com.compassuol.sp.challenge.msaddress.domain.address.service.AddressService;
import com.compassuol.sp.challenge.msaddress.web.dto.AddressResponseDto;
import com.compassuol.sp.challenge.msaddress.web.dto.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/{cep}")
    public ResponseEntity<AddressResponseDto> saveAddress(@PathVariable String cep) {
        Address address = addressService.saveAddress(cep);
        return ResponseEntity.ok().body(AddressMapper.toDto(address));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDto> getAddress(@PathVariable Long id) {
        Address address = addressService.getById(id);
        return ResponseEntity.ok().body(AddressMapper.toDto(address));
    }
}
