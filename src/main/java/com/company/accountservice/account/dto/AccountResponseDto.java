package com.company.accountservice.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {

    private Long id;
    private String accountNumber;
    private Double balance;
    private Currency currency;
    private Long accountHolderId;
}
