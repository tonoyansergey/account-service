package com.company.accountservice.account.repository;

import com.company.accountservice.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> getAllByAccountHolderId(Long id);

    @Override
    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Account> findById(Long aLong);
}
