package com.seven6two.examples.springtest.repositories;

import com.seven6two.examples.springtest.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer save(Customer customer);
    Customer findById(int id);
    List<Customer> findAll();

}

