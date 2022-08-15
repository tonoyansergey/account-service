package com.company.accountservice.account.service;

import com.company.accountservice.account.dto.AccountDto;
import com.company.accountservice.account.dto.AccountResponseDto;

import java.util.List;

public interface AccountService {

    AccountResponseDto save(AccountDto accountDto);
    List<AccountResponseDto> getAllByAccountHolderId(Long id);

    AccountResponseDto deposit(Long accountId, Double amount);

    AccountResponseDto withdraw(Long accountId, Double amount);
}
