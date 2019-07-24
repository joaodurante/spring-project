package com.joaodurante.springfirst.repositories;

import com.joaodurante.springfirst.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // spring automatically creates the method based on his name
    @Transactional(readOnly = true)
    Customer findByEmail(String email);
}
