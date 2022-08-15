package com.company.accountservice.account.controller;

import com.company.accountservice.account.dto.AccountDto;
import com.company.accountservice.account.dto.AccountResponseDto;
import com.company.accountservice.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseDto> create(@RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> getAllByAccountHolderId(@RequestParam Long accountHolderId) {
        return ResponseEntity.ok(accountService.getAllByAccountHolderId(accountHolderId));
    }

    @PutMapping("/deposit")
    public ResponseEntity<AccountResponseDto> deposit(@RequestParam Long accountId, @RequestParam Double amount) {
        return ResponseEntity.ok(accountService.deposit(accountId, amount));
    }

    @PutMapping("/withdraw")
    public ResponseEntity<AccountResponseDto> withdraw(@RequestParam Long accountId, @RequestParam Double amount) {
        return ResponseEntity.ok(accountService.withdraw(accountId, amount));
    }
}
