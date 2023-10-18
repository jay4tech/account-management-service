package com.example.inventory.model;

import lombok.Data;

@Data
public class DebitCreditDetails {
    private Long id;
    private Long accountNo;
    private Double amount;
}
