package com.compassuol.sp.challenge.msaddress.web.dto.mapper;

import com.compassuol.sp.challenge.msaddress.domain.address.entity.Address;
import com.compassuol.sp.challenge.msaddress.web.dto.AddressResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class AddressMapper {
    public static AddressResponseDto toDto(Address address) {
        return new ModelMapper().map(address, AddressResponseDto.class);
    }

}
