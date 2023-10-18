package com.example.inventory.exception;

import lombok.Data;

@Data
public class AccountNotFoundException extends RuntimeException {

    private String message;
    public AccountNotFoundException(String message) {
    }

}
