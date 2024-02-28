package com.compassuol.sp.challenge.msaddress.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddressResponseDto {

    private Long id;
    private String cep;
    private String uf;
    private Integer ddd;
    private String localidade;
    private String logradouro;
    private String complemento;
}
