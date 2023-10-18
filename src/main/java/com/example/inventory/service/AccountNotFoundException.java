package com.example.inventory.service;

import lombok.Data;

@Data
public class AccountNotFoundException extends RuntimeException {

    private String message;
    AccountNotFoundException(String message) {
    }

}
