package com.example.TrimbleCars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TrimbleCars.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
