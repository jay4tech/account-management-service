package com.example.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long name;
    private Double totalAmount;
    private String emailId;
    private String moibleNo;
    private String panCard;
    private String adharCard;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

}
