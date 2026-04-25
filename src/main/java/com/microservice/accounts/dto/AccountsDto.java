package com.microservice.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AccountsDto {


    @NotEmpty(message="account number can not be null or empty")
	@Pattern(regexp="(^$|[0-9]{10}")
	private Long accountNumber;

    @NotEmpty(message="account type can not be null or empty")
	private String accountType;

    @NotEmpty(message="branch address can not be null or empty")
	private String branchAddress;
}
