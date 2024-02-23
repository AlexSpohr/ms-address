package com.compassuol.sp.challenge.msaddress.domain.address.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "addresses")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cep", nullable = false, length = 120)
    private String cep;
    @Column(name = "uf", nullable = false, length = 2)
    private String uf;
    @Column(name = "ddd", length = 80)
    private Integer ddd;
    @Column(name = "localidade", nullable = false, length = 120)
    private String localidade;
    @Column(name = "logradouro", nullable = false, length = 100)
    private String logradouro;
    @Column(name = "complemento", nullable = false, length = 100)
    private String complemento;


}
