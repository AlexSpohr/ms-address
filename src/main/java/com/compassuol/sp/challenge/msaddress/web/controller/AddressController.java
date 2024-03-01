package com.compassuol.sp.challenge.msaddress.web.controller;

import com.compassuol.sp.challenge.msaddress.domain.address.entity.Address;
import com.compassuol.sp.challenge.msaddress.domain.address.service.AddressService;
import com.compassuol.sp.challenge.msaddress.web.dto.AddressResponseDto;
import com.compassuol.sp.challenge.msaddress.web.dto.mapper.AddressMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/address")
public class AddressController {
    private final AddressService addressService;

    @Operation(
            summary = "Saves address",
            description = "Saves a new address in the database",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Address saved in data base"
                            , content = @Content(mediaType = "application/json", schema = @Schema(implementation = AddressResponseDto.class)))

            })
    @PostMapping("/{cep}")
    public ResponseEntity<AddressResponseDto> saveAddress(@PathVariable String cep) {
        Address address = addressService.saveAddress(cep);
        return ResponseEntity.ok().body(AddressMapper.toDto(address));
    }

    @Operation(
            summary = "Get address by ID",
            description = "Retrieve an address by its ID",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = AddressResponseDto.class)))
            })
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDto> getAddress(@PathVariable Long id) {
        Address address = addressService.getById(id);
        return ResponseEntity.ok().body(AddressMapper.toDto(address));
    }
}
