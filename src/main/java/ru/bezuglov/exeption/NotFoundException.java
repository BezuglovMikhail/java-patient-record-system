package ru.bezuglov.exeption;

import lombok.Getter;

public class NotFoundException extends RuntimeException {

    private static final String REASON = "The required object was not found.";

    @Getter
    private final String reason;

    public NotFoundException(String reason, String message) {
        super(message);
        this.reason = reason;
    }

    public NotFoundException(String message) {
        this(REASON, message);
    }
}