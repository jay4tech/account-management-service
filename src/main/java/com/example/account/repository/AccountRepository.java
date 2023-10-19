package com.example.account.repository;

import com.example.account.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountDetails, Long> {
}
