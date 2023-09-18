package com.example.vans_back.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    USERNAME_UNAVAILABLE("Sellise kasutajanimega kasutaja on juba olemas", 222),
    DATE_UNAVAILABLE("Sellel kuupäeval on läbisõit juba süsteemis olemas", 333);

    private final String message;

    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

}
