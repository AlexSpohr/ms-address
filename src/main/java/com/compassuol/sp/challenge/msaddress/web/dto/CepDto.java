package com.compassuol.sp.challenge.msaddress.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CepDto {

    @NotBlank
    private String cep;
}
