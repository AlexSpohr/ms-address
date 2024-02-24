package com.compassuol.sp.challenge.msaddress.web.controller;

import com.compassuol.sp.challenge.msaddress.domain.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/{cep}")
    public ResponseEntity<Void> saveAddress(@PathVariable String cep) {
        addressService.saveAddress(cep);
        return ResponseEntity.ok().build();
    }

}
