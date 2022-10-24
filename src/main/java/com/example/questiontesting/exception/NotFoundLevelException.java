package com.example.questiontesting.exception;

public class NotFoundLevelException extends RuntimeException {

    public NotFoundLevelException(Long id) {
        super("Not found Level with id=" + id);
    }
}
