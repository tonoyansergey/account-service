package com.company.accountservice.account.mapper;

import com.company.accountservice.account.dto.AccountDto;
import com.company.accountservice.account.dto.AccountResponseDto;
import com.company.accountservice.account.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "accountHolder.id", source = "accountDto.accountHolderId")
    Account toEntity(AccountDto accountDto);

    @Mapping(target = "accountHolderId", source = "account.accountHolder.id")
    AccountDto toDto(Account account);

    @Mapping(target = "accountHolderId", source = "account.accountHolder.id")
    AccountResponseDto toResponseDto(Account account);

    @Mapping(target = "accountHolderId", source = "account.accountHolder.id")
    List<AccountResponseDto> toResponseDtoList(List<Account> accountList);
}
