package com.microservice.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.accounts.models.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,String>{

	
	Optional<Accounts> findByCustomerId(Long customerId);
}
