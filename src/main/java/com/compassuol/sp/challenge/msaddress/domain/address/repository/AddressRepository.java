package com.compassuol.sp.challenge.msaddress.domain.address.repository;

import com.compassuol.sp.challenge.msaddress.domain.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    boolean existsByCep(String cep);

    Address findByCep(String cep);
}
