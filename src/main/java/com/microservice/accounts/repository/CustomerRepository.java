package com.microservice.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.accounts.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
