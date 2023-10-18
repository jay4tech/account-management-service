package com.example.inventory.repository;

import com.example.inventory.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountDetails, Long> {
    AccountDetails getInventoryByProductId(Long productId);
}
