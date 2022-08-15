package com.company.accountservice.account.service.impl;

import com.company.accountservice.account.dto.AccountDto;
import com.company.accountservice.account.dto.AccountResponseDto;
import com.company.accountservice.account.mapper.AccountMapper;
import com.company.accountservice.account.repository.AccountRepository;
import com.company.accountservice.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountResponseDto save(AccountDto accountDto) {
        return accountMapper.toResponseDto(accountRepository.save(accountMapper.toEntity(accountDto)));
    }

    @Override
    public List<AccountResponseDto> getAllByAccountHolderId(Long id) {
        return accountMapper.toResponseDtoList(accountRepository.getAllByAccountHolderId(id));
    }

    @Override
    public AccountResponseDto deposit(Long accountId, Double amount) {
        return accountRepository.findById(accountId).map(account -> {
            Double currentBalance = account.getBalance();
            account.setBalance(currentBalance + amount);
            return accountMapper.toResponseDto(accountRepository.save(account));
        }).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Account not found"));
    }

    @Override
    public AccountResponseDto withdraw(Long accountId, Double amount) {
        return accountRepository.findById(accountId).map(account -> {
            Double currentBalance = account.getBalance();
            if (currentBalance >= amount) {
                account.setBalance(currentBalance - amount);
                return accountMapper.toResponseDto(accountRepository.save(account));
            }
            return null;
        }).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Account not found"));
    }
}
