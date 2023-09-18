package com.example.vans_back.business;

import lombok.Getter;

@Getter
public enum Status {
    SENT("S"),
    READ("R"),
    ACTIVE("A"),
    DELETED("D");

    private final String letter;

    Status(String letter) {
        this.letter = letter;
    }
}